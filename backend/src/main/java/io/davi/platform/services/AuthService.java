package io.davi.platform.services;

import io.davi.platform.entities.User;
import io.davi.platform.repositories.UserRepository;
import io.davi.platform.services.exceptions.ForbiddenException;
import io.davi.platform.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext()
                    .getAuthentication().getName();
            return userRepository.findByEmail(username);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateSelfOrAdmin(Long userId) {
        User user = authenticated();
        if (!(user.getId().equals(userId)) && !(user.hasRole("ROLE_ADMIN"))) {
            throw new ForbiddenException("Access denied");
        }
    }
}

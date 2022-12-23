package io.davi.platform.services;

import io.davi.platform.dto.NotificationDTO;
import io.davi.platform.entities.Notification;
import io.davi.platform.entities.User;
import io.davi.platform.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private AuthService authService;

    public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> page = repository.findByUser(user, pageable);
        return page.map(x -> new NotificationDTO(x));
    }
}

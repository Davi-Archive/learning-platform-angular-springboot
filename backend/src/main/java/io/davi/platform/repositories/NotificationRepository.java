package io.davi.platform.repositories;

import io.davi.platform.entities.Notification;
import io.davi.platform.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {

    Page<Notification> findByUser(User user, Pageable pageable);
}

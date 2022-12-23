package io.davi.platform.resources;

import io.davi.platform.dto.NotificationDTO;
import io.davi.platform.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

    @Autowired
    private NotificationService service;

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> notificationForCurrentUser(Pageable pageable) {
        Page<NotificationDTO> page = service.notificationsForCurrentUser(pageable);
        return ResponseEntity.ok().body(page);
    }
}

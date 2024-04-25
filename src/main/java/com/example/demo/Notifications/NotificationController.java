package com.example.demo.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<?> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("/unread")
    public ResponseEntity<?> getUnreadNotifications() {
        return ResponseEntity.ok(notificationService.getUnreadNotifications());
    }

    @GetMapping("/read")
    public ResponseEntity<?> getReadNotifications() {
        return ResponseEntity.ok(notificationService.getReadNotifications());
    }

    @PostMapping("/{id}/mark-as-read")
    public ResponseEntity<?> markAsRead(Long id) {
        notificationService.markAsRead(id);
        return ResponseEntity.ok().build();
    }
}

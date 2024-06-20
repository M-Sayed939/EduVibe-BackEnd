package com.example.demo.Notifications;

import com.example.demo.Notes.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNote = notificationService.saveOrUpdateNotification(notification);
        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllNotifications(@PathVariable Long userId) {

        return ResponseEntity.ok(notificationService.getAllNotifications(userId));
    }

    @GetMapping("/{userId}/unread")
    public ResponseEntity<?> getUnreadNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getUnreadNotifications(userId));
    }

    @GetMapping("/{userId}/read")
    public ResponseEntity<?> getReadNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getReadNotifications(userId));
    }

    @PostMapping("/{id}/mark-as-read")
    public ResponseEntity<?> markAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
        return ResponseEntity.ok().build();
    }
}

package com.example.demo.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public List<Notification> getUnreadNotifications(Long userId) {
        return notificationRepository.findByUserIdAndRead(userId, false);
    }
    public List<Notification> getReadNotifications(Long userId) {
        return notificationRepository.findByUserIdAndRead(userId,true);
    }

    public void markAsRead(Long id) {
        Optional<Notification> optionalNotification = notificationRepository.findById(id);
        if (optionalNotification.isPresent()) {
            Notification notification = optionalNotification.get();
            notification.setRead(true);
            notificationRepository.save(notification);
        } else {
            throw new RuntimeException("Notification not found");
        }
    }

//    public void createNotification(Notification notification) {
//        notificationRepository.save(notification);
//    }

    public Notification saveOrUpdateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
}

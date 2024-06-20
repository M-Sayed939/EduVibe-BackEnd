package com.example.demo.Notifications;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserIdAndRead(Long userId, boolean read);
    List<Notification> findByUserId(Long userId);
}

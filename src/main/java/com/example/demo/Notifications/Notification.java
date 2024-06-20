package com.example.demo.Notifications;

import com.example.demo.appuser.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();
    private boolean read;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}

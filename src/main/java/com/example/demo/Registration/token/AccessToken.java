package com.example.demo.Registration.token;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AccessToken {

    @SequenceGenerator(
            name = "access_token_sequence",
            sequenceName = "access_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            generator = "access_token_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    private AppUserRole role;
//    @Column(nullable = false)
//    private LocalDateTime expiresAt;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;

    public AccessToken(String token,
                       LocalDateTime createdAt,
                       AppUser appUser, AppUserRole appUserRole) {
        this.token = token;
        this.createdAt = createdAt;
        this.appUser = appUser;
        this.role = appUserRole;
    }
}

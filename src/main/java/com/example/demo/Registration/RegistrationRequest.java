package com.example.demo.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.annotation.Nullable;
import javax.validation.constraints.Email;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstname;
    private final String lastname;
    private final String username;
    @Email
    private final String email;
    private final String password;
    private final String phone;
    private final String university;
    private final String country;
    @Nullable
    private final String role;

}

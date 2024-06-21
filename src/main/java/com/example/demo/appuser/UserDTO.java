package com.example.demo.appuser;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
@AllArgsConstructor
public class UserDTO {
    private final Long id;
    private final String firstname;
    private final String lastname;
    private final String username;
    private final String email;
    private final String token;
}

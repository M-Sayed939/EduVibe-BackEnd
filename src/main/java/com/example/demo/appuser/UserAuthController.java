package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/")

public class UserAuthController {

    @Autowired
    private AppUserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody AppUser user) {
        if (userService.authenticate(user.getEmail(), user.getPassword())) {
            return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
 


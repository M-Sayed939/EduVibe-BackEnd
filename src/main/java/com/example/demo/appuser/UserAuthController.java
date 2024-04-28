package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {
    
    @Autowired
    private AppUserService userService;
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody AppUser user){
        if(userService.authenticate(user.getUsername(), user.getPassword())){
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}
 


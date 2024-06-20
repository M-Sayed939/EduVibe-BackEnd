package com.example.demo.Registration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {


    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> register(@Validated @RequestBody RegistrationRequest request) {
        registrationService.register(request);
        return ResponseEntity.ok("user registered successfully");
    }

//    @GetMapping(path = "confirm")
//    public String confirm(@RequestParam("token") String token) {
//        return registrationService.confirmToken(token);
//    }
}
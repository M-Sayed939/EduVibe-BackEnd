package com.example.demo.Registration;

import com.example.demo.Registration.token.AccessToken;
import com.example.demo.Registration.token.AccessTokenService;
import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRole;
import com.example.demo.appuser.AppUserService;
import com.example.demo.email.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {


    private final AppUserService appUserService;

    private final EmailValidator emailValidator;

    private final AccessTokenService accessTokenService;

    private final EmailSender emailSender;

    public void register(RegistrationRequest request) {
//        boolean isValidEmail = emailValidator.
//                test(request.getEmail());
//
//        if (!isValidEmail) {
//            throw new IllegalStateException("email not valid");
//        }

        appUserService.signUpUser(
                new AppUser(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getRole()==null?AppUserRole.USER:AppUserRole.valueOf(request.getRole())

                )
        );


//        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
//        emailSender.send(
//                request.getEmail(),
//                buildEmail(request.getFirstName(), link));
//

    }

//    @Transactional
//    public String confirmToken(String token) {
//        AccessToken accessToken = accessTokenService
//                .getToken(token)
//                .orElseThrow(() ->
//                        new IllegalStateException("token not found"));
//
//        if (accessToken.getConfirmedAt() != null) {
//            throw new IllegalStateException("email already confirmed");
//        }
//
//        LocalDateTime expiredAt = accessToken.getExpiresAt();
//
//        if (expiredAt.isBefore(LocalDateTime.now())) {
//            throw new IllegalStateException("token expired");
//        }
//
//        accessTokenService.setConfirmedAt(token);
//        appUserService.enableAppUser(
//                accessToken.getAppUser().getEmail());
//        return "confirmed";
//    }

    public String buildEmail(String name, String link) {
        return "{"
                + "\"name\":\"" + name + "\","
                + "\"link\":\"" + link + "\""
                + "}";
    }
}

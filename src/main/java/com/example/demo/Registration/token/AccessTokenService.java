package com.example.demo.Registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccessTokenService {

    private final AccessTokenRepository accessTokenRepository;

    public void saveAccessToken(AccessToken token) {
        accessTokenRepository.save(token);
    }

    public Optional<AccessToken> getToken(String token) {
        return accessTokenRepository.findByToken(token);
    }

    public boolean validateToken(String token) {
        Optional<AccessToken> accessToken = accessTokenRepository.findByToken(token);
        return accessToken.map(accessToken1 -> accessToken1.getCreatedAt().plusHours(1).isAfter(LocalDateTime.now())).orElse(false);
    }

//    public int setConfirmedAt(String token) {
//        return accessTokenRepository.updateConfirmedAt(
//                token, LocalDateTime.now());
//    }
}

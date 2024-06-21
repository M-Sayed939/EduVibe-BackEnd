package com.example.demo.appuser;

import com.example.demo.Course.Course;
import com.example.demo.Notes.Note;
import com.example.demo.Registration.token.AccessToken;
import com.example.demo.Registration.token.AccessTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    @Autowired
    private final AppUserRepository
            appUserRepository;
    @Autowired
    private final AccessTokenService
            accessTokenService;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("user with email %s not found", email)));
    }

//    public UserDetails findByUsername(String username) throws UsernameNotFoundException {
//        return appUserRepository.findByUsername(username)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException(
//                                String.format("user with username %s not found", username)));
//    }

    public boolean authenticate(String email, String password) {
        AppUser user = appUserRepository.findByEmail(email).orElse(null);
        return user != null && bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    public void signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);


    }

    public UserDTO login(AppUser appUser) {
        AppUser user = appUserRepository
                .findByEmail(appUser.getEmail()).get();
        String token = UUID.randomUUID().toString();
        AccessToken accessToken = new AccessToken(
                token,
                LocalDateTime.now(),
                user,
                user.getAppUserRole()
        );
        accessTokenService.saveAccessToken(accessToken);
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                token
        );
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public List<Course> getAllCourses(Long userId) {
        return appUserRepository.findById(userId).map(AppUser::getCourses).orElse(List.of());
    }

    public List<Note> getAllNotes(Long userId) {
        return appUserRepository.findById(userId).map(AppUser::getNotes).orElse(List.of());
    }

    public AppUser loadUserById(Long userId) {
        return appUserRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User with id %s not found", userId)));
    }
}

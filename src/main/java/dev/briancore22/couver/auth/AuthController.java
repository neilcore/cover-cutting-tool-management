package dev.briancore22.couver.auth;

import dev.briancore22.couver.auth.internal.Roles;
import dev.briancore22.couver.auth.internal.User;
import dev.briancore22.couver.auth.internal.UserRepository;
import dev.briancore22.couver.auth.internal.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/auth/")
@RequiredArgsConstructor
public class AuthController {
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping("signin")
    public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.email(),
                            loginRequest.password()
                    )
            );
        } catch (AuthenticationException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Invalid credentials");
            errorResponse.put("status", false);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Optional<User> getUser = userRepository.findUserByEmail(loginRequest.email());
        if (getUser.isPresent()) {
            User user = getUser.get();
            String jwtToken = jwtUtils.generateTokenFromEmail(user);
            List<String> roles = user.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();
            AuthResponse response = new AuthResponse(jwtToken, user.getUsername(), roles);

            return ResponseEntity.ok(response);

        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "User not found");
            errorResponse.put("status", false);
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        Optional<User> findUserEmail = userRepository.findUserByEmail(signupRequest.email());

        if (findUserEmail.isPresent()) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Email already exists");
            errorResponse.put("status", false);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        User newUserObj = new User();
        newUserObj.setFirstName(signupRequest.firstName());
        newUserObj.setLastName(signupRequest.lastName());
        newUserObj.setEmail(signupRequest.email());
        newUserObj.setPassword(passwordEncoder.encode(signupRequest.password()));
        newUserObj.setRoles(Roles.USER);

        User newUser = userRepository.save(newUserObj);
        String jwtToken = jwtUtils.generateTokenFromEmail(newUser);
        List<String> roles = newUser.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        AuthResponse response = new AuthResponse(jwtToken, newUser.getUsername(), roles);

        return ResponseEntity.ok(response);
    }
}

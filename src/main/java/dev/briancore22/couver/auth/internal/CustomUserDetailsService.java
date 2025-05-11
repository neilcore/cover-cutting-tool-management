package dev.briancore22.couver.auth.internal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> findUserByEmail = userRepository.findUserByEmail(username);
        if (findUserByEmail.isPresent()) {
            return findUserByEmail.get();
        } else {
            throw new RuntimeException("User not found with username: " + username);
        }
    }
}

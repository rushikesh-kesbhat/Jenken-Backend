package Janken.security.service;

import Janken.security.dto.RegistrationRequestDto;

import Janken.security.model.User;
import Janken.security.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
    @RequiredArgsConstructor
    public class UserRegistrationService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        @Transactional
        public User registerUser(RegistrationRequestDto request) {
            if (userRepository.existsByUsername(request.getUsername()) ||
                    userRepository.existsByEmail(request.getEmail())) {

                throw new ValidationException(
                        "Username or Email already exists");
            }

            User user = new User();
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));

            return userRepository.save(user);
        }
}

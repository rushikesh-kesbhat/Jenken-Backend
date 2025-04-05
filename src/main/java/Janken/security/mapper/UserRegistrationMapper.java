package Janken.security.mapper;

import Janken.security.dto.RegistrationRequestDto;
import Janken.security.dto.RegistrationResponseDto;

import Janken.security.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper {

    public User toEntity(RegistrationRequestDto registrationRequestDto) {
        final var user = new User();

        user.setEmail(registrationRequestDto.getEmail());
        user.setUsername(registrationRequestDto.getUsername());
        user.setPassword(registrationRequestDto.getPassword());

        return user;
    }

    public RegistrationResponseDto toRegistrationResponseDto(
            final User user) {

        return new RegistrationResponseDto(
                user.getEmail(), user.getUsername());
    }

}

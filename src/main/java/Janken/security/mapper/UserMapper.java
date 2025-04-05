package Janken.security.mapper;

import Janken.security.dto.UserProfileDto;
import Janken.security.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserProfileDto toUserProfileDto(final User user) {
        return new UserProfileDto(user.getEmail(), user.getUsername());
    }
}

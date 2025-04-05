package Janken.security.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationRequestDto{
    String username;
    String password;
}

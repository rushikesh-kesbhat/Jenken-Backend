package Janken.security.dto;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationResponseDto {
    String token;
    long expiresIn;
}

package Janken.security.dto;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponseDto {
    String username;
    String email;
}
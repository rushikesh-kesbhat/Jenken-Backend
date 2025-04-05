package Janken.security.dto;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationRequestDto {
    String username;
    String email;
    String password;
}

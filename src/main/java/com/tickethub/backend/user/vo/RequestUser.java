package com.tickethub.backend.user.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestUser {

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    @Email
    private String email;

    @NotNull(message = "Username cannot be null")
    @Size(min = 2, message = "Username not be less than two characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be equal or greater than eight characters")
    private String pwd;
}

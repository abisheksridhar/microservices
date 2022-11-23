package org.capgemini.jwt.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {
    private String username;
    private String password;
    private Role role;
    private String firstname;
    private String lastname;
}

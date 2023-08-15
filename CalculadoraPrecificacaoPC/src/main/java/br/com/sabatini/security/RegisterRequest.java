package br.com.sabatini.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

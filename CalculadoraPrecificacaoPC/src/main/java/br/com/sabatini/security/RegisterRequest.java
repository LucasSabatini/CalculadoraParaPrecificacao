package br.com.sabatini.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

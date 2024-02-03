package br.com.sabatini.controller;

import br.com.sabatini.model.dto.UserResponseDTO;
import br.com.sabatini.security.AuthenticationRequest;
import br.com.sabatini.security.AuthenticationResponse;
import br.com.sabatini.security.RegisterRequest;
import br.com.sabatini.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static br.com.sabatini.serialization.converter.MediaType.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Security", description = "Endpoints para Registro e Autenticação")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/register",
                 produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
                 consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Registra um usuário",
            description = "Registra um usuário passando uma representação em JSON, XML ou YML da entidade RegisterRequest",
            tags = "Security",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Conflict", responseCode = "409", content = @Content),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest request) {
        authService.registerUser(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(path =  "/authenticate",
                 produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
                 consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Autentica um usuário",
            description = "Autentica um usuário passando seu email e senha em JSON, XML ou YML",
            tags = "Security",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = AuthenticationResponse.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Conflict", responseCode = "409", content = @Content),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticateUser(request));
    }
}

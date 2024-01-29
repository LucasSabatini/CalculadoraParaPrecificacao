package br.com.sabatini.controller;

import br.com.sabatini.security.AuthenticationRequest;
import br.com.sabatini.security.AuthenticationResponse;
import br.com.sabatini.security.RegisterRequest;
import br.com.sabatini.service.AuthenticationService;
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
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/register",
                 produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
                 consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest request) {
        authService.registerUser(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(path =  "/authenticate",
                 produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
                 consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticateUser(request));
    }
}

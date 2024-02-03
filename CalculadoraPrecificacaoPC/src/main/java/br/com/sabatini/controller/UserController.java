package br.com.sabatini.controller;

import br.com.sabatini.model.dto.UserRequestDTO;
import br.com.sabatini.model.dto.UserResponseDTO;
import br.com.sabatini.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.sabatini.serialization.converter.MediaType.*;

@RestController
@RequestMapping("/api/user")
@Validated
@Tag(name = "Usuário", description = "Endpoints para Gerenciamento de Usuários")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Obter usuários",
               description = "Obter todos os usuários",
               tags = "Usuário",
               responses = {
                            @ApiResponse(description = "Success", responseCode = "200", content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = UserResponseDTO.class))
                                    )
                            }),
                            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                            @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                            @ApiResponse(description = "Conflict", responseCode = "409", content = @Content),
                            @ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content),
                            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
               }
    )
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> userList = userService.getAllUsers();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(path = "{id}",
                produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Obter usuário",
            description = "Obter usuário por ID",
            tags = "Usuário",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = UserResponseDTO.class))
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
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping(path = "{id}",
                produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
                consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Atualiza um usuário",
            description = "Atualiza um usuário passando uma representação em JSON, XML ou YML da entidade UserRequestDTO",
            tags = "Usuário",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = UserResponseDTO.class))
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
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.updateUser(id, userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @DeleteMapping(path = "{id}")
    @Operation(summary = "Deleta um usuário",
            description = "Deleta um usuário através do ID",
            tags = "Usuário",
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Conflict", responseCode = "409", content = @Content),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            }
    )
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

package br.com.sabatini.controller;

import br.com.sabatini.model.dto.RawMaterialRequestDTO;
import br.com.sabatini.model.dto.RawMaterialResponseDTO;
import br.com.sabatini.service.RawMaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static br.com.sabatini.serialization.converter.MediaType.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/materiaprima")
@Validated
@Tag(name = "Matéria-Prima", description = "Endpoints para Gerenciamento de Matérias-primas")
public class RawMaterialController {

    private final RawMaterialService rawMaterialService;

    public RawMaterialController(RawMaterialService rawMaterialService) {
        this.rawMaterialService = rawMaterialService;
    }

    @GetMapping(path = "/all",
                produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Obter todas as matérias-primas",
            description = "Obter todas as matérias-primas",
            tags = "Matéria-Prima",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = RawMaterialResponseDTO.class))
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
    public ResponseEntity<List<RawMaterialResponseDTO>> getAllRawMaterials() {
        List<RawMaterialResponseDTO> rawMaterialResponseDTOList = rawMaterialService.getAllRawMaterials();
        return ResponseEntity.ok().body(rawMaterialResponseDTOList);
    }

    @GetMapping(produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Obter todas as matérias-primas do usuário autenticado",
            description = "Obter todas as matérias-primas do usuário autenticado",
            tags = "Matéria-Prima",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = RawMaterialResponseDTO.class))
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
    public ResponseEntity<List<RawMaterialResponseDTO>> getAllRawMaterialsOfUser() {
        List<RawMaterialResponseDTO> rawMaterialResponseDTOList = rawMaterialService.getAllRawMaterialsOfUser();
        return ResponseEntity.ok().body(rawMaterialResponseDTOList);
    }

    @GetMapping(path = "/{id}",
                produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Obter matéria-prima por ID",
            description = "Obter matéria-prima por ID",
            tags = "Matéria-Prima",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = RawMaterialResponseDTO.class))
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
    public ResponseEntity<RawMaterialResponseDTO> getRawMaterialById(@PathVariable Long id) {
        RawMaterialResponseDTO rawMaterialResponseDTO = rawMaterialService.getRawMaterialById(id);
        return ResponseEntity.ok().body(rawMaterialResponseDTO);
    }

    @PostMapping(produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
                 consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Adiciona uma matéria-prima",
            description = "Adiciona uma matéria-prima passando uma representação em JSON, XML ou YML da entidade RawMaterialRequestDTO",
            tags = "Matéria-Prima",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201",
                            content = @Content(schema = @Schema(implementation = RawMaterialResponseDTO.class))
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
    public @ResponseBody ResponseEntity<Void> addRawMaterial(@RequestBody RawMaterialRequestDTO rawMaterialRequestDTO) {
        RawMaterialResponseDTO rawMaterialResponseDTO = rawMaterialService.addRawMaterial(rawMaterialRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(rawMaterialResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}",
                produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
                consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    @Operation(summary = "Atualiza uma matéria-prima",
            description = "Atualiza uma matéria-prima passando uma representação em JSON, XML ou YML da entidade RawMaterialRequestDTO",
            tags = "Matéria-Prima",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = RawMaterialResponseDTO.class))
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
    public ResponseEntity<Void> updateRawMaterial(@PathVariable Long id, @RequestBody RawMaterialRequestDTO rawMaterialRequestDTO) {
        rawMaterialService.updateRawMaterial(id, rawMaterialRequestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Deleta uma matéria-prima",
            description = "Deleta uma matéria-prima por ID",
            tags = "Matéria-Prima",
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
    public ResponseEntity<Void> deleteRawMaterial(@PathVariable Long id) {
        rawMaterialService.deleteRawMaterial(id);
        return ResponseEntity.noContent().build();
    }
}

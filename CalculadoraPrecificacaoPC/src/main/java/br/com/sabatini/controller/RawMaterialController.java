package br.com.sabatini.controller;

import br.com.sabatini.model.dto.RawMaterialRequestDTO;
import br.com.sabatini.model.dto.RawMaterialResponseDTO;
import br.com.sabatini.service.RawMaterialService;
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
public class RawMaterialController {

    private final RawMaterialService rawMaterialService;

    public RawMaterialController(RawMaterialService rawMaterialService) {
        this.rawMaterialService = rawMaterialService;
    }

    @GetMapping(path = "/all",
                produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public ResponseEntity<List<RawMaterialResponseDTO>> getAllRawMaterials() {
        List<RawMaterialResponseDTO> rawMaterialResponseDTOList = rawMaterialService.getAllRawMaterials();
        return ResponseEntity.ok().body(rawMaterialResponseDTOList);
    }

    @GetMapping(produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public ResponseEntity<List<RawMaterialResponseDTO>> getAllRawMaterialsOfUser() {
        List<RawMaterialResponseDTO> rawMaterialResponseDTOList = rawMaterialService.getAllRawMaterialsOfUser();
        return ResponseEntity.ok().body(rawMaterialResponseDTOList);
    }

    @GetMapping(path = "/{id}",
                produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public ResponseEntity<RawMaterialResponseDTO> getRawMaterialById(@PathVariable Long id) {
        RawMaterialResponseDTO rawMaterialResponseDTO = rawMaterialService.getRawMaterialById(id);
        return ResponseEntity.ok().body(rawMaterialResponseDTO);
    }

    @PostMapping(produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
                 consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public @ResponseBody ResponseEntity<Void> addRawMaterial(@RequestBody RawMaterialRequestDTO rawMaterialRequestDTO) {
        RawMaterialResponseDTO rawMaterialResponseDTO = rawMaterialService.addRawMaterial(rawMaterialRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(rawMaterialResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}",
                produces = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
                consumes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
    public ResponseEntity<Void> updateRawMaterial(@PathVariable Long id, @RequestBody RawMaterialRequestDTO rawMaterialRequestDTO) {
        rawMaterialService.updateRawMaterial(id, rawMaterialRequestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteRawMaterial(@PathVariable Long id) {
        rawMaterialService.deleteRawMaterial(id);
        return ResponseEntity.ok().build();
    }
}

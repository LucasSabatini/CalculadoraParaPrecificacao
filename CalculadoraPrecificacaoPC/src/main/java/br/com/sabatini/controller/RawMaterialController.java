package br.com.sabatini.controller;

import br.com.sabatini.model.dto.RawMaterialRequestDTO;
import br.com.sabatini.model.dto.RawMaterialResponseDTO;
import br.com.sabatini.model.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/materiaprima")
public class RawMaterialController {

    @Autowired
    private RawMaterialService rawMaterialService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ResponseEntity<RawMaterialResponseDTO> addRawMaterial(@RequestBody RawMaterialRequestDTO rawMaterialRequestDTO) {
        RawMaterialResponseDTO rawMaterialResponseDTO = rawMaterialService.addRawMaterial(rawMaterialRequestDTO);
        return ResponseEntity.ok().body(rawMaterialResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<RawMaterialResponseDTO>> getAll() {
        List<RawMaterialResponseDTO> rawMaterialResponseDTO = rawMaterialService.getAll();
        return ResponseEntity.ok().body(rawMaterialResponseDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RawMaterialResponseDTO> getById(@PathVariable Long id) {
        RawMaterialResponseDTO rawMaterialResponseDTO = rawMaterialService.getById(id);
        return ResponseEntity.ok().body(rawMaterialResponseDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RawMaterialResponseDTO> updateRawMaterial(@PathVariable Long id, @RequestBody RawMaterialRequestDTO rawMaterialRequestDTO) {
        RawMaterialResponseDTO rawMaterialResponseDTO = rawMaterialService.updateRawMaterial(id, rawMaterialRequestDTO);
        return ResponseEntity.ok().body(rawMaterialResponseDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteRawMaterial(@PathVariable Long id) {
        rawMaterialService.deleteRawMaterial(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

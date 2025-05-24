package org.example.controllers;

import org.example.domainmodel.Moto;
import org.example.dto.MotoDTO;
import org.example.services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/motos")
public class MotoController {

    private final MotoService motoService;

    @Autowired
    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @PostMapping
    public ResponseEntity<MotoDTO> criar(@Valid @RequestBody MotoDTO dto) {
        Moto moto = dtoToEntity(dto);
        Moto salvo = motoService.salvar(moto);
        return ResponseEntity.ok(entityToDto(salvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoDTO> buscarPorId(@PathVariable Long id) {
        Moto moto = motoService.buscarPorId(id);
        return ResponseEntity.ok(entityToDto(moto));
    }

    @GetMapping
    public ResponseEntity<List<MotoDTO>> listarTodas() {
        List<MotoDTO> list = motoService.listarTodas()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody MotoDTO dto) {
        Moto motoAtualizada = dtoToEntity(dto);
        Moto atualizada = motoService.atualizar(id, motoAtualizada);
        return ResponseEntity.ok(entityToDto(atualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        motoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private Moto dtoToEntity(MotoDTO dto) {
        Moto moto = new Moto();
        moto.setId(dto.getId());
        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setAno(dto.getAno());
        moto.setCor(dto.getCor());
        return moto;
    }

    private MotoDTO entityToDto(Moto moto) {
        MotoDTO dto = new MotoDTO();
        dto.setId(moto.getId());
        dto.setPlaca(moto.getPlaca());
        dto.setModelo(moto.getModelo());
        dto.setAno(moto.getAno());
        dto.setCor(moto.getCor());
        return dto;
    }
}

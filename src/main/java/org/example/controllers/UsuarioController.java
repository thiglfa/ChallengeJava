package org.example.controllers;

import org.example.domainmodel.Usuario;
import org.example.dto.UsuarioDTO;
import org.example.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioDTO dto) {
        Usuario usuario = dtoToEntity(dto);
        Usuario salvo = usuarioService.salvar(usuario);
        return ResponseEntity.ok(entityToDto(salvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(entityToDto(usuario));
    }

    // Endpoint com paginação, ordenação e filtro por nome (contendo)
    @GetMapping
    @Cacheable("usuarios")
    public ResponseEntity<Page<UsuarioDTO>> listar(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "page", defaultValue = "0") int pagina,
            @RequestParam(value = "size", defaultValue = "10") int tamanho,
            @RequestParam(value = "sort", defaultValue = "nome,asc") String[] sort
    ) {
        Sort sortObj = Sort.by(parseSortParams(sort));
        Pageable pageable = PageRequest.of(pagina, tamanho, sortObj);

        Page<Usuario> pageUsuarios = usuarioService.listarComFiltro(nome, pageable);

        Page<UsuarioDTO> pageDTO = pageUsuarios.map(this::entityToDto);

        return ResponseEntity.ok(pageDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTO dto) {
        Usuario usuarioAtualizado = dtoToEntity(dto);
        Usuario atualizado = usuarioService.atualizar(id, usuarioAtualizado);
        return ResponseEntity.ok(entityToDto(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Helpers para conversão DTO <-> Entity
    private Usuario dtoToEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setId(dto.getId());
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        return u;
    }

    private UsuarioDTO entityToDto(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setPassword(u.getPassword());
        return dto;
    }

    // Parse para ordenar por múltiplos campos, ex: ["nome,asc", "email,desc"]
    private Sort.Order[] parseSortParams(String[] sortParams) {
        return java.util.Arrays.stream(sortParams)
                .map(param -> {
                    String[] split = param.split(",");
                    if (split.length == 2) {
                        return new Sort.Order(Sort.Direction.fromString(split[1]), split[0]);
                    } else {
                        return new Sort.Order(Sort.Direction.ASC, param);
                    }
                }).toArray(Sort.Order[]::new);
    }
}

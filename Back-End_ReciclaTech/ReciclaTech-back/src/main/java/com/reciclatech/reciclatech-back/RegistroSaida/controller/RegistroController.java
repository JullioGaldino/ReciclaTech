package com.reciclatech.RegistroSaida.controller;

import com.reciclatech.RegistroSaida.model.Saida;
import com.reciclatech.RegistroSaida.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/registro_de_saida")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @PostMapping
    public ResponseEntity<?> RegistrarSaida(@RequestBody Saida saida) {
        if (saida.getDesc_produto() == null || saida.getDesc_produto().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("O campo 'Desc_produto' é obrigatório e não pode estar vazio.");
        }
        Saida salvo = registroService.salvarRegistro(saida);
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saida> getUsuarioById(@PathVariable Long id) {
        Optional<Saida> usuario = registroService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


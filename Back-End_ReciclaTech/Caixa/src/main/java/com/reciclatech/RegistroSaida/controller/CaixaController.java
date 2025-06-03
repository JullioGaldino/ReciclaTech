package com.reciclatech.cadastroFuncionario.controller;

import com.reciclatech.cadastroFuncionario.model.Caixa;
import com.reciclatech.cadastroFuncionario.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caixa") // Define base path for caixa endpoints
public class CaixaController {

    @Autowired
    private CaixaService caixaService;

    // Get all caixa records
    @GetMapping
    public ResponseEntity<List<Caixa>> getAllCaixa() {
        List<Caixa> caixas = caixaService.findAll();
        return ResponseEntity.ok(caixas);
    }

    // Get a single caixa record by ID
    @GetMapping("/{id}")
    public ResponseEntity<Caixa> getCaixaById(@PathVariable Integer id) {
        return caixaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new caixa record
    @PostMapping
    public ResponseEntity<Caixa> createCaixa(@RequestBody Caixa caixa) {
        Caixa savedCaixa = caixaService.save(caixa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCaixa);
    }

    // Update an existing caixa record
    @PutMapping("/{id}")
    public ResponseEntity<Caixa> updateCaixa(@PathVariable Integer id, @RequestBody Caixa caixaDetails) {
        return caixaService.update(id, caixaDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a caixa record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaixa(@PathVariable Integer id) {
        if (caixaService.deleteById(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content for successful deletion
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if record doesn't exist
        }
    }
}


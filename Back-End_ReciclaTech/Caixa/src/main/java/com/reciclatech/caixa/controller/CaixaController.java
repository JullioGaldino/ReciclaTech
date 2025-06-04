package com.reciclatech.caixa.controller;

import com.reciclatech.caixa.model.Caixa;
import com.reciclatech.caixa.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

    @Autowired
    private CaixaService caixaService;


    @GetMapping
    public ResponseEntity<List<Caixa>> getAllCaixa() {
        List<Caixa> caixas = caixaService.findAll();
        return ResponseEntity.ok(caixas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caixa> getCaixaById(@PathVariable Integer id) {
        return caixaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Caixa> createCaixa(@RequestBody Caixa caixa) {
        Caixa savedCaixa = caixaService.save(caixa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCaixa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caixa> updateCaixa(@PathVariable Integer id, @RequestBody Caixa caixaDetails) {
        return caixaService.update(id, caixaDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaixa(@PathVariable Integer id) {
        if (caixaService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


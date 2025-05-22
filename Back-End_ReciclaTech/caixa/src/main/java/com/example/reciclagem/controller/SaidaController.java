package com.example.reciclagem.controller;

import com.example.reciclagem.model.Saida;
import com.example.reciclagem.service.SaidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/saidas")
@CrossOrigin(origins = "*")
public class SaidaController {

    private final SaidaService saidaService;

    public SaidaController(SaidaService saidaService) {
        this.saidaService = saidaService;
    }

    @PostMapping
    public ResponseEntity<Saida> adicionarSaida(@RequestBody Saida saida) {
        Saida novaSaida = saidaService.adicionarSaida(saida);
        return ResponseEntity.ok(novaSaida);
    }

    @GetMapping("/saldo-total")
    public ResponseEntity<BigDecimal> saldoTotal() {
        return ResponseEntity.ok(saidaService.getSaldoTotal());
    }

    @GetMapping("/saidas-dia")
    public ResponseEntity<BigDecimal> saidasDoDia() {
        return ResponseEntity.ok(saidaService.getSaidasDoDia());
    }

    @GetMapping("/detalhes-dia")
    public ResponseEntity<List<Saida>> detalhesSaidasDoDia() {
        return ResponseEntity.ok(saidaService.getSaidasDoDiaDetalhadas());
    }
}

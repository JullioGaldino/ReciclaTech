package com.reciclagem.controller;

import com.reciclagem.model.SaidaFinanceira;
import com.reciclagem.service.SaidaFinanceiraService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/saidas")
public class SaidaFinanceiraController {

    private final SaidaFinanceiraService service;

    public SaidaFinanceiraController(SaidaFinanceiraService service) {
        this.service = service;
    }

    @PostMapping
    public SaidaFinanceira adicionarSaida(@RequestBody SaidaFinanceira saida) {
        return service.salvar(saida);
    }

    @GetMapping
    public List<SaidaFinanceira> listarSaidas() {
        return service.listarTodas();
    }

    @GetMapping("/dashboard")
    public Map<String, Double> getDashboardInfo() {
        Map<String, Double> info = new HashMap<>();
        info.put("saldoTotal", service.calcularSaldoTotal());
        info.put("saidasDoDia", service.calcularSaidasDoDia());
        return info;
    }
}
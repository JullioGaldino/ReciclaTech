package com.reciclagem.sucatas.controller;

import com.reciclagem.sucatas.model.Saida;
import com.reciclagem.sucatas.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/saidas")
public class SaidaController {

    @Autowired
    private SaidaService saidaService;

    @PostMapping
    public ResponseEntity<Saida> criarSaida(@RequestBody Map<String, String> payload) {
        String nomeFuncionario = payload.get("nomeFuncionario");
        Double valor = Double.parseDouble(payload.get("valor"));
        String formaPagamento = payload.get("formaPagamento");
        String motivo = payload.get("motivo");

        Saida novaSaida = saidaService.registrarSaida(nomeFuncionario, valor, formaPagamento, motivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSaida);
    }

    @GetMapping
    public List<Saida> listarSaidas() {
        return saidaService.listarSaidas();
    }
}
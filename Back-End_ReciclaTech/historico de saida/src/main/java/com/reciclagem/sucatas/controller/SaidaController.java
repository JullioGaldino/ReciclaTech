package com.reciclagem.sucatas.controller;

import com.reciclagem.sucatas.model.Saida;
import com.reciclagem.sucatas.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saidas")
public class SaidaController {

    @Autowired
    private SaidaService service;

    @GetMapping
    public List<Saida> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public Saida criar(@RequestBody Saida saida) {
        return service.salvar(saida);
    }
}

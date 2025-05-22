package com.reciclagem.sucatas.controller;

import com.reciclagem.sucatas.model.Funcionario;
import com.reciclagem.sucatas.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<Funcionario> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return service.salvar(funcionario);
    }
}

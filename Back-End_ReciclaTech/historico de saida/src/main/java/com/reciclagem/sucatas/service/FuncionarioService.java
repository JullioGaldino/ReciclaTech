package com.reciclagem.sucatas.service;

import com.reciclagem.sucatas.model.Funcionario;
import com.reciclagem.sucatas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }
}

package com.reciclagem.sucatas.service;

import com.reciclagem.sucatas.model.Saida;
import com.reciclagem.sucatas.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaidaService {

    @Autowired
    private SaidaRepository repository;

    public List<Saida> listarTodas() {
        return repository.findAll();
    }

    public Saida salvar(Saida saida) {
        return repository.save(saida);
    }
}

package com.reciclatech.RegistroSaida.service;

import com.reciclatech.RegistroSaida.model.Saida;
import com.reciclatech.RegistroSaida.model.Saida;
import com.reciclatech.RegistroSaida.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    private SaidaRepository saidaRepository;

    public Saida salvarRegistro(Saida saida) {
        return saidaRepository.save(saida);
    }

    public Optional<Saida> buscarPorId(Long id) {
        return saidaRepository.findById(id);
    }
}
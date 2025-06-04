package com.reciclatech.cadastroFuncionario.service;

import com.reciclatech.cadastroFuncionario.model.Caixa;
import com.reciclatech.cadastroFuncionario.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaixaService {

    @Autowired
    private CaixaRepository caixaRepository;

    public List<Caixa> findAll() {
        return caixaRepository.findAll();
    }

    public Optional<Caixa> findById(Integer id) {
        return caixaRepository.findById(id);
    }

    public Caixa save(Caixa caixa) {
        // Basic validation or business logic can be added here
        return caixaRepository.save(caixa);
    }

    public Optional<Caixa> update(Integer id, Caixa caixaDetails) {
        return caixaRepository.findById(id)
                .map(caixa -> {
                    // Update fields, consider null checks if needed
                    caixa.setSaldoTotal(caixaDetails.getSaldoTotal());
                    caixa.setValor(caixaDetails.getValor());
                    caixa.setResponsavel(caixaDetails.getResponsavel());
                    caixa.setMetodoPg(caixaDetails.getMetodoPg());
                    return caixaRepository.save(caixa);
                });
    }

    public boolean deleteById(Integer id) {
        if (caixaRepository.existsById(id)) {
            caixaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


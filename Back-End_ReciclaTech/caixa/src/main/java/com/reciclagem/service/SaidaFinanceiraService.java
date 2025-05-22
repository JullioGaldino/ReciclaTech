package com.reciclagem.service;

import com.reciclagem.model.SaidaFinanceira;
import com.reciclagem.repository.SaidaFinanceiraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaidaFinanceiraService {

    private final SaidaFinanceiraRepository repository;

    public SaidaFinanceiraService(SaidaFinanceiraRepository repository) {
        this.repository = repository;
    }

    public SaidaFinanceira salvar(SaidaFinanceira saida) {
        return repository.save(saida);
    }

    public Double calcularSaidasDoDia() {
        return repository.findByData(LocalDate.now())
                .stream()
                .mapToDouble(SaidaFinanceira::getValor)
                .sum();
    }

    public Double calcularSaldoTotal() {
        return repository.findAll()
                .stream()
                .mapToDouble(SaidaFinanceira::getValor)
                .sum();
    }

    public List<SaidaFinanceira> listarTodas() {
        return repository.findAll();
    }
}
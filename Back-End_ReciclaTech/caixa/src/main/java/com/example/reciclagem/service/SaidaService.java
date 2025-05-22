package com.example.reciclagem.service;

import com.example.reciclagem.model.Saida;
import com.example.reciclagem.repository.SaidaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class SaidaService {

    private final SaidaRepository saidaRepository;

    public SaidaService(SaidaRepository saidaRepository) {
        this.saidaRepository = saidaRepository;
    }

    public Saida adicionarSaida(Saida saida) {
        return saidaRepository.save(saida);
    }

    public BigDecimal getSaldoTotal() {
        double total = saidaRepository.sumTotalValor();
        return BigDecimal.valueOf(total);
    }

    public BigDecimal getSaidasDoDia() {
        LocalDate hoje = LocalDate.now();
        LocalDateTime inicio = hoje.atStartOfDay();
        LocalDateTime fim = hoje.atTime(LocalTime.MAX);
        double total = saidaRepository.sumValorByDataHoraBetween(inicio, fim);
        return BigDecimal.valueOf(total);
    }

    public List<Saida> getSaidasDoDiaDetalhadas() {
        LocalDate hoje = LocalDate.now();
        LocalDateTime inicio = hoje.atStartOfDay();
        LocalDateTime fim = hoje.atTime(LocalTime.MAX);
        return saidaRepository.findByDataHoraBetween(inicio, fim);
    }
}

package com.example.reciclagem.repository;

import com.example.reciclagem.model.Saida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SaidaRepository extends JpaRepository<Saida, Long> {

    List<Saida> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);

    @Query("SELECT COALESCE(SUM(s.valor), 0) FROM Saida s WHERE s.dataHora BETWEEN :inicio AND :fim")
    double sumValorByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);

    @Query("SELECT COALESCE(SUM(s.valor), 0) FROM Saida s")
    double sumTotalValor();
}

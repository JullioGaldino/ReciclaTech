package com.reciclagem.repository;

import com.reciclagem.model.SaidaFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaidaFinanceiraRepository extends JpaRepository<SaidaFinanceira, Long> {
    List<SaidaFinanceira> findByData(LocalDate data);
}
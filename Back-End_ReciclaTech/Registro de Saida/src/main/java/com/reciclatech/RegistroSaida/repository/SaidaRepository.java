package com.reciclatech.RegistroSaida.repository;

import com.reciclatech.RegistroSaida.model.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaidaRepository extends JpaRepository<Saida, Long> {
}
package com.reciclatech.cadastroFuncionario.repository;

import com.reciclatech.cadastroFuncionario.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Integer> {
}


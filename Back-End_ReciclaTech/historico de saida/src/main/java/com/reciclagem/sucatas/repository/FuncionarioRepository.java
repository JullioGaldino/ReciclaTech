package com.reciclagem.sucatas.repository;

import com.reciclagem.sucatas.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}

package com.reciclagem.sucatas.service;

import com.reciclagem.sucatas.model.Funcionario;
import com.reciclagem.sucatas.model.Saida;
import com.reciclagem.sucatas.repository.FuncionarioRepository;
import com.reciclagem.sucatas.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaidaService {

    @Autowired
    private SaidaRepository saidaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Saida registrarSaida(String nomeFuncionario, Double valor, String formaPagamento, String motivo) {
        Funcionario funcionario = funcionarioRepository.findByNome(nomeFuncionario)
            .orElseGet(() -> {
                Funcionario novo = new Funcionario();
                novo.setNome(nomeFuncionario);
                return funcionarioRepository.save(novo);
            });

        Saida saida = new Saida();
        saida.setFuncionario(funcionario);
        saida.setValor(valor);
        saida.setFormaPagamento(formaPagamento);
        saida.setMotivo(motivo);

        return saidaRepository.save(saida);
    }

    public List<Saida> listarSaidas() {
        return saidaRepository.findAll();
    }
}
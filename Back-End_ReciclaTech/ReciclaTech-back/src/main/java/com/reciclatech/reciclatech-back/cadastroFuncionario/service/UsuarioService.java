package com.reciclatech.cadastroFuncionario.service;

import com.reciclatech.cadastroFuncionario.model.Usuario;
import com.reciclatech.cadastroFuncionario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id); // ✅ Agora busca real no banco
    }

}

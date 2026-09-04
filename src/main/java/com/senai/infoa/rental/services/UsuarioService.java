package com.senai.infoa.rental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental.models.Usuario;
import com.senai.infoa.rental.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository ur;

    public Usuario salvar(Usuario usuario){
        if(usuario != null) {}
        return ur.save(usuario);
    }

    public Usuario login(String email, String senha){
        Usuario usuario = ur.findByUsuario(email, senha);
            if(usuario != null && senha.equals(usuario.getSenha())){
                return usuario;
            }
        return null;
    }

    public Usuario atualizar(Usuario usuario, String email){
    Usuario usuario2 = ur.findByEmail(email);
        if(usuario2 != null){
            usuario.setNome(usuario.getNome());
            usuario.setSenha(usuario.getSenha());
            return ur.save(usuario);
        }
        return null;
    }

    public Usuario buscarPorId(Integer id) {
        return ur.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado: " + id));
    }

    public boolean apagar(Integer id) {
        Usuario usuario = ur.findById(id).get();
        if(usuario != null){
            ur.deleteById(id);
            return true;
        }
        return false;
    }
}

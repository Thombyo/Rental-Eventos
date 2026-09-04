package com.senai.infoa.rental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.rental.models.Usuario;
import com.senai.infoa.rental.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService us;

    @PostMapping("/cadastrar")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return us.salvar(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha) {
        return us.login(email, senha);
    }

    @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable String nome, @RequestBody Usuario usuario) {
        return us.atualizar(usuario, nome);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        Usuario usuario = us.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public String apagar(@PathVariable Integer id) {
        boolean apagou = us.apagar(id);
        if (apagou) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover o usuário";
    }

}
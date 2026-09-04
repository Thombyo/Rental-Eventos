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
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.rental.models.Movimentacao;
import com.senai.infoa.rental.services.MovimentacaoService;


@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoService ms;

    @PostMapping("/cadastrar")
    public Movimentacao salvar(@RequestBody Movimentacao movimentacao) {
        return ms.salvar(movimentacao);
    }

    @PutMapping("/atualizar/{id}")
    public Movimentacao atualizar(@PathVariable Integer id, @RequestBody Movimentacao movimentacao) {
        return ms.atualizar(movimentacao, id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Movimentacao> buscarPorId(@PathVariable Integer id) {
        Movimentacao movimentacao = ms.buscarPorId(id);
        return ResponseEntity.ok(movimentacao);
    }

    @DeleteMapping("/delete/{id}")
    public String apagar(@PathVariable Integer id) {
        boolean apagou = ms.apagar(id);
        if (apagou) {
            return "Movimentação removida com sucesso";
        }
        return "Falha ao remover a movimentação";
    }
}

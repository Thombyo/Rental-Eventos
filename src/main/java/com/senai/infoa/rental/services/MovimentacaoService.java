package com.senai.infoa.rental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental.models.Movimentacao;
import com.senai.infoa.rental.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository mr;

    public Movimentacao salvar(Movimentacao movimentacao){
        return mr.save(movimentacao);
    }

    public Movimentacao buscarPorId(Integer id) {
        return mr.findById(id).orElseThrow(() -> new RuntimeException("Movimentação não encontrada: " + id));
    }

    public List<Movimentacao> listarTodos(){
        return mr.findAll();
    }

    public Movimentacao atualizar(Movimentacao movimentacao, Integer id){
        Movimentacao movimentacao2 = mr.findById(id).get();
        if(movimentacao2 != null){
            movimentacao.setId(id);
            return mr.save(movimentacao);
        }
        return null;
    }

    public boolean apagar(Integer id) {
        Movimentacao movimentacao = mr.findById(id).get();
        if(movimentacao != null){
            mr.deleteById(id);
            return true;
        }
        return false;
    }
}

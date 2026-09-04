package com.senai.infoa.rental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rental.models.Equipamento;
import com.senai.infoa.rental.repositories.EquipamentoRepository;

@Service
public class EquipamentoService {
    @Autowired
    private EquipamentoRepository er;

    public Equipamento salvar(Equipamento equipamento){
        return er.save(equipamento);
    }

    public Equipamento buscarPorId(Integer id) {
        return er.findById(id).orElseThrow(() -> new RuntimeException("Equipamento não encontrado: " + id));
    }

    public List<Equipamento> listarTodos(){
        return er.findAll();
    }

    public Equipamento atualizar(Equipamento equipamento, Integer id){
    Equipamento equipamento2 = er.findById(id).get();
    if(equipamento2 != null){
        equipamento.setId(id);
        return er.save(equipamento);
    }
    return null;
    }

    public boolean apagar(Integer id) {
        Equipamento equipamento = er.findById(id).get();
        if(equipamento != null){
            er.deleteById(id);
            return true;
        }
        return false;
    }
}

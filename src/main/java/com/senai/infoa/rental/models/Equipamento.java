package com.senai.infoa.rental.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipamento")
public class Equipamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipamento_id")
    private Integer id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "potencia")
    private Float potencia;
    
    @Column(name = "material")
    private String material;
    
    @Column(name = "peso")
    private BigDecimal peso;
    
    @Column(name = "dimensao")
    private String dimensao;
    
    @Column(name = "cor")
    private String cor;
    
    @Column(name = "qtd_total")
    private Integer qtdTotal;

    @Column(name = "qtd_minima")
    private Integer qtdMinima;

    @ManyToMany
    @JoinTable(
        name = "equipamento_movimentacao",
        joinColumns = @JoinColumn(name = "equipamento_id"),
        inverseJoinColumns = @JoinColumn(name= "movimentacao_id")
    )
    private Set<Movimentacao> movimentacoes = new HashSet<>();

    public Equipamento(){

    }

    public Equipamento(Integer id, String marca, String modelo, String categoria, Float potencia, String material,
            BigDecimal peso, String dimensao, String cor, Integer qtdTotal, Integer qtdMinima,
            Set<Movimentacao> movimentacoes) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.potencia = potencia;
        this.material = material;
        this.peso = peso;
        this.dimensao = dimensao;
        this.cor = cor;
        this.qtdTotal = qtdTotal;
        this.qtdMinima = qtdMinima;
        this.movimentacoes = movimentacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getPotencia() {
        return potencia;
    }

    public void setPotencia(Float potencia) {
        this.potencia = potencia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(Integer qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    public Integer getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(Integer qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public Set<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(Set<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    
}

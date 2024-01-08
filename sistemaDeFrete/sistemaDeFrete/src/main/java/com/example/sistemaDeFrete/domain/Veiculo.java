package com.example.sistemaDeFrete.domain;

import com.example.sistemaDeFrete.domain.enuns.TipoVeiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //coloca os id no banco sequencial
    private long id;
    private String nome;
    private TipoVeiculo tipoVeiculo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
}

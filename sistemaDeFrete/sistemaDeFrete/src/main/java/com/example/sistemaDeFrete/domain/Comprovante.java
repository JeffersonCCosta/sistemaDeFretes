package com.example.sistemaDeFrete.domain;

import com.example.sistemaDeFrete.domain.enuns.TipoVeiculo;
import lombok.Builder;

@Builder
public class Comprovante {

    private String nome;
    private TipoVeiculo tipoVeiculo;
    private double valorFrete;
    private double valorTaxa;

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

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(double valorTaxa) {
        this.valorTaxa = valorTaxa;
    }
}

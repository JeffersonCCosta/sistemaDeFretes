package com.example.sistemaDeFrete.domain;

import com.example.sistemaDeFrete.domain.enuns.StatusFrete;
import com.example.sistemaDeFrete.domain.enuns.TipoVeiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Builder
@Entity
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //coloca os id no banco sequencial
    private long id;
    private String nome;
    private TipoVeiculo tipoVeiculo;
    private double valorFrete;
    private double valorTaxa;
    private StatusFrete statusFrete;
    private double distanciaEndereco;
    private String entregador;
    private double valorEntregador;

    public Frete (){
        calcularValorFrete();
        calcularTaxa();
        calcularRecebimentoEntregador();
    }

    public Frete(long id, String nome, TipoVeiculo tipoVeiculo, double valorFrete, double valorTaxa,
                 StatusFrete statusFrete, double distanciaEndereco, String entregador, double valorEntregador) {
        this.id = id;
        this.nome = nome;
        this.tipoVeiculo = tipoVeiculo;
        this.valorFrete = valorFrete;
        this.valorTaxa = valorTaxa;
        this.statusFrete = statusFrete;
        this.distanciaEndereco = distanciaEndereco;
        this.entregador = entregador;
        this.valorEntregador = valorEntregador;

        calcularValorFrete();
        calcularTaxa();
        calcularRecebimentoEntregador();
    }

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

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public StatusFrete getStatusFrete() {
        return statusFrete;
    }

    public void setStatusFrete(StatusFrete statusFrete) {
        this.statusFrete = statusFrete;
    }

    public double getDistanciaEndereco() {
        return distanciaEndereco;
    }

    public void setDistanciaEndereco(double distanciaEndereco) {
        this.distanciaEndereco = distanciaEndereco;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }

    public double getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(double valorTaxa) {
        this.valorTaxa = valorTaxa;
    }

    public double getValorEntregador() {
        return valorEntregador;
    }

    public void setValorEntregador(double valorEntregador) {
        this.valorEntregador = valorEntregador;
    }

    public void calcularRecebimentoEntregador(){
        valorEntregador = valorFrete - valorTaxa;
    }

    public void calcularTaxa(){
        if (distanciaEndereco >= 0 && distanciaEndereco <= 100) {
            valorTaxa = valorFrete * 0.20; // 20%
        } else if (distanciaEndereco > 100 && distanciaEndereco <= 200){
            valorTaxa = valorFrete * 0.15; // 15%
        } else if (distanciaEndereco > 200 && distanciaEndereco <= 500) {
            valorTaxa = valorFrete * 0.10; // 10%
        } else {
            valorTaxa = valorFrete * 0.075; // 7.5%
        }
    }

    public void calcularValorFrete() {
        if (tipoVeiculo != null) {
            switch (tipoVeiculo) {
                case CAMINHONETE:
                    valorFrete = distanciaEndereco * 5;
                    break;
                case FURGAO:
                    valorFrete = distanciaEndereco * 4;
                    break;
                case CAMINHAO:
                    valorFrete = distanciaEndereco * 10;
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de veículo não suportado: " + tipoVeiculo);
            }
        }
    }
}

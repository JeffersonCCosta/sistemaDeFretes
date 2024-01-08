package com.example.sistemaDeFrete.adapiter.controllers.request;

import com.example.sistemaDeFrete.domain.enuns.StatusFrete;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FreteDTO {

    private String nome;
    private String tipoVeiculo;
    private double valorFrete;
    private String statusFrete;
    private double distanciaEndereco;
    private String entregador;

}

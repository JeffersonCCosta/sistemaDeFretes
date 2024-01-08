package com.example.sistemaDeFrete.adapiter.controllers.mapper;

import com.example.sistemaDeFrete.adapiter.controllers.request.FreteDTO;
import com.example.sistemaDeFrete.adapiter.controllers.response.ComprovanteResponse;
import com.example.sistemaDeFrete.domain.Comprovante;
import com.example.sistemaDeFrete.domain.Frete;
import com.example.sistemaDeFrete.domain.enuns.StatusFrete;
import com.example.sistemaDeFrete.domain.enuns.TipoVeiculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;


@Component
public class SistemaDeFreteMapper {
    public Frete mapToFrete(FreteDTO freteDTO) {
        StatusFrete status;
        try {
            status = StatusFrete.valueOf(freteDTO.getStatusFrete().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Aviso: String de status inválida. Utilizando valor padrão (PRONTO_PARA_ENTREGA).");
            status = StatusFrete.PRONTO_PARA_ENVIO;
        }

        System.out.println("Status convertido: " + status);

        return Frete.builder()
                .tipoVeiculo(TipoVeiculo.valueOf(freteDTO.getTipoVeiculo()))
                .valorFrete(freteDTO.getValorFrete())
                .statusFrete(status)
                .nome(freteDTO.getNome())
                .distanciaEndereco(freteDTO.getDistanciaEndereco())
                .entregador(freteDTO.getEntregador())
                .build();
    }

    public ComprovanteResponse mapToComprovanteResponse(Comprovante comprovante){
        return ComprovanteResponse.builder()
                .nome(comprovante.getNome())
                .tipoVeiculo(comprovante.getTipoVeiculo())
                .valorFrete(comprovante.getValorFrete())
                .build();
    }

    public Frete mapToFrete(Frete frete){
        return Frete.builder()
                .id(frete.getId())
                .tipoVeiculo(frete.getTipoVeiculo())
                .valorFrete(frete.getValorFrete())
                .statusFrete(frete.getStatusFrete())
                .nome(frete.getNome())
                .distanciaEndereco(frete.getDistanciaEndereco())
                .entregador(frete.getEntregador())
                .valorTaxa(frete.getValorTaxa())
                .valorEntregador(frete.getValorEntregador())
                .build();
    }
}

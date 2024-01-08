package com.example.sistemaDeFrete.adapiter.repository.mapper;

import com.example.sistemaDeFrete.domain.Comprovante;
import com.example.sistemaDeFrete.domain.Frete;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;

@Component
public class FreteRepositoryMapper {


    public Comprovante mapToComprovante(Frete frete){
        return Comprovante.builder()
                .nome(frete.getNome())
                .tipoVeiculo(frete.getTipoVeiculo())
                .valorFrete(frete.getValorFrete())
                .build();
    }

}

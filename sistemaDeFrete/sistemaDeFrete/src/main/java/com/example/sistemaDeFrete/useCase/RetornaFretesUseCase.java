package com.example.sistemaDeFrete.useCase;

import com.example.sistemaDeFrete.adapiter.repository.FreteRepository;
import com.example.sistemaDeFrete.adapiter.repository.mapper.FreteRepositoryMapper;
import com.example.sistemaDeFrete.domain.Comprovante;
import com.example.sistemaDeFrete.domain.Frete;
import com.example.sistemaDeFrete.domain.enuns.StatusFrete;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //implementação das regras de serviço
public class RetornaFretesUseCase {


    private final FreteRepository freteRepository;

    public RetornaFretesUseCase(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    public List<Frete> retornaTodosFretes(){
        return freteRepository.findAll();
    }

    public List<Frete> retornaFrete(){
        return freteRepository.findAll();
    }

    public List<Frete> retornaFreteEntregador(String entregador){
        return freteRepository.findByEntregador(entregador);
    }
    public List<Frete> retornaFreteTipo(String tipoVeiculo){
        return freteRepository.findByStatusFrete(StatusFrete.valueOf(tipoVeiculo));
    }


}

package com.example.sistemaDeFrete.useCase;

import com.example.sistemaDeFrete.adapiter.repository.FreteRepository;
import com.example.sistemaDeFrete.adapiter.repository.mapper.FreteRepositoryMapper;
import com.example.sistemaDeFrete.domain.Comprovante;
import com.example.sistemaDeFrete.domain.Frete;
import com.example.sistemaDeFrete.domain.enuns.StatusFrete;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //implementação das regras de serviço
public class AtualizaFreteUseCase {

    private final FreteRepositoryMapper freteRepositoryMapper;
    private final FreteRepository freteRepository;

    public AtualizaFreteUseCase(FreteRepositoryMapper freteRepositoryMapper, FreteRepository freteRepository) {
        this.freteRepositoryMapper = freteRepositoryMapper;
        this.freteRepository = freteRepository;
    }

    public Frete atualizaFrete(Frete frete){
        long freteId = frete.getId();
        try {
            Optional<Frete> found = freteRepository.findById(freteId);
            if(found.isEmpty()) throw new IllegalStateException("Frete não encontrado");


            Frete existingFrete = found.get();
            existingFrete.setNome(frete.getNome());
            existingFrete.setTipoVeiculo(frete.getTipoVeiculo());
            existingFrete.setDistanciaEndereco(frete.getDistanciaEndereco());
            existingFrete.setEntregador(frete.getEntregador());

            existingFrete.calcularValorFrete();

            existingFrete.setStatusFrete(frete.getStatusFrete());
            freteRepository.save(existingFrete);

            return existingFrete;
        }catch (Exception e){
            return null;
        }
    }

    public Frete AtualizaStatusFrete(long freteId, String Status){
        try {
            Optional<Frete> found = freteRepository.findById(freteId);
            if(found.isEmpty()) throw new IllegalStateException("Frete não encontrado");


            Frete existingFrete = found.get();
            existingFrete.setStatusFrete(StatusFrete.valueOf(Status));
            freteRepository.save(existingFrete);

            return existingFrete;

        }catch (Exception e){
            return null;
        }
    }

}

package com.example.sistemaDeFrete.useCase;

import com.example.sistemaDeFrete.adapiter.repository.FreteRepository;
import com.example.sistemaDeFrete.adapiter.repository.mapper.FreteRepositoryMapper;
import com.example.sistemaDeFrete.domain.Comprovante;
import com.example.sistemaDeFrete.domain.Frete;
import org.springframework.stereotype.Service;

@Service //implementação das regras de serviço
public class RegistroDeFreteUseCase {

    private final FreteRepositoryMapper freteRepositoryMapper;
    private final FreteRepository freteRepository;

    public RegistroDeFreteUseCase(FreteRepositoryMapper freteRepositoryMapper, FreteRepository freteRepository) {
        this.freteRepositoryMapper = freteRepositoryMapper;
        this.freteRepository = freteRepository;
    }

    public Comprovante registroDeFrete(Frete frete){
        var insert = freteRepository.save(frete);
        return freteRepositoryMapper.mapToComprovante(insert);
    }


}

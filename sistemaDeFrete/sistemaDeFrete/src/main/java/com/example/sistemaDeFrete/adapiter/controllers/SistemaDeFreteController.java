package com.example.sistemaDeFrete.adapiter.controllers;

import com.example.sistemaDeFrete.adapiter.controllers.mapper.SistemaDeFreteMapper;
import com.example.sistemaDeFrete.adapiter.controllers.request.FreteDTO;
import com.example.sistemaDeFrete.adapiter.controllers.response.ComprovanteResponse;
import com.example.sistemaDeFrete.domain.Comprovante;
import com.example.sistemaDeFrete.domain.Frete;
import com.example.sistemaDeFrete.domain.enuns.StatusFrete;
import com.example.sistemaDeFrete.useCase.AtualizaFreteUseCase;
import com.example.sistemaDeFrete.useCase.RegistroDeFreteUseCase;
import com.example.sistemaDeFrete.useCase.RetornaFretesUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;


@RestController
@RequestMapping("/sistema-de-frete")
public class SistemaDeFreteController {
    private final RetornaFretesUseCase retornaFretesUseCase; //referencia da classe RetornaFretesUseCase

    private final RegistroDeFreteUseCase registroDeFreteUseCase; //referencia da classe RegistroDeFreteUseCase

    private final SistemaDeFreteMapper sistemaDeFreteMapper;
    private final AtualizaFreteUseCase atualizaFreteUseCase;


    public SistemaDeFreteController(RetornaFretesUseCase retornaFretesUseCase, RegistroDeFreteUseCase registroDeFreteUseCase, SistemaDeFreteMapper sistemaDeFreteMapper, AtualizaFreteUseCase atualizaFreteUseCase) {
        this.retornaFretesUseCase = retornaFretesUseCase;
        this.registroDeFreteUseCase = registroDeFreteUseCase;
        this.sistemaDeFreteMapper = sistemaDeFreteMapper;
        this.atualizaFreteUseCase = atualizaFreteUseCase;
    }



    @PostMapping
    public ComprovanteResponse registrarFrete(@RequestBody FreteDTO freteDTO){
       Comprovante registro = registroDeFreteUseCase.registroDeFrete(sistemaDeFreteMapper.mapToFrete(freteDTO));
          return sistemaDeFreteMapper.mapToComprovanteResponse(registro);
    }

    @GetMapping("/fretes")
    public List<Frete> listaFretes(){
        return retornaFretesUseCase.retornaTodosFretes();
    }

    @GetMapping("/fretes/entregador")
    public List<Frete> listaFretesEntregador(@RequestBody String entregador){
        return retornaFretesUseCase.retornaFreteEntregador(entregador);
    }
    @GetMapping("/fretes/tipo")
    public List<Frete> listaFretesTipo(@RequestBody String tipo){
        return retornaFretesUseCase.retornaFreteTipo(tipo);
    }

    @PostMapping("/atualiza")
    public ResponseEntity<Frete> atualizaFrete(@RequestBody Frete frete){
        Frete frete1 = sistemaDeFreteMapper.mapToFrete(frete);
        Frete retorno = atualizaFreteUseCase.atualizaFrete(frete1);
        if(retorno == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(retorno);
    }
    @PostMapping("/status/{id}")
    public ResponseEntity<Frete> atualizaFrete(@PathVariable Long id,@RequestBody String statusFrete){
        Frete retorno = atualizaFreteUseCase.AtualizaStatusFrete(id,statusFrete);
        if(retorno == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(retorno);
    }




}

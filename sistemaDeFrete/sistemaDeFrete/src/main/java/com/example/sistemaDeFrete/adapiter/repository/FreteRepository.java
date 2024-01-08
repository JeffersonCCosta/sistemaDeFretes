package com.example.sistemaDeFrete.adapiter.repository;

import com.example.sistemaDeFrete.domain.Frete;
import com.example.sistemaDeFrete.domain.enuns.StatusFrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {
    public List<Frete> findByEntregador(String entregador);

    @Query("SELECT f FROM Frete f WHERE f.statusFrete = :statusFrete")
    public List<Frete> findByStatusFrete(@Param("statusFrete") StatusFrete statusFrete);
}

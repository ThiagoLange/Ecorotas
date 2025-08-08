package br.com.joinville.ecorota.repository;

import br.com.joinville.ecorota.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    // A interface JpaRepository já nos fornece os métodos save(), findAll(), findById(), etc.
}

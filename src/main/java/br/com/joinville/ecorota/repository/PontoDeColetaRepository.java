package br.com.joinville.ecorota.repository;

import br.com.joinville.ecorota.model.PontoDeColeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoDeColetaRepository extends JpaRepository<PontoDeColeta, Long> {
    // O Spring também cuidará dos métodos básicos para esta entidade.
}

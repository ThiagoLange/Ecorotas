package br.com.joinville.ecorota.repository;

import br.com.joinville.ecorota.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {
    // O Spring Data JPA cria todos os métodos básicos (save, findById, findAll, etc.) para você.
    // Não é necessário adicionar nada aqui por enquanto.
}
package br.com.joinville.ecorota.repository;

import br.com.joinville.ecorota.model.Coletor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetorRepository extends JpaRepository<Coletor, Long> {
}
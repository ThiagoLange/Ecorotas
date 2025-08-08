// Conteúdo CORRETO para o arquivo ColetorService.java
package br.com.joinville.ecorota.service;

import br.com.joinville.ecorota.model.Coletor;
import br.com.joinville.ecorota.repository.ColetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColetorService {

    private final ColetorRepository coletorRepository;

    @Autowired
    public ColetorService(ColetorRepository coletorRepository) {
        this.coletorRepository = coletorRepository;
    }

    public Coletor cadastrarColetor(Coletor coletor) {
        return coletorRepository.save(coletor);
    }

    public List<Coletor> consultarTodosOsColetores() {
        return coletorRepository.findAll();
    }

    public Coletor buscarPorId(Long id) {
        return coletorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro: Coletor não encontrado para o ID: " + id));
    }
}
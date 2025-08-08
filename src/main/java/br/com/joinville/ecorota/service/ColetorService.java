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

    /**
     * Método responsável pela inclusão (cadastro) de um novo Coletor.
     * @param coletor O objeto Coletor a ser salvo.
     * @return O Coletor salvo com o ID gerado.
     */
    public Coletor cadastrarColetor(Coletor coletor) {
        System.out.println("Cadastrando novo coletor: " + coletor.getNome());
        return coletorRepository.save(coletor);
    }

    /**
     * Consulta e retorna todos os Coletores cadastrados.
     * @return Uma lista de todos os Coletores.
     */
    public List<Coletor> consultarTodosOsColetores() {
        System.out.println("Consultando todos os coletores...");
        return coletorRepository.findAll();
    }
}
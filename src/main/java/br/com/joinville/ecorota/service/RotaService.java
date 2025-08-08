package br.com.joinville.ecorota.service;

import br.com.joinville.ecorota.model.Rota;
import br.com.joinville.ecorota.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {

    private final RotaRepository rotaRepository;

    // Usando injeção de dependência via construtor (melhor prática)
    @Autowired
    public RotaService(RotaRepository rotaRepository) {
        this.rotaRepository = rotaRepository;
    }

    /**
     * Método responsável pela inclusão (cadastro) de uma nova Rota.
     * @param rota O objeto Rota a ser salvo.
     * @return A Rota salva com o ID gerado pelo banco de dados.
     */
    public Rota cadastrarRota(Rota rota) {
        // Aqui poderiam entrar regras de negócio, como validar se a rota já existe.
        System.out.println("Cadastrando nova rota: " + rota.getNome());
        return rotaRepository.save(rota);
    }

    /**
     * Consulta e retorna todas as Rotas cadastradas.
     * @return Uma lista de todas as Rotas.
     */
    public List<Rota> consultarTodasAsRotas() {
        System.out.println("Consultando todas as rotas...");
        return rotaRepository.findAll();
    }
}
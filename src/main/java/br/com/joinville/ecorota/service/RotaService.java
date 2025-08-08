package br.com.joinville.ecorota.service;

import br.com.joinville.ecorota.model.Rota;
import br.com.joinville.ecorota.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {

    private final RotaRepository rotaRepository;

    // Injeção de dependência via construtor (melhor prática)
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

    /**
     * MÉTODO ADICIONADO: Busca uma Rota específica pelo seu ID.
     * Este método é essencial para que o ContratoService possa validar
     * e buscar as rotas ao registrar um novo contrato.
     * @param id O ID da rota a ser encontrada.
     * @return O objeto Rota correspondente.
     * @throws RuntimeException se a rota não for encontrada.
     */
    public Rota buscarPorId(Long id) {
        return rotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro: Rota não encontrada para o ID: " + id));
    }
}
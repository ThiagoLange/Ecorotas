package br.com.joinville.ecorota.service;

import br.com.joinville.ecorota.model.Rota;
import br.com.joinville.ecorota.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Anotação que define esta classe como um serviço (componente de negócio)
public class RotaService {

    @Autowired // Injeção de dependência: O Spring vai fornecer uma instância de RotaRepository aqui
    private RotaRepository rotaRepository;

    public Rota criarRota(Rota rota) {
        // Aqui podem entrar regras de negócio, como validar se já existe uma rota com o mesmo nome
        return rotaRepository.save(rota);
    }

    public List<Rota> listarTodasAsRotas() {
        return rotaRepository.findAll();
    }

    public Rota buscarRotaPorId(Long id) {
        // O .orElseThrow() lança uma exceção se a rota não for encontrada.
        // É uma boa prática para lidar com casos de "não encontrado".
        return rotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rota não encontrada com o id: " + id));
    }
}
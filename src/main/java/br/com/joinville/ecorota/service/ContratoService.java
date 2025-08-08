// Conteúdo CORRETO para o arquivo ContratoService.java
package br.com.joinville.ecorota.service;

import br.com.joinville.ecorota.model.Coletor;
import br.com.joinville.ecorota.model.Contrato;
import br.com.joinville.ecorota.model.Rota;
import br.com.joinville.ecorota.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;
    private final ColetorService coletorService;
    private final RotaService rotaService;

    @Autowired
    public ContratoService(ContratoRepository contratoRepository, ColetorService coletorService, RotaService rotaService) {
        this.contratoRepository = contratoRepository;
        this.coletorService = coletorService;
        this.rotaService = rotaService;
    }

    public List<Contrato> consultarTodos() {
        return contratoRepository.findAll();
    }

    public Contrato registrarContrato(Long coletorId, List<Long> idsDasRotas) {
        Coletor coletorEncontrado = coletorService.buscarPorId(coletorId);
        List<Rota> rotasEncontradas = idsDasRotas.stream()
                .map(rotaService::buscarPorId)
                .collect(Collectors.toList());

        Contrato novoContrato = new Contrato(coletorEncontrado, rotasEncontradas);

        return contratoRepository.save(novoContrato);
    }
}
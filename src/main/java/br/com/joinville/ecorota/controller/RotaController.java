package br.com.joinville.ecorota.controller;

import br.com.joinville.ecorota.model.Rota;
import br.com.joinville.ecorota.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por receber as requisições HTTP para a entidade Rota.
 */
@RestController // Define a classe como um controller REST, que retorna JSON por padrão.
@RequestMapping("/api/rotas") // Mapeia todas as requisições que começam com /api/rotas para este controller.
public class RotaController {

    private final RotaService rotaService;

    /**
     * !!! ATENÇÃO: Injeção de Dependências !!!
     * O Spring injeta automaticamente uma instância de RotaService aqui.
     * Esta é a forma correta de acessar a camada de serviço.
     */
    @Autowired
    public RotaController(RotaService rotaService) {
        this.rotaService = rotaService;
    }

    /**
     * Endpoint para CADASTRAR uma nova rota.
     * Mapeado para o método HTTP POST em /api/rotas.
     * @param rota O corpo da requisição, contendo o JSON da rota a ser criada.
     * @return A rota recém-criada com o status HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Rota> cadastrarNovaRota(@RequestBody Rota rota) {
        Rota rotaSalva = rotaService.cadastrarRota(rota);
        return new ResponseEntity<>(rotaSalva, HttpStatus.CREATED);
    }

    /**
     * Endpoint para CONSULTAR todas as rotas.
     * Mapeado para o método HTTP GET em /api/rotas.
     * @return Uma lista de todas as rotas cadastradas com o status HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Rota>> consultarTodasAsRotas() {
        List<Rota> todasAsRotas = rotaService.consultarTodasAsRotas();
        return ResponseEntity.ok(todasAsRotas);
    }
}
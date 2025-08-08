package br.com.joinville.ecorota.controller;

import br.com.joinville.ecorota.model.Coletor;
import br.com.joinville.ecorota.service.ColetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por receber as requisições HTTP para a entidade Coletor.
 */
@RestController
@RequestMapping("/api/coletores") // Endereço base para os coletores.
public class ColetorController {

    private final ColetorService coletorService;

    /**
     * !!! ATENÇÃO: Injeção de Dependências !!!
     * O Spring injeta a instância de ColetorService, permitindo que o controller
     * acesse a lógica de negócio dos coletores.
     */
    @Autowired
    public ColetorController(ColetorService coletorService) {
        this.coletorService = coletorService;
    }

    /**
     * Endpoint para CADASTRAR um novo coletor.
     * Mapeado para o método HTTP POST em /api/coletores.
     * @param coletor O corpo da requisição com o JSON do coletor.
     * @return O coletor salvo com status HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Coletor> cadastrarNovoColetor(@RequestBody Coletor coletor) {
        Coletor coletorSalvo = coletorService.cadastrarColetor(coletor);
        return new ResponseEntity<>(coletorSalvo, HttpStatus.CREATED);
    }

    /**
     * Endpoint para CONSULTAR todos os coletores.
     * Mapeado para o método HTTP GET em /api/coletores.
     * @return Uma lista de todos os coletores com status HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Coletor>> consultarTodosOsColetores() {
        List<Coletor> todosOsColetores = coletorService.consultarTodosOsColetores();
        return ResponseEntity.ok(todosOsColetores);
    }
}
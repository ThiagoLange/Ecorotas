package br.com.joinville.ecorota.controller;

import br.com.joinville.ecorota.model.Coletor;
import br.com.joinville.ecorota.service.ColetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coletores") // Novo endpoint base para os coletores
public class ColetorController {

    private final ColetorService coletorService;

    @Autowired
    public ColetorController(ColetorService coletorService) {
        this.coletorService = coletorService;
    }

    @PostMapping
    public ResponseEntity<Coletor> criarColetor(@RequestBody Coletor coletor) {
        Coletor novoColetor = coletorService.cadastrarColetor(coletor);
        return new ResponseEntity<>(novoColetor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Coletor>> listarColetores() {
        List<Coletor> coletores = coletorService.consultarTodosOsColetores();
        return ResponseEntity.ok(coletores);
    }
}
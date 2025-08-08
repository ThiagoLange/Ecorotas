package br.com.joinville.ecorota.controller;

import br.com.joinville.ecorota.model.Rota;
import br.com.joinville.ecorota.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rotas")
public class RotaController {

    private final RotaService rotaService;

    @Autowired
    public RotaController(RotaService rotaService) {
        this.rotaService = rotaService;
    }

    @PostMapping
    public ResponseEntity<Rota> criarRota(@RequestBody Rota rota) {
        // Delega a criação para o serviço
        Rota novaRota = rotaService.cadastrarRota(rota);
        return new ResponseEntity<>(novaRota, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rota>> listarRotas() {
        // Delega a consulta para o serviço
        List<Rota> rotas = rotaService.consultarTodasAsRotas();
        return ResponseEntity.ok(rotas);
    }

    // Os outros endpoints (como buscar por ID) continuariam aqui.
}
package br.com.joinville.ecorota.controller;

import br.com.joinville.ecorota.model.Rota;
import br.com.joinville.ecorota.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Anotação que combina @Controller e @ResponseBody, ideal para APIs REST
@RequestMapping("/api/rotas") // Define o endereço base para todos os endpoints nesta classe
public class RotaController {

    @Autowired // Injeta o RotaService para que possamos usá-lo
    private RotaService rotaService;

    // Endpoint para criar uma nova rota
    // Mapeado para POST /api/rotas
    @PostMapping
    public ResponseEntity<Rota> criarRota(@RequestBody Rota rota) {
        Rota novaRota = rotaService.criarRota(rota);
        // Retorna a rota criada com o status HTTP 201 (Created)
        return new ResponseEntity<>(novaRota, HttpStatus.CREATED);
    }

    // Endpoint para listar todas as rotas
    // Mapeado para GET /api/rotas
    @GetMapping
    public ResponseEntity<List<Rota>> listarRotas() {
        List<Rota> rotas = rotaService.listarTodasAsRotas();
        // Retorna a lista de rotas com o status HTTP 200 (OK)
        return ResponseEntity.ok(rotas);
    }

    // Endpoint para buscar uma rota específica pelo seu ID
    // Mapeado para GET /api/rotas/{id} (ex: /api/rotas/1)
    @GetMapping("/{id}")
    public ResponseEntity<Rota> buscarRotaPorId(@PathVariable Long id) {
        Rota rota = rotaService.buscarRotaPorId(id);
        return ResponseEntity.ok(rota);
    }
}
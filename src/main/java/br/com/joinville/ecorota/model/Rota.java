package br.com.joinville.ecorota.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String diaDaSemana;

    @Column(nullable = false)
    private String tipoDeResiduo;

    // --- ATUALIZAÇÃO IMPORTANTE AQUI ---
    // Trocamos a lista de PontoDeColeta por uma lista de Coletor.
    // O 'mappedBy = "rota"' se refere ao nome do campo na classe Coletor que mapeia de volta para Rota.
    @OneToMany(mappedBy = "rota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Coletor> coletores;

    // Não precisamos mais dos atributos de Rota.java que você tinha definido antes
    // (descricao, areaDeAbrangencia, etc.), pois eles agora estão no Coletor ou na Rota com outro nome.
    // Mantivemos os da versão Spring (nome, diaDaSemana, tipoDeResiduo).
}
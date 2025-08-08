// Dentro de Rota.java
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

    @OneToMany(mappedBy = "rota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PontoDeColeta> pontosDeColeta;
}
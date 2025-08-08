package br.com.joinville.ecorota.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // Lombok para getters, setters, etc.
@NoArgsConstructor // Lombok para o construtor vazio exigido pelo JPA
@Entity // !!! MUDANÇA 1: Transformamos em uma entidade de banco de dados.
public class Contrato {

    // !!! MUDANÇA 2: Removemos a lógica de ID estático e usamos a do banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // !!! MUDANÇA 3: Definimos os relacionamentos com anotações JPA.
    // Um contrato pertence a um coletor.
    @ManyToOne
    @JoinColumn(name = "coletor_id") // Chave estrangeira na tabela Contrato
    private Coletor coletor;

    // Um contrato pode ter várias rotas, e uma rota pode estar em vários contratos.
    @ManyToMany
    @JoinTable(
            name = "contrato_rota", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "contrato_id"),
            inverseJoinColumns = @JoinColumn(name = "rota_id"))
    private List<Rota> rotas;

    // Construtor para facilitar a criação no service
    public Contrato(Coletor coletor, List<Rota> rotas) {
        this.coletor = coletor;
        this.rotas = rotas;
    }
}
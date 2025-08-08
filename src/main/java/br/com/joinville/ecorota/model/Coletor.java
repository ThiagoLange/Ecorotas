package br.com.joinville.ecorota.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotação do Lombok para gerar Getters, Setters, toString, etc.
@NoArgsConstructor // Lombok: cria um construtor sem argumentos (necessário para o JPA)
@AllArgsConstructor // Lombok: cria um construtor com todos os argumentos
@Entity // Anotação mais importante: define que esta classe é uma tabela no banco de dados.
public class Coletor {

    // O banco de dados agora vai cuidar do ID.
    // @Id define que este campo é a chave primária.
    // @GeneratedValue define a estratégia de geração (IDENTITY usa o auto-incremento do banco).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Garante que a coluna no banco não pode ser nula
    private String nome;

    private String descricao;

    // --- Relacionamento com Rota ---
    // Um Coletor pertence a uma Rota.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rota_id") // Nome da coluna da chave estrangeira na tabela 'Coletor'
    @JsonIgnore // Essencial para evitar um loop infinito ao converter para JSON
    private Rota rota;

    // O construtor agora não precisa se preocupar com o ID.
    public Coletor(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
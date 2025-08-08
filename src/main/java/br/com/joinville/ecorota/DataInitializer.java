package br.com.joinville.ecorota;

import br.com.joinville.ecorota.model.Coletor;
import br.com.joinville.ecorota.model.Rota;
import br.com.joinville.ecorota.repository.ColetorRepository;
import br.com.joinville.ecorota.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private ColetorRepository coletorRepository;

    @Override
    public void run(String... args) throws Exception {

        if (rotaRepository.count() > 0) {
            System.out.println(">>> A base de dados já contém dados. Nenhuma ação necessária.");
            return;
        }

        System.out.println(">>> Iniciando a carga de dados de teste...");

        // --- ETAPA 1: Criar e SALVAR as entidades 'pai' (Rota) PRIMEIRO ---
        Rota rotaNorte = new Rota();
        rotaNorte.setNome("Coleta Seletiva - Zona Norte");
        rotaNorte.setDiaDaSemana("SEGUNDA");
        rotaNorte.setTipoDeResiduo("RECICLAVEL");

        Rota rotaSul = new Rota();
        rotaSul.setNome("Coleta Orgânica - Zona Sul");
        rotaSul.setDiaDaSemana("TERÇA");
        rotaSul.setTipoDeResiduo("ORGANICO");

        // Salvando as rotas para que elas se tornem 'persistentes' e tenham um ID
        rotaRepository.saveAll(Arrays.asList(rotaNorte, rotaSul));
        System.out.println(">>> Rotas salvas com sucesso!");


        // --- ETAPA 2: Criar as entidades 'filho' (Coletor) ---
        Coletor caminhao1 = new Coletor("Caminhão Alfa", "Veículo de grande porte");
        Coletor caminhao2 = new Coletor("Caminhão Beta", "Veículo de médio porte");
        Coletor van1 = new Coletor("Van Gamma", "Veículo rápido para áreas estreitas");


        // --- ETAPA 3: Vincular os 'filhos' aos 'pais' que JÁ ESTÃO SALVOS ---
        // Agora 'rotaNorte' e 'rotaSul' têm IDs e são reconhecidas pelo Hibernate.
        caminhao1.setRota(rotaNorte);
        caminhao2.setRota(rotaNorte);
        van1.setRota(rotaSul);


        // --- ETAPA 4: Salvar as entidades 'filho' ---
        // Esta operação agora funcionará, pois as Rotas referenciadas já existem no banco.
        coletorRepository.saveAll(Arrays.asList(caminhao1, caminhao2, van1));
        System.out.println(">>> Coletores salvos e vinculados com sucesso!");


        System.out.println(">>> Carga de dados de teste finalizada com sucesso!");
        System.out.println("Total de Rotas salvas: " + rotaRepository.count());
        System.out.println("Total de Coletores salvos: " + coletorRepository.count());
    }
}
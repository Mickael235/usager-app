package fr.usager.service;

import fr.usager.dto.GareDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GareClientService {
    private final RestClient client = RestClient.builder()
            .baseUrl("http://localhost:9090")
            .build();

    public GareDTO rechercherGare(String nom) {
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/gare/consulter")
                        .queryParam("nom", nom)
                        .build())
                .retrieve()
                .body(GareDTO.class);
    }
}

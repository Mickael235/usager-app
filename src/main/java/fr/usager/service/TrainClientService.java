package fr.usager.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import fr.usager.dto.TrainDTO;

@Service
public class TrainClientService {
    private final RestClient client = RestClient.builder()
            .baseUrl("http://localhost:9090")
            .build();

    public TrainDTO consulter(String matricule) {
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/train/consulter")
                        .queryParam("matricule", matricule)
                        .build())
                .retrieve()
                .body(TrainDTO.class);
    }
}

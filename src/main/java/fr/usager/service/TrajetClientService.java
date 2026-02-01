package fr.usager.service;

import fr.usager.dto.HoraireDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class TrajetClientService {

    private final RestClient client = RestClient.builder()
            .baseUrl("http://localhost:9090")
            .build();

    public List<HoraireDTO> getSchedules(String nomDepart, String nomArrivee) {
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/trajet/schedules")
                        .queryParam("nomDepart", nomDepart)
                        .queryParam("nomArrivee", nomArrivee)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<List<HoraireDTO>>() {});
    }
}

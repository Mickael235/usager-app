package fr.usager.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ReservationClientService {

    private final RestClient client = RestClient.create("http://localhost:9090");

    public void reserver(Integer horaireId, Integer departId, Integer arriveeId,
                         String nom, String prenom, String naissance) {
        client.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/reservations")
                        .queryParam("horaireId", horaireId)
                        .queryParam("departId", departId)
                        .queryParam("arriveeId", arriveeId)
                        .queryParam("nom", nom)
                        .queryParam("prenom", prenom)
                        .queryParam("naissance", naissance)
                        .build())
                .retrieve()
                .toBodilessEntity();
    }
}

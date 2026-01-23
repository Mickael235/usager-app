package fr.usager.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.usager.service.TrainClientService;
import fr.usager.dto.TrainDTO;


@RestController
@RequestMapping("/user")
public class TrainClientController {

    private final TrainClientService service;

    public TrainClientController(TrainClientService service) {
        this.service = service;
    }

    @GetMapping("/train")
    public TrainDTO consulter(@RequestParam String matricule) {
        return service.consulter(matricule);
    }
}

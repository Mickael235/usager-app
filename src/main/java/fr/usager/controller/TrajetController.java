package fr.usager.controller;

import fr.usager.dto.GareDTO;
import fr.usager.dto.HoraireDTO;
import fr.usager.service.GareClientService;
import fr.usager.service.TrajetClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class TrajetController {

    private final GareClientService gareClientService;
    private final TrajetClientService trajetClientService;

    public TrajetController(GareClientService gareClientService, TrajetClientService trajetClientService) {
        this.gareClientService = gareClientService;
        this.trajetClientService = trajetClientService;
    }

    @GetMapping("/trajet/search")
    public String showTrajetSearchPage(Model model) {
        List<GareDTO> gares = gareClientService.getAllGares();
        model.addAttribute("gares", gares);
        return "rechercherTrajet";
    }

    @GetMapping("/trajet/results")
    public String getTrajetResults(
            @RequestParam("nomDepart") String nomDepart,
            @RequestParam("nomArrivee") String nomArrivee,
            Model model) {
        List<HoraireDTO> horaires = trajetClientService.getSchedules(nomDepart, nomArrivee);
        model.addAttribute("horaires", horaires);
        model.addAttribute("nomDepart", nomDepart);
        model.addAttribute("nomArrivee", nomArrivee);

        List<GareDTO> gares = gareClientService.getAllGares();
        model.addAttribute("gares", gares);


        GareDTO depart = gares.stream()
                    .filter(g -> g.getNom_gare() != null && g.getNom_gare().equals(nomDepart))
                    .findFirst()
                    .orElse(null);

        GareDTO arrivee = gares.stream()
                    .filter(g -> g.getNom_gare() != null && g.getNom_gare().equals(nomArrivee))
                    .findFirst()
                    .orElse(null);

            model.addAttribute("depart", depart);
            model.addAttribute("arrivee", arrivee);

        return "rechercherTrajet";
    }
}

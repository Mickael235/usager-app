package fr.usager.controller;

import fr.usager.dto.GareDTO;
import fr.usager.service.GareClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class GareController {

    private final GareClientService service;

    public GareController(GareClientService service) {
        this.service = service;
    }

    @GetMapping("/gare")
    public String showSearchPage() {
        return "rechercherGare";
    }

    @GetMapping("/gare/rechercher")
    public String rechercherGare(@RequestParam String nom, Model model) {
        GareDTO gare = service.rechercherGare(nom);
        model.addAttribute("gare", gare);
        return "rechercherGare";
    }
}

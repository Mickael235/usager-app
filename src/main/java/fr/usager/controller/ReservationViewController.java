package fr.usager.controller;

import fr.usager.service.ReservationClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class ReservationViewController {

    private final ReservationClientService service;

    public ReservationViewController(ReservationClientService service) {
        this.service = service;
    }

    @GetMapping("/reserver")
    public String form(@RequestParam Integer horaireId,
                       @RequestParam Integer departId,
                       @RequestParam Integer arriveeId,
                       Model model) {
        model.addAttribute("horaireId", horaireId);
        model.addAttribute("departId", departId);
        model.addAttribute("arriveeId", arriveeId);
        return "reserver";
    }

    @PostMapping("/reserver")
    public String reserver(@RequestParam Integer horaireId,
                           @RequestParam Integer departId,
                           @RequestParam Integer arriveeId,
                           @RequestParam String nom,
                           @RequestParam String prenom,
                           @RequestParam String naissance,
                           Model model) {
        try {
            service.reserver(horaireId, departId, arriveeId, nom, prenom, naissance);
            model.addAttribute("msg", "Réservation OK");
        } catch (Exception e) {
            model.addAttribute("err", "Erreur réservation: " + e.getMessage());
        }
        return "reserver_result";
    }
}

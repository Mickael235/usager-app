package fr.usager.controller;

import fr.usager.dto.GareDTO;
import fr.usager.dto.HoraireDTO;
import fr.usager.service.GareClientService;
import fr.usager.service.TrajetClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrajetController.class)
public class TrajetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GareClientService gareClientService;

    @MockBean
    private TrajetClientService trajetClientService;

    @Test
    public void testShowTrajetSearchPage() throws Exception {
        GareDTO gare1 = new GareDTO();
        gare1.setNom_gare("Gare A");
        GareDTO gare2 = new GareDTO();
        gare2.setNom_gare("Gare B");
        List<GareDTO> gares = Arrays.asList(gare1, gare2);

        when(gareClientService.getAllGares()).thenReturn(gares);

        mockMvc.perform(get("/user/trajet/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("rechercherTrajet"))
                .andExpect(model().attribute("gares", gares));
    }

    @Test
    public void testGetTrajetResults() throws Exception {
        // Mock Gares
        GareDTO gareDepart = new GareDTO();
        gareDepart.setNom_gare("Gare A");
        GareDTO gareArrivee = new GareDTO();
        gareArrivee.setNom_gare("Gare B");
        List<GareDTO> gares = Arrays.asList(gareDepart, gareArrivee);

        // Mock Horaires
        HoraireDTO horaire1 = new HoraireDTO();
        horaire1.setGareDepart(gareDepart);
        horaire1.setGareArrivee(gareArrivee);
        horaire1.setHeureDepart(LocalTime.of(8, 0));
        horaire1.setHeureArrivee(LocalTime.of(9, 0));
        List<HoraireDTO> horaires = Arrays.asList(horaire1);

        when(gareClientService.getAllGares()).thenReturn(gares);
        when(trajetClientService.getSchedules("Gare A", "Gare B")).thenReturn(horaires);

        mockMvc.perform(get("/user/trajet/results")
                        .param("nomDepart", "Gare A")
                        .param("nomArrivee", "Gare B"))
                .andExpect(status().isOk())
                .andExpect(view().name("rechercherTrajet"))
                .andExpect(model().attribute("horaires", horaires))
                .andExpect(model().attribute("nomDepart", "Gare A"))
                .andExpect(model().attribute("nomArrivee", "Gare B"))
                .andExpect(model().attribute("gares", gares));
    }
}

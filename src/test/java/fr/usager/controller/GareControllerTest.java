package fr.usager.controller;

import fr.usager.dto.GareDTO;
import fr.usager.service.GareClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GareController.class)
public class GareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GareClientService gareClientService;

    @Test
    public void testShowSearchPage() throws Exception {
        mockMvc.perform(get("/user/gare"))
                .andExpect(status().isOk())
                .andExpect(view().name("rechercherGare"));
    }

    @Test
    public void testRechercherGare() throws Exception {
        GareDTO gare = new GareDTO();
        gare.setId_gare(1);
        gare.setNom_gare("Gare de Lyon");
        gare.setVille("Paris");
        gare.setNb_quai(20);

        when(gareClientService.rechercherGare("Gare de Lyon")).thenReturn(gare);

        mockMvc.perform(get("/user/gare/rechercher").param("nom", "Gare de Lyon"))
                .andExpect(status().isOk())
                .andExpect(view().name("rechercherGare"))
                .andExpect(model().attribute("gare", gare));
    }

    @Test
    public void testRechercherGareNotFound() throws Exception {
        when(gareClientService.rechercherGare("Gare Inconnue")).thenReturn(null);

        mockMvc.perform(get("/user/gare/rechercher").param("nom", "Gare Inconnue"))
                .andExpect(status().isOk())
                .andExpect(view().name("rechercherGare"))
                .andExpect(model().attribute("gare", (Object) null));
    }
}

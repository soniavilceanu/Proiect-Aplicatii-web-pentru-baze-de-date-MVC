package com.example.proiectawbd.controllers;

import com.example.proiectawbd.domain.Librarian;
import com.example.proiectawbd.services.LibrarianService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("mysql")
public class LibrarianControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LibrarianService librarianService;

    @MockBean
    Model model;



    @Disabled
    @Test
    public void showByIdMvc() throws Exception {

        mockMvc.perform(get("/librarian/info/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("librarianinfo"));
    }



    @Test
    @WithMockUser(username = "guest", password = "12345", roles = "GUEST")
    public void showByIdMockMvc() throws Exception {
        int id = 1;
        Librarian librarianTest = new Librarian();
        librarianTest.setLibrarianName("Librarian1");
        librarianTest.setEmail("lib1@gmail.com");

        when(librarianService.retrieveLibrarianById(id)).thenReturn(librarianTest);

        mockMvc.perform(get("/librarian/info/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("librarianinfo"))
                .andExpect(model().attribute("librarian", librarianTest))
                //.andExpect(content().contentType(MediaType.TEXT_HTML));
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }



    @Test
    @WithMockUser(username = "guest", password = "12345", roles = "GUEST")
    public void deleteByIdMockMvc() throws Exception {

        mockMvc.perform(get("/librarian/delete/{id}", "1"))
                .andExpect(status().isForbidden());
    }

}



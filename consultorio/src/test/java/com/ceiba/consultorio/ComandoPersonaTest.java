package com.ceiba.consultorio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.fasterxml.jackson.databind.ObjectMapper;

import databuilder.ComandoPersonaDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(ComandoPersona.class)
@ComponentScan("com.ceiba")
public class ComandoPersonaTest {

	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoPersona comandoPersona = new ComandoPersonaDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/consultorio/agregarPersona")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(comandoPersona)))
        		.andExpect(status().isOk());
    }
}
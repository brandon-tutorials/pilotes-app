package com.pilotes.pilotes_app.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 
import com.pilotes.pilotes_app.resquest.SaveOrderRequest;
import com.pilotes.pilotes_app.service.PilotesServiceImpl;


@ExtendWith(value = MockitoExtension.class)
public class PilotesControllerTest {
	
	@InjectMocks
	private PilotesController pilotesController;
	
	@Mock
	private PilotesServiceImpl pilotesServiceImpl;
	
	private SaveOrderRequest saveOrderRequest;
	
	private MockMvc mockMvc;
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		saveOrderRequest = new SaveOrderRequest();
		saveOrderRequest.setDeliveryAddress("Benito Juarez, Av. Teopanzolco 23 Cdmx");
		saveOrderRequest.setNumberOfPilotes(Long.valueOf(5));
		saveOrderRequest.setUserId(Long.valueOf(1));
		mockMvc = MockMvcBuilders.standaloneSetup(pilotesController)
				.addPlaceholderValue("api", "/api/pilotes").build();
	}
	
	@Test
	public void testSaveOrder() throws JsonProcessingException, Exception {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/pilotes/saveOrder")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(ow.writeValueAsString(saveOrderRequest))
		).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		assertNotNull(pilotesController.saveOrder(saveOrderRequest));
	}
	
	@Test
	public void testFindByNameStartWith() throws JsonProcessingException, Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/pilotes/startsWithName/Fer")
		).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());		 
		assertNotNull(pilotesController.findByNameStartWith(null));
	}
}

package com.qa.finalProject.testing.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.finalProject.model.CarParking;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@Sql(scripts = {"classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ControllerTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	
	// Test Object(s):	
	CarParking testSession1 = new CarParking("test_plate1", "test_make1", "test_model1", "test_colour1", 111f, true);
	CarParking testSession2 = new CarParking("test_plate2", "test_make2", "test_model2", "test_colour2", 222f, false);		
	CarParking testSessionID1 = new CarParking(1l, "test_plate1", "test_make1", "test_model1", "test_colour1", 111f, true);
	CarParking testSessionID2 = new CarParking(2l, "test_plate2", "test_make2", "test_model2", "test_colour2", 222f, false);

	@BeforeAll
	public void setup() throws Exception{
		
		String sessionJson = mapper.writeValueAsString(testSession1);
		RequestBuilder req = post("/createSession").contentType(MediaType.APPLICATION_JSON).content(sessionJson);
		mvc.perform(req); 
	}
		
	@Test
	public void testNewSession() throws Exception{
		// Arrange
		String sessionJson = mapper.writeValueAsString(testSession1);
		RequestBuilder request = post("/createSession").contentType(MediaType.APPLICATION_JSON).content(sessionJson);
		// Act
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().string("New session added with ID: 3 for vehicle: test_plate1");
		// Assert
		mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	public void testFindById() throws Exception{
		
		CarParking testSessionId = testSessionID1;
		testSessionId.setId(1l);
		
		String testSessionIdJson = mapper.writeValueAsString(testSessionId);
		
		RequestBuilder request = get("/getId/1");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testSessionIdJson);
		
		mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	public void testGetAll() throws Exception{
		List<CarParking> testList = List.of(testSessionID1, testSessionID2);
		String testListJson = mapper.writeValueAsString(testList);
		
		RequestBuilder request = get("/getAll");
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testListJson);
		
		mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

		
	}
	
	@Test
	public void testDeleteById() throws Exception{
		RequestBuilder req = delete("/deleteId/1");		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().string("Session: 1 ended.");
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); 
	}
	@Test
	public void testDeleteAll() throws Exception{
		RequestBuilder req = delete("/deleteAll");		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().string("All sessions removed.");
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); 
	}
	@Test
	public void testUpdate() throws Exception{
		CarParking updatedSession = new CarParking("test_plate2", "test_make2", "test_model2", "test_colour2", 222f, false);
		String updatedSessionJson = mapper.writeValueAsString(updatedSession);
		
		RequestBuilder req = put("/updateId/1").contentType(MediaType.APPLICATION_JSON).content(updatedSessionJson);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().string("Session 1 updated to " + updatedSession + ".");

		// ASSERT
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);	
		
		
	}
	
	@Test
	public void equalsContract() {
	    EqualsVerifier.forClass(CarParking.class).usingGetClass().verify();
	}


	
		
}

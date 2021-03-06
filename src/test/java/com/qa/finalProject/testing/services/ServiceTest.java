package com.qa.finalProject.testing.services;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import com.qa.finalProject.Services.ServiceDB;
import com.qa.finalProject.model.CarParking;
import com.qa.finalProject.repo.Repo;

@SpringBootTest
@ActiveProfiles("dev")
public class ServiceTest {
	
	private CarParking testSessionIn;
	private CarParking testSessionOut;
	
	@MockBean
	private Repo repo;
	
	@Autowired
	private ServiceDB service;	

	CarParking testSession1 = new CarParking("test_plate1", "test_make1", "test_model1", "test_colour1", 111f, true);
	CarParking testSession2 = new CarParking("test_plate2", "test_make2", "test_model2", "test_colour2", 222f, false);		
	CarParking testSessionID1 = new CarParking(1l, "test_plate1", "test_make1", "test_model1", "test_colour1", 111f, true);
	CarParking testSessionID2 = new CarParking(2l, "test_plate2", "test_make2", "test_model2", "test_colour2", 222f, false);
	
	@BeforeEach
	void setUp() {
		testSessionIn = new CarParking("test_plate1", "test_make1", "test_model1", "test_colour1", 111f, true);
		testSessionOut = new CarParking(1l, "test_plate1", "test_make1", "test_model1", "test_colour1", 111f, true);

		
	}
	
	
	@Test
	public void testNewSession() {
		// Arrange
		Mockito.when(repo.save(testSessionIn)).thenReturn(testSessionOut);
		// Act
		boolean result = service.newSession(testSessionIn);
		System.out.println(result);
		System.out.println(testSessionOut);
		// Assert
		Assertions.assertTrue(result);
		// Mockito.verify(repo, Mockito.times(1));
	}
	
	@Test
	public void testFindById() {
		Long id = 1l;
		/*Optional<CarParking> testCarParking = Optional.of(testSessionOut);*/
		// Arrange
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(testSessionOut));
		// Act
		CarParking result = service.findById(1l);
		// Assert
		Assertions.assertEquals(testSessionOut, result);
	}
	
	@Test
	public void testFindAll() {
		// Arrange
		List<CarParking> testList = new ArrayList<>();
		testList.add(testSessionIn);
		// Act
		Mockito.when(this.repo.findAll()).thenReturn(testList);
		// Assert
		assertThat(this.service.getSessions()).isEqualTo(testList);
	}
	

	
	@Test
	public void testDeleteById() {
		Long id = 1l;
		Optional<CarParking> toBeDeleted = Optional.of(testSessionOut);
		boolean result =
		Mockito.when(this.repo.findById(id)).thenReturn(toBeDeleted) != null;
		
		Assertions.assertTrue(result);
		assertThat(service.deleteById(id)).isTrue();
		
		
		
	}
	
	@Test
	public void testDeleteAll() {
		Long id = 1l;
		boolean result = 
		Mockito.when(this.repo.existsById(id)).thenReturn(false) != null;
		Assertions.assertTrue(result);
		assertThat(service.deleteAll()).isTrue();
		
		
	}
	@Test
	public void testUpdateEntry() {

		Mockito.when(repo.findById((long) 1)).thenReturn(Optional.of(testSessionOut));
		CarParking sessionToUpdate = service.findById(1);
		sessionToUpdate.setNumber_plate("updated");
		CarParking testUpdate = new CarParking(2, "test_plate2", "test_make2", "test_model2", "test_colour2", 222f, false);
		
		sessionToUpdate.setId(testUpdate.getId());
		sessionToUpdate.setNumber_plate(testUpdate.getNumber_plate());
		sessionToUpdate.setMake(testUpdate.getMake());
		sessionToUpdate.setModel(testUpdate.getModel());
		sessionToUpdate.setColour(testUpdate.getColour());
		sessionToUpdate.setPrice(testUpdate.getPrice());
		sessionToUpdate.setPaid(testUpdate.isPaid());
		this.repo.save(sessionToUpdate);
		CarParking updatedSession = service.findById(1);
		
		Assertions.assertEquals(sessionToUpdate, updatedSession);
		
	}
	
	


}

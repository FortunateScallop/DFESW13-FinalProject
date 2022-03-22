package com.qa.finalProject.controller;

import com.qa.finalProject.Services.*;
import com.qa.finalProject.model.*;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private ServiceDB service;
	
	public Controller(ServiceDB service) {
		super();
		this.service = service;
	}
	@PostMapping("/createSession")
	public ResponseEntity<String> newSession(@RequestBody CarParking session){
		
		service.newSession(session);
		
		ResponseEntity<String> response = new ResponseEntity<>("New session added with ID: " + session.getId() + " for vehicle: " + session.getNumber_plate(), HttpStatus.CREATED);
		return response;		
	}
	@GetMapping("/getId/{id}")
	public ResponseEntity<CarParking> findById(@PathVariable("id") long id){
		
		CarParking result = service.findById(id);
		
		ResponseEntity<CarParking> response = new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		
		return response;
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<CarParking>> getSessions(){
		List<CarParking> response = service.getSessions();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteId/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
		service.deleteById(id);
		return new ResponseEntity<>("Session: " + id + " ended.", HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		service.deleteAll();
	
		return new ResponseEntity<>("All sessions removed.", HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateId/{id}")
	public String updateEntry(@PathVariable("id") long id, @RequestBody CarParking session) {
		service.updateEntry(id, session);
		return "Session " + id + " updated to " + session + ".";
	}
	// Find Entries by Keyword (number_plate)

}

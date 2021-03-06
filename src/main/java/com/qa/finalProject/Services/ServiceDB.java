package com.qa.finalProject.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.finalProject.model.CarParking;
import com.qa.finalProject.repo.Repo;

@Service
public class ServiceDB {
	
	private Repo repo;
	
	public ServiceDB(Repo repo) {
		super();
		this.repo = repo;
	}
	// Create New Entry
	public boolean newSession(CarParking session) {
		repo.save(session);
		return true;
	}
		
	// Find Entry by ID
	public CarParking findById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	
	// Find All Entries
	public List<CarParking> getSessions(){
		return repo.findAll();
	}
	// Remove Entry by ID
	public boolean deleteById(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	// Remove All Entries
	public boolean deleteAll() {
		this.repo.deleteAll();
		return true;
	}
	// Update Entry by ID
	public boolean updateEntry(long id, CarParking session) {
		
		CarParking oldSession = findById(id);
		
		oldSession.setNumber_plate(session.getNumber_plate());
		oldSession.setMake(session.getMake());
		oldSession.setModel(session.getModel());
		oldSession.setColour(session.getColour());
		oldSession.setPrice(session.getPrice());
		oldSession.setPaid(session.isPaid());
		
		CarParking updatedSession = oldSession;
		repo.save(updatedSession);
		
		return true;		
	}
	// Find Entries by Keyword (number_plate)
	

}

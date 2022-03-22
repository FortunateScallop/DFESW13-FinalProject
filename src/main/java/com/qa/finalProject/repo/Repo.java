package com.qa.finalProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.finalProject.model.CarParking;

public interface Repo extends JpaRepository<CarParking, Long>{

}

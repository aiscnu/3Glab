package com.scnuai.glab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scnuai.glab.models.Equipment;
import com.scnuai.glab.repositories.EquipmentRepository;

@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	//Get All Equipments
	public List<Equipment> findAll(){
		return equipmentRepository.findAll();
	}	
	
	//Get Equipment By Id
	public Optional<Equipment> findById(int id) {
		return equipmentRepository.findById(id);
	}	
	
	//Delete Equipment
	public void delete(int id) {
		equipmentRepository.deleteById(id);
	}
	
	//Update Equipment
	public void save( Equipment equipment) {
		equipmentRepository.save(equipment);
	}

}

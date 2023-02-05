package com.scnuai.glab.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scnuai.glab.models.Equipment;
import com.scnuai.glab.services.EquipmentService;

@Controller
public class EquipmentController {
	
	@Autowired private EquipmentService equipmentService;
	
	//Get All Equipments
	@GetMapping("equipments")
	public String findAll(Model model){		
		model.addAttribute("equipments", equipmentService.findAll());
		return "equipment";
	}	
	
	@RequestMapping("equipments/findById") 
	@ResponseBody
	public Optional<Equipment> findById(Integer id)
	{
		return equipmentService.findById(id);
	}
	
	//Add Equipment
	@PostMapping(value="equipments/addNew")
	public String addNew(Equipment equipment) {
		equipmentService.save(equipment);
		return "redirect:/equipments";
	}	
	
	@RequestMapping(value="equipments/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Equipment equipment) {
		equipmentService.save(equipment);
		return "redirect:/equipments";
	}
	
	@RequestMapping(value="equipments/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		equipmentService.delete(id);
		return "redirect:/equipments";
	}
}

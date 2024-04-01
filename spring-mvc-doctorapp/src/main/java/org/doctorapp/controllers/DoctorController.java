package org.doctorapp.controllers;

import java.util.List;

import org.doctorapp.model.Doctor;
import org.doctorapp.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {
	
	@Autowired
	IDoctorService doctorService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Doctor> doctors = doctorService.getAll();
		model.addAttribute("doctors", doctors);
		return "home";
	}
	
	@RequestMapping("/addDoctor")
	public String addDoctor(Doctor doctor) {
		doctorService.addDoctor(doctor);
		return "adminDash";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("speciality")String choice, Model model) {
		List<Doctor> doctor =  doctorService.getBySpeciality(choice);
		model.addAttribute("doctor", doctor);
		return "success";
	}
	
	@RequestMapping("/editDoctor")
	public String editDoctor(@RequestParam("doctorId") int doctorId, Model model) {
		Doctor doctor = doctorService.getById(doctorId);
		model.addAttribute("doctor", doctor);
		return "updateDoc";
	}
	
	@RequestMapping("/updateDoctor")
	public String updateDoctor(@RequestParam("doctorId") int doctorId, @RequestParam("fees") double fees, Model model) {
		doctorService.updateDoctor(doctorId, fees);
		model.addAttribute("message", "doctor updated successfully");
		return "adminDash";
	}
	
	@RequestMapping("/deleteDoctor")
	public String deleteDoctor(@RequestParam("doctorId") int doctorId, Model model) {
		doctorService.deleteDoctor(doctorId);
		model.addAttribute("message", "doctor deleted successfully");
		return "adminDash";
	}
}

package org.doctorapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

	
	@RequestMapping("admin")
	public String admin(Model model) {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(@RequestParam("username") String username, @RequestParam("password")String password){
		if(username.equals("admin") && password.equals("1234"))
			return "adminDash";
		return "login";
	}
	
	@RequestMapping("addDoctorForm")
	public String addDoctor(Model model) {
		return "addDoc";
	}
	
	@RequestMapping("updateDoctorForm")
	public String updateDoctor(Model model) {
		return "updateDoc";
	}
	
	@RequestMapping("editDoctorForm")
	public String editDoctor(Model model) {
		return "editDoc";
	}
	
	@RequestMapping("deleteDoctorForm")
	public String deleteDoctor(Model model) {
		return "deleteDoc";
	}
}

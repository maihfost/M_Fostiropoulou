/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfedu.trainerspringboot.controllers;

import java.util.List;
import org.mfedu.trainerspringboot.entities.Trainer;
import org.mfedu.trainerspringboot.services.TrainerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author maih_sofi
 */
@Controller
@RequestMapping("/")
public class TrainerController {
    @Autowired
	private TrainerImpl service; 
    
        @GetMapping("/")
	public String viewHomePage(Model model) {
		List<Trainer> listTrainers = service.listAll();
		model.addAttribute("listTrainers", listTrainers);
		model.addAttribute("edit", "/edit");
		model.addAttribute("delete", "/delete");
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewTrainerPage(Model model) {
		Trainer trainer = new Trainer();
		model.addAttribute("trainer", trainer);
		
		return "new_trainer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTrainer(@ModelAttribute("trainer") Trainer trainer) {
		service.save(trainer);
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showEditTrainerPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_trainer");
		Trainer trainer = service.get(id);
		mav.addObject("trainer", trainer);  
                return mav;
	}

	
	@RequestMapping("/delete/{id}")
	public String deleteTrainer(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}

package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {


	@GetMapping("form.html")
	public ModelAndView displayForm() {
		ModelAndView mv = new ModelAndView("form");


		return mv;
	}

    @GetMapping("results.html")
    public ModelAndView displayResults() {
        ModelAndView mv = new ModelAndView("results");
        return mv;
    }


}

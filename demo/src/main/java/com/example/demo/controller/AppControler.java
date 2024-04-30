package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.tipData;



@Controller
public class AppControler {
    

    @GetMapping({"/","/form.html"})
	public ModelAndView displayForm() {
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("formData", new tipData());
		return mv;
	}

    @PostMapping("/send")
	public ModelAndView processForm(@ModelAttribute tipData tipData, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("tipData", tipData);

		// fmv.validate(tipData, result);

		if (result.hasErrors())
			mv.setViewName("form");
		else
			mv.setViewName("result");

		return mv;
	}
}

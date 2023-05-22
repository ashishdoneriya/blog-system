package com.csetutorials.multiblogapp.controllers;

import com.csetutorials.multiblogapp.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

	@Autowired
	WebsiteService websiteService;

	@ModelAttribute
	public void addCommonAttributes(Model model) {
		model.addAttribute("website", websiteService.getWebsite());
	}
}

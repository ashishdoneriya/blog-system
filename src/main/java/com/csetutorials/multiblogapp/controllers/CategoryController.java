package com.csetutorials.multiblogapp.controllers;

import com.csetutorials.multiblogapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;


}

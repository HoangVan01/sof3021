package com.sof3021_assignment.demo.controllers.user;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sof3021_assignment.demo.beans.ProductModel;
import com.sof3021_assignment.demo.entities.Product;
import com.sof3021_assignment.demo.repositories.ProductRepository;

@Controller
@RequestMapping("/user/detail")
public class ProductDetailController {
	@Autowired
	ProductRepository proRepo;
	
	
	@GetMapping("/user/detail/{id}")
	public String update(@PathVariable("id") Product acc, @ModelAttribute("product") ProductModel model) {
		
		return "user/detail/";
	}
}

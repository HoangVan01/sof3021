package com.sof3021_assignment.demo.controllers.user;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sof3021_assignment.demo.beans.AccountModel;
import com.sof3021_assignment.demo.beans.ProductModel;
import com.sof3021_assignment.demo.entities.Account;
import com.sof3021_assignment.demo.entities.Product;
import com.sof3021_assignment.demo.repositories.ProductRepository;

@Controller

public class HomeController {
	@Autowired
	ProductRepository proRepo;
	

	@GetMapping("/user/index")
	public String index(
		Model model,
		@RequestParam(name="page", defaultValue="0") Integer page,
		@RequestParam(name="size", defaultValue="6") Integer size
		
	) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> data = this.proRepo.findAll(pageable);
		
		model.addAttribute("data", data);
		return "user/index";
	}
	@GetMapping("/user/detail/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		
	return "/user/detail";
	}

}

package com.sof3021_assignment.demo.controllers.admin;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sof3021_assignment.demo.beans.CategoryModel;
import com.sof3021_assignment.demo.entities.Category;
import com.sof3021_assignment.demo.repositories.CategoryRepository;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	private CategoryRepository cateRepo;
	
	@GetMapping("create")
	public String create(@ModelAttribute("category") CategoryModel category )
	{
		return "admin/categories/create";
	}
	
	@PostMapping("store")
	public String store(CategoryModel cateModel)
	{
		
		Category category = new Category();
		category.setName(cateModel.getName());
		this.cateRepo.save(category);

		return "redirect:/admin/categories/index";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id )
	{


		cateRepo.deleteById(id);
		return "redirect:/admin/categories/index";
		
	}
	@GetMapping("update/{id}")
	public String update(@PathVariable("id") Category cate, @ModelAttribute("category") CategoryModel model) {
		cate.setName(model.getName());
		this.cateRepo.save(cate);
		return "redirect:/admin/categories/index";
	}
	@GetMapping("index")
	public String index(Model model,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Category> data = this.cateRepo.findAll(pageable);
		model.addAttribute("data", data);
		return "admin/categories/index";
	}
}

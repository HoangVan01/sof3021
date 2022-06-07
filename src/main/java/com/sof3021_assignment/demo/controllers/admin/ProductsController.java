package com.sof3021_assignment.demo.controllers.admin;

import java.util.List;

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

import com.sof3021_assignment.demo.beans.AccountModel;
import com.sof3021_assignment.demo.beans.ProductModel;
import com.sof3021_assignment.demo.entities.Category;
import com.sof3021_assignment.demo.entities.Product;
import com.sof3021_assignment.demo.repositories.CategoryRepository;
import com.sof3021_assignment.demo.repositories.ProductRepository;

@Controller
@RequestMapping("/admin/products")
public class ProductsController {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository cateRepo;
	@GetMapping("create")
	public String create(@ModelAttribute("product") ProductModel product , Model model )
	{
		List<Category> listCate = this.cateRepo.findAll();
		model.addAttribute("listCate", listCate);
		return "admin/products/create";
	}
	
	@PostMapping("store")
	public String store(ProductModel product , Model model) {
	List<Category> listCate = this.cateRepo.findAll();
	model.addAttribute("listCate", listCate);
		Product pro = new Product();
		pro.setAvailable(product.getAvailable());
		pro.setImage(product.getImage());
		pro.setName(product.getName());
		pro.setPrice(product.getPrice());
		pro.setCategory(product.getCategory());
		pro.setCreatedDate(product.getCreatedDate());
		this.productRepo.save(pro);
		return "redirect:/admin/products/index";
	}
	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("product") ProductModel product) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.productRepo.findAll(pageable);
		List<Category> listCate = this.cateRepo.findAll();
		model.addAttribute("listCate", listCate);
		model.addAttribute("data", p);
		return "admin/products/index";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Product product) {
		this.productRepo.delete(product);
		return "redirect:/admin/products/index";
	}
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Product pro, @ModelAttribute("product") ProductModel product) {
		pro.setAvailable(product.getAvailable());
//		pro.setCategory(product.getCategory());
		pro.setImage(product.getImage());
		pro.setCreatedDate(product.getCreatedDate());
		pro.setName(product.getName());
		pro.setPrice(product.getPrice());

		this.productRepo.save(pro);
		return "redirect:/admin/products/index";
	}
	
}

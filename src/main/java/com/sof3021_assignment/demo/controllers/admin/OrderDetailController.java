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

import com.sof3021_assignment.demo.beans.OrderDetailModel;
import com.sof3021_assignment.demo.beans.OrderModel;
import com.sof3021_assignment.demo.entities.Account;
import com.sof3021_assignment.demo.entities.Order;
import com.sof3021_assignment.demo.entities.OrderDetail;
import com.sof3021_assignment.demo.entities.Product;
import com.sof3021_assignment.demo.repositories.AccountRepository;
import com.sof3021_assignment.demo.repositories.OrderDetailRepository;
import com.sof3021_assignment.demo.repositories.OrderRepository;
import com.sof3021_assignment.demo.repositories.ProductRepository;

@Controller
@RequestMapping("/admin/orderdetails")
public class OrderDetailController {
	@Autowired
	private OrderDetailRepository orderdeRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private ProductRepository proRepo;
	@GetMapping("create")
	public String create(@ModelAttribute("order") OrderDetailModel orderdetail , Model model )
	{
		List<Order> listOrd = this.orderRepo.findAll();
		model.addAttribute("listOrd", listOrd);
		List<Product> listPro = this.proRepo.findAll();
		model.addAttribute("listPro", listPro);
		return "admin/orderdetails/create";
	}
	@PostMapping("store")
	public String store(OrderDetailModel orderde , Model model) {
		List<Order> listOrd = this.orderRepo.findAll();
		model.addAttribute("listOrd", listOrd);
		List<Product> listPro = this.proRepo.findAll();
		model.addAttribute("listPro", listPro);
		OrderDetail ordde = new OrderDetail();
		
		ordde.setPrice(orderde.getPrice());
		ordde.setQuantity(orderde.getQuantity());
		ordde.setOrder(orderde.getOrder());
		ordde.setProduct(orderde.getProduct());
		
	
		
		this.orderdeRepo.save(ordde);
		return "redirect:/admin/orderdetails/index";
	}
	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("orderde") OrderDetailModel orderde) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<OrderDetail> data = this.orderdeRepo.findAll(pageable);

		model.addAttribute("data", data);
		List<Order> listOrd = this.orderRepo.findAll();
		model.addAttribute("listOrd", listOrd);
		List<Product> listPro = this.proRepo.findAll();
		model.addAttribute("listPro", listPro);
		return "admin/orderdetails/index";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") OrderDetail orderde) {
		this.orderdeRepo.delete(orderde);
		return "redirect:/admin/orderdetails/index";
	}
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") OrderDetail ordde, @ModelAttribute("orderde") OrderDetailModel order) {
		ordde.setQuantity(order.getQuantity());
		ordde.setPrice(order.getPrice());

		this.orderdeRepo.save(ordde);
		return "redirect:/admin/orderdetails/index";
	}
	@PostMapping("mail/{id}")
	public String mail(@PathVariable("id") OrderDetail ordde, @ModelAttribute("orderde") OrderDetailModel order) {
	
		return "redirect:/admin/orderdetails/index";
	}
	
}

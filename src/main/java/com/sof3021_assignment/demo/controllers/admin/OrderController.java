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

import com.sof3021_assignment.demo.beans.OrderModel;
import com.sof3021_assignment.demo.beans.ProductModel;
import com.sof3021_assignment.demo.entities.Account;
import com.sof3021_assignment.demo.entities.Category;
import com.sof3021_assignment.demo.entities.Order;
import com.sof3021_assignment.demo.entities.Product;
import com.sof3021_assignment.demo.repositories.AccountRepository;
import com.sof3021_assignment.demo.repositories.OrderRepository;
import com.sof3021_assignment.demo.repositories.ProductRepository;

@Controller
@RequestMapping("/admin/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private AccountRepository accRepo;
	@GetMapping("create")
	public String create(@ModelAttribute("order") OrderModel order , Model model )
	{
		List<Account> listAcc = this.accRepo.findAll();
		model.addAttribute("listAcc", listAcc);
		return "admin/orders/create";
	}
	@PostMapping("store")
	public String store(OrderModel order , Model model) {
		List<Account> listAcc = this.accRepo.findAll();
		model.addAttribute("listAcc", listAcc);
		Order ord = new Order();
		
		ord.setAccount(order.getAccount());
		ord.setAddress(order.getAddress());
		ord.setCreateDate(order.getCreateDate());
	
		
		this.orderRepo.save(ord);
		return "redirect:/admin/orders/index";
	}
	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("order") OrderModel order) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
		Page<Order> data = this.orderRepo.findAll(pageable);
		List<Account> listAcc = this.accRepo.findAll();
		model.addAttribute("listAcc", listAcc);
		model.addAttribute("data", data);
		return "admin/orders/index";
	}
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Order ord, @ModelAttribute("order") OrderModel order) {
		ord.setAddress(order.getAddress());
		ord.setCreateDate(order.getCreateDate());

		this.orderRepo.save(ord);
		return "redirect:/admin/orders/index";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Order order) {
		this.orderRepo.delete(order);
		return "redirect:/admin/orders/index";
	}
}

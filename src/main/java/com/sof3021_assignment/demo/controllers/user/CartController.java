package com.sof3021_assignment.demo.controllers.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sof3021_assignment.demo.entities.Account;
import com.sof3021_assignment.demo.entities.Order;
import com.sof3021_assignment.demo.entities.OrderDetail;
import com.sof3021_assignment.demo.entities.Product;
import com.sof3021_assignment.demo.repositories.OrderDetailRepository;
import com.sof3021_assignment.demo.repositories.OrderRepository;
import com.sof3021_assignment.demo.repositories.ProductRepository;

@Controller
public class CartController {

	@Autowired
	
	private OrderDetailRepository odetailRepo;
	@Autowired
	private OrderRepository oderRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private HttpSession session;

	@GetMapping("/user/cart")
	public String index(Model model) {
//		System.out.println("check : " + this.odetailRepo.getHistory());
		List<OrderDetail> listDetail = odetailRepo.findAll();
		model.addAttribute("listDetail", listDetail);
		return "/user/cart";
	}

	@GetMapping("/user/add/{id}")
	public String add(@RequestParam(name = "price", defaultValue = "0") double price,
			@RequestParam(name = "id", defaultValue = "id") Integer id,
			@RequestParam(name = "quantity") String quantity) {
		Order order = new Order();
		Account account = (Account) session.getAttribute("userLogin");
		order.setAddress("HANOI");
		order.setAccount(account);
		order.setAddress("0000-00-00");
		
		this.oderRepo.save(order);
		OrderDetail odetail = new OrderDetail();
		Product pro = this.productRepo.findById(id).get();
		odetail.setQuantity(Integer.valueOf(quantity.substring(1)));
		odetail.setProduct(pro);
		odetail.setPrice(price);
		odetail.setOrder(order);

		this.odetailRepo.save(odetail);
		return "redirect:/user/cart";
	}
}
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

import com.sof3021_assignment.demo.beans.AccountModel;
import com.sof3021_assignment.demo.entities.Account;



@Controller
@RequestMapping("/admin/accounts")
public class AccountController {
	@Autowired
	private com.sof3021_assignment.demo.repositories.AccountRepository accountRepo;
	
//	@Autowired
//	private Account account;
	
	@GetMapping("create")
	public String create(@ModelAttribute("account") AccountModel account )
	{
		return "admin/accounts/create";
	}
	
	@PostMapping("store")
	public String store(AccountModel accModel)
	{
		// Chuyển AccountModel -> entities.Account
		Account account = new Account();
		account.setFullname(accModel.getFullname());
		account.setEmail(accModel.getEmail());
		account.setUsername(accModel.getUsername());
		account.setPassword(accModel.getPassword());
		account.setPhoto(accModel.getPhoto());
		account.setAdmin(accModel.getAdmin());
		account.setActivated(0);
		this.accountRepo.save(account);

		return "redirect:/admin/accounts/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id )
	{
//		// Truy vấn theo id
////		Account a = this.accountRepo.getOne(id);
//		System.out.println(account.getEmail());
		accountRepo.deleteById(id);
		return "redirect:/admin/accounts/index";
		
	}
	@GetMapping("update/{id}")
	public String update(@PathVariable("id") Account acc, @ModelAttribute("account") AccountModel model) {
		acc.setFullname(model.getFullname());
		acc.setEmail(model.getEmail());
		acc.setUsername(model.getUsername());
		acc.setPhoto(model.getPhoto());
		this.accountRepo.save(acc);
		return "redirect:/admin/accounts/index";
	}

	
		
	
	
	@GetMapping("index")
	public String index(
		Model model,
		@RequestParam(name="page", defaultValue="0") Integer page,
		@RequestParam(name="size", defaultValue="5") Integer size
	) {
//		Account a = this.accountRepo.findAccountFPTByUsername("vanvhph13971");
//		System.out.println(a.getFullname());
		Pageable pageable = PageRequest.of(page, size);
		Page<Account> data = this.accountRepo.findAll(pageable);
		model.addAttribute("data", data);
		return "admin/accounts/index";
	}
}
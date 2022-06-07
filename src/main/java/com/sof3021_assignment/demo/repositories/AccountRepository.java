package com.sof3021_assignment.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sof3021_assignment.demo.entities.Account;



public interface AccountRepository
	extends JpaRepository<Account, Integer> {

	@Query("SELECT acc FROM Account acc WHERE email LIKE %:username%")
	public Account findAccountFPTByUsername(@Param("username") String username);
	
	@Query(name="Account.findByEmail")
	public Account timTheoEmail(@Param("email") String email);
	
	public List<Account> findByFullnameLike(String fullname);
}
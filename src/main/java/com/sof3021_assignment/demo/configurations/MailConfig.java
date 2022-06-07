package com.sof3021_assignment.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;

import com.sof3021_assignment.demo.repositories.OrderDetailRepository;
import com.sof3021_assignment.demo.repositories.OrderRepository;

public class MailConfig {
	@Autowired
	private OrderDetailRepository orderdeRepo;
	@Autowired
	private OrderRepository orderRepo;
    public static final String MY_EMAIL = "vanvhph13971@fpt.edu.vn";

  
    public static final String MY_PASSWORD = "Vihoangvan2572002";

 
    public static final String FRIEND_EMAIL = "yourFriend@gmail.com";
}

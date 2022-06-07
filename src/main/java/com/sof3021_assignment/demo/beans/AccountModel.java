package com.sof3021_assignment.demo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountModel {
	
	private String fullname;
	private String email;
	private String username;
	private String password;
	private String photo;
	private int admin;
}

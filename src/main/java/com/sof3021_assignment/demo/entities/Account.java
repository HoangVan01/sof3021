

package com.sof3021_assignment.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="accounts")
@NamedQueries(
	@NamedQuery(name="Account.findByEmail", query="SELECT o FROM Account o WHERE email = :email")
)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	
	private int id;
	
	@Column(name="username")
	@NotEmpty(message = "Thiếu username")
	private String username;

	@Column(name="password")
	  @NotEmpty(message = "Thiếu password")
    @Min(value = 3, message = "Password phải từ 3 kí tự trở lên")
	private String password;
	
	@Column(name="fullname")
	@NotEmpty(message = "Thiếu fullname")
	private String fullname;
	
	@Column(name="email")
	@Email(message = "Email không hợp lệ")
	private String email;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="activated")
	private int activated;
	
	@Column(name="admin")
	private int admin;
}

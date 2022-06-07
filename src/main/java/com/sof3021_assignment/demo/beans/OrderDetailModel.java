package com.sof3021_assignment.demo.beans;

import com.sof3021_assignment.demo.entities.Order;
import com.sof3021_assignment.demo.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailModel {
	
	private double price;
	private int quantity;
	private Order order;
	private Product product;
}

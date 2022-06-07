package com.sof3021_assignment.demo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemModel {
	Integer productId;
	String name;
	double price;
	int quantity = 1;
}

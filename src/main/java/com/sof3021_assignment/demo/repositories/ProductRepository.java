package com.sof3021_assignment.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sof3021_assignment.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}

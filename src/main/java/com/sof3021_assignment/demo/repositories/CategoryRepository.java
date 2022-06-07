package com.sof3021_assignment.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof3021_assignment.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}

package com.sof3021_assignment.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sof3021_assignment.demo.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{

}

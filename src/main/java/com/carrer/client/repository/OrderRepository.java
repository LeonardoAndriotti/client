package com.carrer.client.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrer.client.model.Order;

public interface OrderRepository extends JpaRepository<Order, BigDecimal> {

}

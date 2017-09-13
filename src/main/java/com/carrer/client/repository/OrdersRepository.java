package com.carrer.client.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.carrer.client.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, BigDecimal> {	
	
	public static final String UPDATE_ORDER_STATUS = "update Orders " + 
				" set status=:status WHERE id=:id ";

	
	@Query(UPDATE_ORDER_STATUS)
	void updateOrderStatus(@RequestParam("id")BigDecimal id,@RequestParam("status") String status);
}

package com.carrer.client.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrer.client.model.Orders;
import com.carrer.client.repository.OrdersRepository;


@RestController
public class OrdersController {

	@Autowired
	private OrdersRepository repository;

	@RequestMapping(value = "/orders/", method = RequestMethod.GET)
	public List<Orders> findAllOrders() {
		return repository.findAll();
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public Orders findOrder(@PathVariable BigDecimal id) {
		return repository.findOne(id);
	}

	@RequestMapping(value = "/orders/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveOrderInApplication(@RequestBody Orders orders) {
		repository.save(orders);
	}

	@RequestMapping(value = "/orders/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Orders orders) {
		repository.saveAndFlush(orders);
	}

	@PutMapping(value = "/orders/{id}/{status}")
	public void statusUpdate(@PathVariable BigDecimal id, @PathVariable String status) {
		repository.updateOrderStatus(id, status);
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable BigDecimal id) {
		repository.delete(id);
	}

}

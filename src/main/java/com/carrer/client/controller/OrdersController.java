package com.carrer.client.controller;

import com.carrer.client.model.Orders;
import com.carrer.client.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


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

    @RequestMapping(value = "/orders/carrer/{idCart}", method = RequestMethod.GET)
    public List<Orders> findByOrderForIdCart(@PathVariable BigDecimal idCart) {
        return repository.findByIdcarrier(idCart);
    }
    @RequestMapping(value = "/orders/user/{idUser}", method = RequestMethod.GET)
    public List<Orders> findByOrderForIdUser(@PathVariable BigDecimal idUser) {
        return repository.findByIdUser(idUser);
    }

    @RequestMapping(value = "/orders/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrderInApplication(@RequestBody Orders orders) {
        repository.save(orders);
    }

    @RequestMapping(value = "/orders/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Orders orders) {
        repository.saveAndFlush(orders);
    }

    @Transactional
    @RequestMapping(value = "/orders/{id}/{status}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void statusUpdate(@PathVariable BigDecimal id, @PathVariable("status") String status) {
        this.repository.updateOrderStatus(id, status);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable BigDecimal id) {
        repository.delete(id);
    }

}

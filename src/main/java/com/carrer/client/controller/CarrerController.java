package com.carrer.client.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carrer.client.model.Carrer;
import com.carrer.client.repository.CarrerRepository;

@Controller
public class CarrerController {
	
	@Autowired
	private CarrerRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Carrer> findAllCarrers() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Carrer findCarrer(@RequestBody BigDecimal id){
		return repository.findOne(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveCarrerInApplication(@RequestBody Carrer carrer){
		repository.save(carrer);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Carrer carrer) {
		repository.saveAndFlush(carrer);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody BigDecimal id) {
		repository.delete(id);
	}
}

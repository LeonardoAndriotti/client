package com.carrer.client.controller;

import com.carrer.client.model.Carrer;
import com.carrer.client.repository.CarrerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CarrerController {

    @Autowired
    private CarrerRepository repository;

    @RequestMapping(value = "/carrer/", method = RequestMethod.GET)
    public List<Carrer> findAllCarrers() {
        return repository.findAll();
    }

    @RequestMapping(value = "/carrer/{id}", method = RequestMethod.GET)
    public Carrer findCarrer(@PathVariable BigDecimal id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/carrer/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveCarrerInApplication(@RequestBody Carrer carrer) {
        repository.save(carrer);
    }

    @RequestMapping(value = "/carrer/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Carrer carrer) {
        repository.saveAndFlush(carrer);
    }

    @RequestMapping(value = "/carrer/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable BigDecimal id) {
        repository.delete(id);
    }
}

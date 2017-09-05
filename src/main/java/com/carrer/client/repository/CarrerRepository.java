package com.carrer.client.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carrer.client.model.Carrer;

public interface CarrerRepository extends JpaRepository<Carrer, BigDecimal>{
	
	public static final String FIND_ORDER_BY_LAST_DAYS = "SELECT * "
			+ "FROM order WHERE :data < current_date";
	
	@Query(CarrerRepository.FIND_ORDER_BY_LAST_DAYS)
	List<Carrer> findOrdeByDateInteval(Date data);
}
package com.carrer.client.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carrer.client.model.Carrer;

public interface CarrerRepository extends JpaRepository<Carrer, BigDecimal>{
	
	public static final String FIND_CARRER_BY_LAST_DAYS = "SELECT '*' "+ 
			" FROM Carrer WHERE :data < current_date";
	
	public static final String FIND_CARRER_BY_PRICE = "SELECT c "+ 
			" FROM Carrer c WHERE c.preco BETWEEN :precoInicial AND :precoFinal";
	
	@Query(FIND_CARRER_BY_LAST_DAYS)
	List<Carrer> findCarrerByDateInteval(Date data);
	@Query(FIND_CARRER_BY_PRICE)
	List<Carrer> findCarrerByPrice(@Param("precoInicial")BigDecimal precoInicial,@Param("precoFinal") BigDecimal precoFinal);
}

package com.carrer.client.repository;

import com.carrer.client.model.Carrer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface CarrerRepository extends JpaRepository<Carrer, BigDecimal> {

    public static final String FIND_CARRER_BY_LAST_DAYS = "SELECT '*' " +
            " FROM Carrer WHERE :data < current_date";

    @Query(FIND_CARRER_BY_LAST_DAYS)
    List<Carrer> findCarrerByDateInteval(Date data);
}

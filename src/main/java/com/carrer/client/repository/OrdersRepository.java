package com.carrer.client.repository;

import com.carrer.client.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, BigDecimal> {

    String UPDATE_ORDER_STATUS = "update orders " +
            " set status=:status WHERE id=:id ";

    @Modifying
    @Transactional
    @Query(value = UPDATE_ORDER_STATUS, nativeQuery = true)
    void updateOrderStatus(@Param("id") BigDecimal id, @Param("status") String status);

    List<Orders> findByIdcarrier(@Param("id") BigDecimal idCart);

    List<Orders> findByIdUser(@Param("id") BigDecimal idUser);
}

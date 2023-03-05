package com.backend.backend.Repository;

import com.backend.backend.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
        List<Orders> findAll();
}

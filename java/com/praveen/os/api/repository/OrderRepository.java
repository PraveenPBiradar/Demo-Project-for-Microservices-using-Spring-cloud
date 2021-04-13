package com.praveen.os.api.repository;

import com.praveen.os.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}

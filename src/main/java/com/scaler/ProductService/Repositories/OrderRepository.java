package com.scaler.ProductService.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.ProductService.Models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}

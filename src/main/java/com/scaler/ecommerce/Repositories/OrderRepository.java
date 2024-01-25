package com.scaler.ecommerce.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.ecommerce.Models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}

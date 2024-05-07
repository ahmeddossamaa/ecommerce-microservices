package com.order.repositories;

import com.order.models.Order;
import com.order.models.OrderView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderViewRepository extends JpaRepository<OrderView, Integer> {
}

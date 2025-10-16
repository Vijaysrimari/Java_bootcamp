package com.amazon.AmazonDemo.repository;

import com.amazon.AmazonDemo.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<PurchaseOrder,Integer> {
}

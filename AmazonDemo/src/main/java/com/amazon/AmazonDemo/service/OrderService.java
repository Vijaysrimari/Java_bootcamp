package com.amazon.AmazonDemo.service;

import com.amazon.AmazonDemo.model.PurchaseOrder;
import com.amazon.AmazonDemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repo;

    public List<PurchaseOrder> getAllOrders() {
        List<PurchaseOrder> orders = repo.findAll();
        return orders;
    }
    public void createOrder(PurchaseOrder order) {
        LocalDateTime date_time;
        order.setOrderTime(LocalDateTime.now().toLocalDate());
        repo.save(order);
    }

    public String deleteOrder(int id) {
        repo.deleteById(id);
        return "deleted Successfully";
    }
}

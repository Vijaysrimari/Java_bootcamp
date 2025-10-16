package com.amazon.AmazonDemo.controller;

import com.amazon.AmazonDemo.model.PurchaseOrder;
import com.amazon.AmazonDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService service;

    @GetMapping
    public List<PurchaseOrder> getAllOrders(){
        return service.getAllOrders();
    }
    @PostMapping
    public String createOrder(@RequestBody PurchaseOrder order){
        service.createOrder(order);
        return "created Successfully";
    }
//    @PutMapping("{/id}")
//    public String updateOrder(@PathVariable int id, @RequestBody Order order){
//        return service.updateOrder(id,order);
//    }
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id){
        return service.deleteOrder(id);
    }
}
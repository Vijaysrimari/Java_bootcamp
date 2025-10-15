package com.amazon.AmazonDemo.service;

import com.amazon.AmazonDemo.exception.ProductNotFoundException;
import com.amazon.AmazonDemo.model.Product;
import com.amazon.AmazonDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired //DI
    Product product; //obj creation

    @Autowired
    ProductRepository repo;

    public List<Product> getAllProducts() {
        List<Product> products = repo.findAll();
        if(!products.isEmpty()) {
            return products;//select * from product
        }
        else {
            return new ArrayList<Product>();
        }
//        return products;
    }
    public void createProduct(Product product) {
        repo.save(product);
    }

    public String getAllProductByID(int id) throws ProductNotFoundException {
        Optional<Product> products = repo.findById(id);
        if(products.isPresent()) {
            Product obj = products.get();
            return obj.toString();
        }
        else {
            throw new ProductNotFoundException("Requested "+id+"is not present");
        }
    }
    public String updateProduct(int id,Product product) throws ProductNotFoundException {
        Optional<Product> products = repo.findById(id);
        if(products.isPresent()) {
            Product obj = products.get();

            if(product.getName() != null)obj.setName(product.getName());
            if(product.getDescription() != null)obj.setDescription(product.getDescription());
            if(product.getPrice() != 0)obj.setPrice(product.getPrice());
            if(product.getReview()!=null)obj.setReview(product.getReview());
            if(product.getQuantity()!=0)obj.setQuantity(product.getQuantity());

            repo.save(obj);
            return "updated successfully";
        }
        else {
            throw new ProductNotFoundException("Requested "+id+" is not present");

        }
    }

    public String deleteProduct(int id) throws ProductNotFoundException {
        Optional<Product> products = repo.findById(id);
        if(products.isPresent()) {
            Product obj = products.get();
            repo.delete(obj);
//            if(product.getQuantity()!=0)obj.setQuantity(product.getQuantity());
//            if(product.getReview()!=null)obj.setReview(product.getReview());
//            if(product.getPrice() != 0)obj.setPrice(product.getPrice());
//            repo.save(obj);
            return "deleted successfully";
        }
        else  {
            throw new ProductNotFoundException("Requested "+id+" is not present");
        }
    }
}

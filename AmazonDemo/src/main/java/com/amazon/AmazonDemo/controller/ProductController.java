package com.amazon.AmazonDemo.controller;
//import com.amazon.AmazonDemo.exception.ProductNotFoundException;
import com.amazon.AmazonDemo.model.Product;
import com.amazon.AmazonDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

   /*@GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @PostMapping
    public String createProduct(@RequestBody Product product){
        service.createProduct(product);
        return "created successfully";
    }

    @GetMapping("/{id}")
    public String getAllProductByID(@PathVariable int id) throws ProductNotFoundException {

        return service.getAllProductByID(id);
    }
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id,@RequestBody Product product) throws ProductNotFoundException {
        return service.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) throws ProductNotFoundException {
        return service.deleteProduct(id);
    }*/

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        model.addAttribute("product", new Product());
        return "product-list";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        service.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return  "product-form";
    }


}
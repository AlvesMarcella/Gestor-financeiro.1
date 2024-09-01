package com.example.gestorfinanceiro.controllers;

import com.example.gestorfinanceiro.models.Product;
import com.example.gestorfinanceiro.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Rota para a API (JSON)
    @GetMapping("/api")
    @ResponseBody
    public List<Product> getAllProductsApi() {
        return productRepository.findAll();
    }

    // Rota para renderizar a página HTML
    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product-list"; // Use um nome de view diferente, por exemplo, "product-list"
    }

    @PostMapping
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products"; // Redirecione após salvar para evitar loop
    }
}


package com.example.gestorfinanceiro.repositories;

import com.example.gestorfinanceiro.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
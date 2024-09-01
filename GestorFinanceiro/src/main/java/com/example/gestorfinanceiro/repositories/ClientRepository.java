package com.example.gestorfinanceiro.repositories;

import com.example.gestorfinanceiro.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}

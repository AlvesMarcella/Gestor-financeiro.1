package com.example.gestorfinanceiro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";  // Renderiza a página index.html
    }

    @GetMapping("/home")
    public String home() {
        return "home";  // Renderiza a página home.html
    }

    @GetMapping("/login-view")
    public String login() {
        return "login";  // Renderiza a página login.html
    }

    @GetMapping("/register")
    public String register() {
        return "register";  // Renderiza a página register.html
    }
}



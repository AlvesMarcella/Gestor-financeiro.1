package com.example.gestorfinanceiro.controllers;

import com.example.gestorfinanceiro.models.Sale;
import com.example.gestorfinanceiro.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    // Rota para a API (JSON)
    @GetMapping("/api")
    @ResponseBody
    public List<Sale> getAllSalesApi() {
        return saleRepository.findAll();
    }

    // Rota para renderizar a página HTML
    @GetMapping
    public String getAllSales(Model model) {
        List<Sale> sales = saleRepository.findAll();
        model.addAttribute("sales", sales);
        return "sale-list"; // Use um nome de view diferente, por exemplo, "sale-list"
    }

    @PostMapping
    public String addSale(@ModelAttribute Sale sale) {
        saleRepository.save(sale);
        return "redirect:/sales"; // Redirecione após salvar para evitar loop
    }
}

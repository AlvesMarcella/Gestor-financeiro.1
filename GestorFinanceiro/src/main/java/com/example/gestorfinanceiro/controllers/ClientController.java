package com.example.gestorfinanceiro.controllers;

import com.example.gestorfinanceiro.models.Client;
import com.example.gestorfinanceiro.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // Rota para a API (JSON)
    @GetMapping("/api")
    @ResponseBody
    public List<Client> getAllClientsApi() {
        return clientRepository.findAll();
    }

    // Rota para renderizar a página HTML
    @GetMapping
    public String getAllClients(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "client-list"; // Use um nome de view diferente, por exemplo, "client-list"
    }

    @PostMapping
    public String addClient(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/clients"; // Redirecione após salvar para evitar loop
    }
}

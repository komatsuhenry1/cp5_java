package com.example.brinquedos.controller;

import com.example.brinquedos.entity.User; // Importa a entidade User
import com.example.brinquedos.repository.UserRepository; // Importa o repositório de User
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users") // Mapeia a rota de usuários
public class UserController {

    @Autowired
    private UserRepository userRepository; // Adiciona o repositório de usuários

    @GetMapping("/signup") // Mapeia a rota de cadastro
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User()); // Adiciona um novo objeto User ao modelo
        return "signup"; // Retorna a página de signup
    }

    @PostMapping("/signup") // Mapeia a requisição POST para signup
    public String registerUser(@ModelAttribute User user) {
        userRepository.save(user); // Salva o novo usuário no banco de dados
        return "redirect:/login"; // Redireciona para a página de login
    }

    @GetMapping("/login") // Mapeia a rota de login
    public String showLoginForm() {
        return "login"; // Retorna a página de login
    }
}



package com.example.brinquedos.controller;

import com.example.brinquedos.entity.Brinquedo;
import com.example.brinquedos.entity.User;
import com.example.brinquedos.repository.BrinquedoRepository;
import com.example.brinquedos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String listarBrinquedos(Model model) {
        List<Brinquedo> brinquedos = brinquedoRepository.findAll();
        model.addAttribute("brinquedos", brinquedos);
        return "brinquedos/listar";
    }

    @GetMapping("/novo")
    public String novoBrinquedo(Model model) {
        model.addAttribute("brinquedo", new Brinquedo());
        return "brinquedos/form";
    }

    @PostMapping
    public String salvarBrinquedo(@ModelAttribute Brinquedo brinquedo) {
        brinquedoRepository.save(brinquedo);
        return "redirect:/brinquedos";
    }

    @GetMapping("/{id}/editar")
    public String editarBrinquedo(@PathVariable Long id, Model model) {
        Brinquedo brinquedo = brinquedoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brinquedo inválido: " + id));
        model.addAttribute("brinquedo", brinquedo);
        return "brinquedos/form";
    }

    @PostMapping("/{id}")
    public String atualizarBrinquedo(@PathVariable Long id, @ModelAttribute Brinquedo brinquedo) {
        brinquedo.setId(id);
        brinquedoRepository.save(brinquedo);
        return "redirect:/brinquedos";
    }

    @GetMapping("/{id}/deletar")
    public String deletarBrinquedo(@PathVariable Long id) {
        brinquedoRepository.deleteById(id);
        return "redirect:/brinquedos";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/login";
    }
}

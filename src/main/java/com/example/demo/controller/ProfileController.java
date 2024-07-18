package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Usuarios;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
        HttpSession session;

    @GetMapping("/cuenta")
    public String cuenta(HttpSession session, Model model) {
        // Aquí recuperamos el usuario de la sesión
        Usuarios usuario = (Usuarios) session.getAttribute("usuarios");

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        } else {
            // Manejar el caso donde no hay usuario en la sesión
            model.addAttribute("usuario", new Usuarios());
        }

        return "cuenta"; // nombre de la plantilla Thymeleaf que muestra el perfil de usuario
    }
}
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Usuarios;
import com.example.demo.service.DashboardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private HttpSession session;

    @GetMapping("/index")
    public String index(Model model) {

        // Obtén el usuario de la sesión
        Usuarios usuario = (Usuarios) session.getAttribute("usuarios");

        // Añado los datos al modelo
        model.addAttribute("totalProfessors", dashboardService.getTotalProfessors());
        model.addAttribute("totalAsesorias", dashboardService.getTotalAsesorias());
        model.addAttribute("totalStudents", dashboardService.getTotalStudents());
        model.addAttribute("totalSessions", dashboardService.getTotalSessions());
        model.addAttribute("usuarioNombre", usuario != null ? usuario.getNombres() : "Invitado");

        return "index";
    }
}

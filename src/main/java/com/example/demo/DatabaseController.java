package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatabaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/validateConnection")
    public String validateConnection(Model model) {
        boolean isConnected = false;
        try {
            // Intenta ejecutar una consulta simple para verificar la conexión
            jdbcTemplate.execute("SELECT 1");
            isConnected = true;
        } catch (Exception ex) {
            // Si hay una excepción, la conexión ha fallado
            ex.printStackTrace();
        }
        // Agrega un atributo al modelo para indicar si la conexión fue exitosa o no
        model.addAttribute("isConnected", isConnected);
        return "validation"; // Retorna el nombre de la vista (validation.html)
    }
}
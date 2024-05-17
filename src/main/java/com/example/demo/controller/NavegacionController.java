package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;

@Controller
public class NavegacionController {
    @GetMapping("/{pagina}")
    public String mostrarPagina(@PathVariable String pagina) {
        return pagina; 
    }
}

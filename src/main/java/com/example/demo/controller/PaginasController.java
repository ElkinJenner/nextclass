package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
/*
Mapeo de todos los archivos estaticos como HTML de la aplicación, esto gracias a la libreria
thymeleaf, lo que nos proporciona controlar su direccion URL
Controla páginas HTML que incluso no esten mapeaados ni controlados por
ningun controlador
*/
@Controller
public class PaginasController {
    @GetMapping("/{pagina}")
    public String mostrarPagina(@PathVariable String pagina) {
        return pagina; 
    }
}
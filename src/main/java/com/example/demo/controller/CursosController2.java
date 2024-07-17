package com.example.demo.controller;

import com.example.demo.dao.CursosDaoImpl;
import com.example.demo.model.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CursosController2 {

    @Autowired
    private CursosDaoImpl cursosDao;

    @GetMapping("/asesorias")
    public String listarCursos(Model model) {
        List<Cursos> listaCursos = cursosDao.findAll(); // Obtiene todos los cursos

        model.addAttribute("cursos", listaCursos); // Agrega la lista de cursos al modelo
        model.addAttribute("activePage", "asesorias");

        return "asesorias";
    }
}
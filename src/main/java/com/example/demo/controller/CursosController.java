package com.example.demo.controller;

import com.example.demo.dao.CategoriaCursosDaoImpl;
import com.example.demo.dao.CursosDaoImpl;
import com.example.demo.model.CategoriaCursos;
import com.example.demo.model.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CursosController {

    @Autowired
    private CursosDaoImpl cursosDao;

    @Autowired
    private CategoriaCursosDaoImpl categoriaCursosDao;

    @GetMapping("/cursos")
    public String listarCursosYcategorias(Model model) {
        List<Cursos> listaCursos = cursosDao.findAllWithCategoriaNombre();
        List<CategoriaCursos> listaCategorias = categoriaCursosDao.findAll();
        model.addAttribute("cursos", listaCursos);
        model.addAttribute("categorias", listaCategorias);
        return "cursos";
    }
}
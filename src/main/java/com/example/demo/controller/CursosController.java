package com.example.demo.controller;

import com.example.demo.dao.CategoriaCursosDaoImpl;
import com.example.demo.dao.CursosDaoImpl;
import com.example.demo.model.CategoriaCursos;
import com.example.demo.model.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CursosController {

    @Autowired
    private CursosDaoImpl cursosDao;

    @Autowired
    private CategoriaCursosDaoImpl categoriaCursosDao;

    private static final int PAGE_SIZE = 10;

    @GetMapping("/cursos")
    public String listarCursosYcategorias(
            @RequestParam(value = "page", defaultValue = "1") int page,
            Model model) {
        int offset = (page - 1) * PAGE_SIZE;
        List<Cursos> listaCursos = cursosDao.findAllWithCategoriaNombre(offset, PAGE_SIZE);
        List<CategoriaCursos> listaCategorias = categoriaCursosDao.findAll();

        int totalCursos = cursosDao.count();
        int totalPages = (int) Math.ceil((double) totalCursos / PAGE_SIZE);

        model.addAttribute("cursos", listaCursos);
        model.addAttribute("categorias", listaCategorias);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "cursos";
    }
}
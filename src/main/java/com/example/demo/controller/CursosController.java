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

    @Autowired // Inyecta automáticamente la instancia de CursosDaoImpl
    private CursosDaoImpl cursosDao;

    @Autowired // Inyecta automáticamente la instancia de CategoriaCursosDaoImpl
    private CategoriaCursosDaoImpl categoriaCursosDao;

    private static final int PAGE_SIZE = 10; // Tamaño de página para la paginación

    @GetMapping("/cursos")
    public String listarCursosYcategorias(
            @RequestParam(value = "page", defaultValue = "1") int page, // Parámetro de página
            @RequestParam(value = "categoria", required = false) String categoria, // Parámetro de categoría
            Model model) {

        int offset = (page - 1) * PAGE_SIZE; // Calcula el offset para la paginación
        List<Cursos> listaCursos; // Lista de cursos a mostrar
        int totalCursos; // Número total de cursos

        if (categoria == null || categoria.equals("all")) { // Si no se especifica categoría o es "all"
            listaCursos = cursosDao.findAllWithCategoriaNombre(offset, PAGE_SIZE); // Obtiene todos los cursos
            totalCursos = cursosDao.count(); // Cuenta todos los cursos
        } else {
            // Obtiene cursos por categoría
            listaCursos = cursosDao.findByCategoriaWithPagination(categoria, offset, PAGE_SIZE);
            totalCursos = cursosDao.countByCategoria(categoria); // Cuenta cursos por categoría
        }

        List<CategoriaCursos> listaCategorias = categoriaCursosDao.findAll(); // Obtiene todas las categorías
        int totalPages = (int) Math.ceil((double) totalCursos / PAGE_SIZE); // Calcula el número total de páginas

        model.addAttribute("cursos", listaCursos); // Agrega la lista de cursos al modelo
        model.addAttribute("categorias", listaCategorias); // Agrega la lista de categorías al modelo
        model.addAttribute("currentPage", page); // Agrega la página actual al modelo
        model.addAttribute("totalPages", totalPages); // Agrega el número total de páginas al modelo
        model.addAttribute("selectedCategoria", categoria != null ? categoria : "all"); // Agrega la categoría
                                                                                        // seleccionada al modelo
        model.addAttribute("showPagination", totalCursos > PAGE_SIZE); // Agrega si se muestra la paginación al modelo

        return "cursos"; // Devuelve la vista "cursos"
    }
}
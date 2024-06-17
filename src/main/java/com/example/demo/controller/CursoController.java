package com.example.demo.controller;

import com.example.demo.dao.CursoDaoImpl;
import com.example.demo.model.Asesorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CursoController {

    @Autowired
    private CursoDaoImpl asesoriasDao;

    // Mapeo de las asesorias de un curso respectivo
    @RequestMapping("/curso")
    public String getCurso(@RequestParam("curso") String curso, Model model) {
        List<Asesorias> asesorias = asesoriasDao.findByCurso(curso);
        model.addAttribute("asesorias", asesorias);
        model.addAttribute("curso", curso);
        return "curso";
    }
}
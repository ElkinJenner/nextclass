package com.example.demo.controller;

import com.example.demo.dao.CursoDaoImpl;
import com.example.demo.dao.SesionesDaoImpl;
import com.example.demo.model.Asesorias;
import com.example.demo.model.Sesiones;
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

    @Autowired
    private SesionesDaoImpl sesionesDao;

    // Mapeo de las asesorias de un curso respectivo
    @RequestMapping("/curso") // Dirección
    public String getCurso(@RequestParam("curso") String curso, Model model) {
        List<Asesorias> asesorias = asesoriasDao.findByCurso(curso);
        model.addAttribute("asesorias", asesorias);
        model.addAttribute("curso", curso);
        // Interfaz HTML. En este caso curso.html
        return "curso";
    }
    //Mapeo para sesion
    @RequestMapping("/sesion")
    public String getAsesoria(@RequestParam("sesion") Long sesionId, Model model) {
        Asesorias asesoria = asesoriasDao.findById(sesionId);
        List<Sesiones> sesiones = sesionesDao.findByAsesoriaId(sesionId.intValue()); // Obtener sesiones
        asesoria.setSesiones(sesiones); // Añadir sesiones a la asesoría
        model.addAttribute("asesoria", asesoria);
        model.addAttribute("sesiones", sesiones); // Pasar sesiones al modelo
        return "sesion"; // Mapea a sesion.html
    }
}
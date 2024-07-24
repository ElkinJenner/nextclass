package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.InscripcionesDaoImpl;
import com.example.demo.model.Inscripciones;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class InscripcionesController {

    @Autowired
    private InscripcionesDaoImpl inscripcionesDao;

    @GetMapping("/inscripciones/asesorias")
    public String getAsesorias(Model model) {
        List<Inscripciones> inscripcionesList = inscripcionesDao.findAll();
        model.addAttribute("inscripciones", inscripcionesList);
        return "asesorias";
    }

    @PostMapping("/inscribirse_asesoria")
    public String inscribirse(
            @RequestParam("idEstudiante") int idEstudiante,
            @RequestParam("idSesion") int idSesion,
            @RequestParam("idAsesoria") int idAsesoria,
            RedirectAttributes redirectAttributes) {
        Date fechaInscripcion = Date.valueOf(LocalDate.now());

        Inscripciones nuevaInscripcion = new Inscripciones();
        nuevaInscripcion.setIdEstudiante(idEstudiante);
        nuevaInscripcion.setIdSesion(idSesion);
        nuevaInscripcion.setIdAsesoria(idAsesoria);
        nuevaInscripcion.setFechaInscripcion(fechaInscripcion);

        inscripcionesDao.save(nuevaInscripcion);

        redirectAttributes.addFlashAttribute("message", "Inscripción realizada con éxito");
        return "redirect:/asesorias";
    }
}
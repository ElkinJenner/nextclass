package com.example.demo.controller;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.SesionesDaoImpl;
import com.example.demo.model.Sesiones;

@Controller
public class SesionController {

    @Autowired
    private SesionesDaoImpl sesionesDao;

    @GetMapping("/sesiones")
    public String listarSesiones(Model model, @RequestParam("idAsesoria") int idAsesoria) {
        List<Sesiones> listaSesiones = sesionesDao.findByAsesoriaId(idAsesoria);
        model.addAttribute("sesiones", listaSesiones);
        return "sesion";
    }

    @PostMapping("/registrar_sesion")
    public String registrarSesion(@RequestParam("idAsesoria") int idAsesoria,
            @RequestParam("idProfesor") int idProfesor,
            @RequestParam("dia") String dia,
            @RequestParam("horaInicial") String horaInicial,
            @RequestParam("horaFinal") String horaFinal,
            RedirectAttributes redirectAttributes) {
        Sesiones nuevaSesion = new Sesiones();
        nuevaSesion.setIdAsesoria(idAsesoria);
        nuevaSesion.setIdProfesor(idProfesor);
        nuevaSesion.setDia(dia);
        nuevaSesion.setHoraInicial(Time.valueOf(horaInicial + ":00"));
        nuevaSesion.setHoraFinal(Time.valueOf(horaFinal + ":00"));

        sesionesDao.save(nuevaSesion);

        return "redirect:/asesorias";
    }
}
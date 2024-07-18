package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AsesoriasDaoImpl;
import com.example.demo.model.Asesorias;
import com.example.demo.model.Usuarios;

import jakarta.servlet.http.HttpSession;

@Controller
public class AsesoriaController {

    @Autowired
    private AsesoriasDaoImpl asesoriaDao;

    @Autowired
    private HttpSession session;

    @PostMapping("/registrar_asesoria")
    public String registrarAsesoria(@RequestParam("tema") String tema,
            @RequestParam("capacidad") int capacidad,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("duracion") String duracion,
            @RequestParam("precio") BigDecimal precio,
            @RequestParam("idCurso") Long idCurso,
            @RequestParam("fechainicial") String fechaInicial,
            @RequestParam("fechafinal") String fechaFinal,
            RedirectAttributes redirectAttributes) {

        Long idProfesor;
        Usuarios usuario = (Usuarios) session.getAttribute("usuarios");
        if (usuario != null && usuario.getTipoUsuario().equals("Profesor")) {
            idProfesor = usuario.getIdUsuario();
        } else {
            return "redirect:/login";
        }

        Asesorias nuevaAsesoria = new Asesorias();
        nuevaAsesoria.setIdProfesor(idProfesor);
        nuevaAsesoria.setTema(tema);
        nuevaAsesoria.setCapacidad(capacidad);
        nuevaAsesoria.setDescripcion(descripcion);

        LocalTime duracionTime = LocalTime.parse(duracion);
        nuevaAsesoria.setDuracion(duracionTime);
        nuevaAsesoria.setPrecio(precio);
        nuevaAsesoria.setIdCurso(idCurso);

        LocalDate fechaInicio = LocalDate.parse(fechaInicial);
        LocalDate fechaFin = LocalDate.parse(fechaFinal);
        nuevaAsesoria.setFechaInicial(fechaInicio);
        nuevaAsesoria.setFechaFinal(fechaFin);

        asesoriaDao.save(nuevaAsesoria);

        return "redirect:/index";
    }
}
package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AsesoriasDaoImpl;
import com.example.demo.dao.CursosDaoImpl;
import com.example.demo.model.Asesorias;
import com.example.demo.model.Cursos;

@Controller
public class AsesoriaController {

    @Autowired
    private AsesoriasDaoImpl asesoriaDao;

    @Autowired
    private CursosDaoImpl cursosDao;

    @PostMapping("/registrar_asesoria")
    public String registrarSesion(
            @RequestParam("idCurso") int idCurso,
            @RequestParam("idProfesor") int idProfesor,
            @RequestParam("tema") String tema,
            @RequestParam("capacidad") int capacidad,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("duracion") String duracion, // nota que duracion es un String que será convertido a LocalTime
            @RequestParam("precio") BigDecimal precio,
            @RequestParam("fechainicial") LocalDate fechaInicial,
            @RequestParam("fechafinal") LocalDate fechaFinal,
            RedirectAttributes redirectAttributes) {

        Asesorias asesoria = new Asesorias();
        asesoria.setIdCurso((long) idCurso);
        asesoria.setIdProfesor((long) idProfesor);
        asesoria.setTema(tema);
        asesoria.setCapacidad(capacidad);
        asesoria.setDescripcion(descripcion);
        asesoria.setDuracion(LocalTime.parse(duracion)); // convierte el String a LocalTime
        asesoria.setPrecio(precio);
        asesoria.setFechaInicial(fechaInicial);
        asesoria.setFechaFinal(fechaFinal);

        try {
            asesoriaDao.save(asesoria);
            redirectAttributes.addFlashAttribute("mensaje", "Asesoria registrada exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al registrar la asesoria: " + e.getMessage());
        }

        return "redirect:/asesorias";
    }

    @GetMapping("/asesorias")
    public String listarCursos(Model model) {
        List<Cursos> listaCursos = cursosDao.findAll(); // Obtener todos los cursos
        List<Asesorias> listaAsesorias = asesoriaDao.findAll(); // Obtener todas las asesorías

        model.addAttribute("cursos", listaCursos); // Agregar la lista de cursos al modelo
        model.addAttribute("asesorias", listaAsesorias); // Agregar la lista de asesorías al modelo
        model.addAttribute("activePage", "asesorias");

        return "asesorias";
    }
}
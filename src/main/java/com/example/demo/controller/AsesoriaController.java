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
import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.dao.SesionesDaoImpl;
import com.example.demo.model.Asesorias;
import com.example.demo.model.Cursos;
import com.example.demo.model.Usuarios;
import com.example.demo.model.Sesiones;

import jakarta.servlet.http.HttpSession;

@Controller
public class AsesoriaController {

    @Autowired
    private AsesoriasDaoImpl asesoriaDao;

    @Autowired
    private CursosDaoImpl cursosDao;

    @Autowired
    private UsuariosDaoImpl usuariosDao;

    @Autowired
    private SesionesDaoImpl sesionesDao;

    @PostMapping("/registrar_asesoria")
    public String registrarSesion(
            @RequestParam("idCurso") int idCurso,
            @RequestParam("idProfesor") int idProfesor,
            @RequestParam("idUsuario") int idUsuario,
            @RequestParam("tema") String tema,
            @RequestParam("capacidad") int capacidad,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("duracion") String duracion,
            @RequestParam("precio") BigDecimal precio,
            @RequestParam("fechainicial") LocalDate fechaInicial,
            @RequestParam("fechafinal") LocalDate fechaFinal,
            RedirectAttributes redirectAttributes) {

        Asesorias asesoria = new Asesorias();
        asesoria.setIdCurso((long) idCurso);
        asesoria.setIdProfesor((long) idProfesor);
        asesoria.setIdUsuario((long) idUsuario);
        asesoria.setTema(tema);
        asesoria.setCapacidad(capacidad);
        asesoria.setDescripcion(descripcion);
        asesoria.setDuracion(LocalTime.parse(duracion));
        asesoria.setPrecio(precio);
        asesoria.setFechaInicial(fechaInicial);
        asesoria.setFechaFinal(fechaFinal);

        try {
            asesoriaDao.save(asesoria);
            redirectAttributes.addFlashAttribute("mensaje", "Asesoría registrada exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al registrar la asesoría: " + e.getMessage());
        }

        return "redirect:/asesorias";
    }

    @GetMapping("/asesorias")
    public String listarCursos(HttpSession session, Model model) {
        // Obtener todos los cursos y asesorías
        List<Cursos> listaCursos = cursosDao.findAll();
        List<Asesorias> listaAsesorias = asesoriaDao.findAll();

        // Capturar idUsuario desde la sesión
        Long idUsuario = (Long) session.getAttribute("idUsuario");

        // Buscar idProfesor usando el idUsuario
        Long idProfesor = null;
        if (idUsuario != null) {
            Usuarios usuario = usuariosDao.findById(idUsuario);
            if (usuario != null && "Profesor".equals(usuario.getTipoUsuario())) {
                idProfesor = usuariosDao.findIdProfesorByIdUsuario(idUsuario);
            }
        }

        // Agregar las sesiones a cada asesoría
        for (Asesorias asesoria : listaAsesorias) {
            List<Sesiones> sesiones = sesionesDao.findByAsesoriaId(asesoria.getIdAsesoria().intValue());
            asesoria.setSesiones(sesiones);
        }

        // Agregar los datos al modelo
        model.addAttribute("cursos", listaCursos);
        model.addAttribute("asesorias", listaAsesorias);
        model.addAttribute("activePage", "asesorias");
        model.addAttribute("idProfesor", idProfesor); // Agregar idProfesor al modelo

        return "asesorias";
    }
}
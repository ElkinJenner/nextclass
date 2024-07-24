package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
import com.example.demo.dao.ProfesoresDaoImpl;

import com.example.demo.model.Asesorias;
import com.example.demo.model.Cursos;
import com.example.demo.model.Usuarios;
import com.example.demo.model.Sesiones;
import com.example.demo.model.Profesores;

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

    @Autowired
    private ProfesoresDaoImpl profesoresDao;

    private static final int PAGE_SIZE = 10; // Tamaño de registros por página para la paginación

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
    public String listarCursos(
            @RequestParam(value = "page", defaultValue = "1") int page, // Parámetro de página
            HttpSession session,
            Model model) {
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

        final Long finalIdProfesor = idProfesor; // Convertir a una variable final
        // Filtrar asesorías por idProfesor
        if (finalIdProfesor != null) {
            listaAsesorias = listaAsesorias.stream()
                    .filter(asesoria -> asesoria.getIdProfesor().equals(finalIdProfesor))
                    .collect(Collectors.toList());
        }

        int offset = (page - 1) * PAGE_SIZE; // Calcula el offset para la paginación
        List<Profesores> listaProfesores = profesoresDao.findAllWithPagination(offset, PAGE_SIZE);
        // Obtiene la lista de profesores con paginación
        int totalProfesores = profesoresDao.count(); // Cuenta el número total de profesores

        int totalPages = (int) Math.ceil((double) totalProfesores / PAGE_SIZE); // Calcula el número total de páginas

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
        model.addAttribute("profesores", listaProfesores);
        model.addAttribute("currentPage", page); // Agrega la página actual al modelo
        model.addAttribute("totalPages", totalPages); // Agrega el número total de páginas al modelo
        model.addAttribute("showPagination", totalProfesores > PAGE_SIZE);

        return "asesorias";
    }
}
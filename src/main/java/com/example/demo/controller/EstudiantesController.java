package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.EstudiantesDaoImpl;
import com.example.demo.model.Estudiantes;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudiantesController {

    @Autowired
    private EstudiantesDaoImpl estudiantesDao;

    // Método para listar todos los estudiantes y mostrar en asesorias.html
    @GetMapping("/list")
    public String listarEstudiantes(Model model) {
        List<Estudiantes> estudiantesList = estudiantesDao.findAll();
        model.addAttribute("estudiantes", estudiantesList);
        return "asesorias";
    }

    // Método para mostrar la página de registro
    @GetMapping("/registro_completar")
    public String mostrarFormularioRegistro() {
        return "registro_completar";
    }

    // Método para registrar un nuevo estudiante
    @PostMapping("/registrar_estudiante")
    public String registrarEstudiante(@RequestParam("idUsuario") Long idUsuario,
            @RequestParam("nivelAcademico") String nivelAcademico) {
        Estudiantes nuevoEstudiante = new Estudiantes();
        nuevoEstudiante.setIdUsuario(idUsuario);
        nuevoEstudiante.setNivelAcademico(nivelAcademico);
        estudiantesDao.save(nuevoEstudiante);
        return "redirect:/index.html";
    }
}
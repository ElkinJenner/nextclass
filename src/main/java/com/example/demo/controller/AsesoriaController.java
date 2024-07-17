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
    private AsesoriasDaoImpl asesoriaDao; // DAO para acceder a las asesorías

    @Autowired
    private HttpSession session; // Sesión HTTP para almacenar datos de sesión



    // Método para procesar el formulario de registro de asesoría
    @PostMapping("/registrar_asesoria")
    public String registrarAsesoria(@RequestParam("idProfesor") Long idProfesor,
            @RequestParam("tema") String tema,
            @RequestParam("capacidad") int capacidad,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("duracion") String duracion,
            @RequestParam("precio") BigDecimal precio,
            @RequestParam("idCurso") Long idCurso,
            @RequestParam("fechainicial") String fechaInicial,
            @RequestParam("fechafinal") String fechaFinal,
            RedirectAttributes redirectAttributes) {

        // Verificar la sesión del usuario
        Usuarios usuario = (Usuarios) session.getAttribute("usuarios");
        if (usuario != null && usuario.getTipoUsuario().equals("Profesor")) {
            // El usuario es un profesor, por lo tanto, asignar el ID del profesor a la
            // asesoría
            idProfesor = usuario.getIdUsuario(); // devuelve el ID del profesor
        } else {
            // redirigir a login si el usuario no es profesor.
            return "redirect:/login";
        }

        // Crear una nueva asesoría
        Asesorias nuevaAsesoria = new Asesorias();
        nuevaAsesoria.setIdProfesor(idProfesor);
        nuevaAsesoria.setTema(tema);
        nuevaAsesoria.setCapacidad(capacidad);
        nuevaAsesoria.setDescripcion(descripcion);

        // Convertir duracion de String a LocalTime
        LocalTime duracionTime = LocalTime.parse(duracion);
        nuevaAsesoria.setDuracion(duracionTime);

        nuevaAsesoria.setPrecio(precio);
        nuevaAsesoria.setIdCurso(idCurso);

        // Convertir fechas de String a LocalDate
        LocalDate fechaInicio = LocalDate.parse(fechaInicial);
        LocalDate fechaFin = LocalDate.parse(fechaFinal);
        nuevaAsesoria.setFechaInicial(fechaInicio);
        nuevaAsesoria.setFechaFinal(fechaFin);

        // Guardar la nueva asesoría en la base de datos
        asesoriaDao.save(nuevaAsesoria);

        // Redirigir a pagina de index.

        return "redirect:/index";
    }
}

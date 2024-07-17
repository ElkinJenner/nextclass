package com.example.demo.controller;
// Implementamos librerias
import com.example.demo.dao.ProfesoresDaoImpl;
import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.model.Profesores;
import com.example.demo.model.Usuarios;
import com.example.demo.components.PaisesComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProfesoresController {
    // Inyectamos los DaoImplentes de cada una de las clases
    @Autowired
    private ProfesoresDaoImpl profesoresDao;

    @Autowired
    private UsuariosDaoImpl usuariosDao;

    @Autowired
    private PaisesComponent paisesComponent; // Inyectamos PaisesComponent

    private static final int PAGE_SIZE = 10; // Tamaño de registros por página para la paginación

    @GetMapping("/profesores")
    public String listarProfesores(
            @RequestParam(value = "page", defaultValue = "1") int page, // Parámetro de página
            Model model) {

        int offset = (page - 1) * PAGE_SIZE; // Calcula el offset para la paginación
        List<Profesores> listaProfesores = profesoresDao.findAllWithPagination(offset, PAGE_SIZE); 
        // Obtiene la lista  de profesores con paginación
        int totalProfesores = profesoresDao.count(); // Cuenta el número total de profesores
        List<Usuarios> listaUsuarios = usuariosDao.findAll(); // Obtiene la lista de todos los usuarios
        Map<Long, String> mapUsuarioNombres = new HashMap<>(); // Mapa para almacenar los nombres completos de los usuarios
        Map<Long, String> mapUsuarioProfesion = new HashMap<>(); // Mapa para almacenar las profesiones de los usuarios
        Map<Long, String> mapPaisImagen = new HashMap<>(); // Mapa para almacenar las imágenes de las banderas

        // Mapear usuarios a sus nombres completos y profesiones
        for (Usuarios usuario : listaUsuarios) {
            if (usuario.getTipoUsuario().equals("Profesor")) {
                mapUsuarioNombres.put(usuario.getIdUsuario(), usuario.getNombres() + " " + usuario.getApellidos());
                for (Profesores profesor : listaProfesores) {
                    if (profesor.getIdUsuario() == usuario.getIdUsuario()) {
                        mapUsuarioProfesion.put(usuario.getIdUsuario(), profesor.getProfesion());
                        // Mapear la imagen del país usando el idPais del usuario
                        String pais = profesor.getNombrePais();
                        mapPaisImagen.put(usuario.getIdUsuario(), paisesComponent.getBanderaImages().get(pais));
                    }
                }
            }
        }

        int totalPages = (int) Math.ceil((double) totalProfesores / PAGE_SIZE); // Calcula el número total de páginas

        model.addAttribute("profesores", listaProfesores); // Agrega la lista de profesores al modelo
        model.addAttribute("mapUsuarioNombres", mapUsuarioNombres); // Agrega el mapa de nombres de usuarios al modelo
        model.addAttribute("mapUsuarioProfesion", mapUsuarioProfesion); // Agrega el mapa de profesiones de usuarios 
        model.addAttribute("mapPaisImagen", mapPaisImagen); // Agrega el mapa de imágenes de países al modelo
        model.addAttribute("currentPage", page); // Agrega la página actual al modelo
        model.addAttribute("totalPages", totalPages); // Agrega el número total de páginas al modelo
        // Agrega si se muestra la paginación máxima y mayor a los 10 registros
        model.addAttribute("showPagination", totalProfesores > PAGE_SIZE); 
        //Activación  al menu de navegación
        model.addAttribute("activePage", "profesores");
        return "profesores"; // Devuelve la vista "profesores"
    }
}
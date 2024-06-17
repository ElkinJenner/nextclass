package com.example.demo.controller;

import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//Componentes para mapear
import com.example.demo.components.UsuarioComponent;

import java.util.List;

@Controller // Marca esta clase como un controlador de Spring MVC
public class UsuariosController {
    // Inyección de dependencia del DAO para acceder a los usuarios
    @Autowired
    private UsuariosDaoImpl usuariosDao;
    // Inyección de dependencia del componente UsuarioComponent
    @Autowired
    private UsuarioComponent usuarioComponent;

    // Método para obtener por el método GET toda la lista de Usuarios
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        // Obtener todos los usuarios desde la base de datos usando el DAO
        List<Usuarios> listaUsuarios = usuariosDao.findAll();
        // Agregar la lista de usuarios al modelo para ser utilizada por la vista
        model.addAttribute("usuarios", listaUsuarios);
        // Agregar imágenes relacionadas con tipos de usuarios al modelo
        model.addAttribute("tiposUsuarioImages", usuarioComponent.getTiposUsuarioImages());
        // Devolver el nombre lógico de la vista que se debe renderizar (en este caso, "lista")
        return "lista";
    }
}
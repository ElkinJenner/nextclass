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

@Controller
public class UsuariosController {

    @Autowired
    private UsuariosDaoImpl usuariosDao;

    @Autowired
    private UsuarioComponent usuarioComponent;

    // Método para obtener por el método GET toda la lista de Usuarios
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuarios> listaUsuarios = usuariosDao.findAll();
        model.addAttribute("usuarios", listaUsuarios);
        model.addAttribute("tiposUsuarioImages", usuarioComponent.getTiposUsuarioImages());
        return "lista";
    }
}
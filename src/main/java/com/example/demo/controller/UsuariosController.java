package com.example.demo.controller;

import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuariosController {

    @Autowired
    private UsuariosDaoImpl usuariosDao;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuarios> listaUsuarios = usuariosDao.findAll();
        model.addAttribute("usuarios", listaUsuarios);
        return "lista";
    }
}
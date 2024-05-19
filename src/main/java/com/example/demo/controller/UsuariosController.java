package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> findAll() {
        return usuariosService.findAll();
    }

    @GetMapping("/{id}")
    public Usuarios findById(@PathVariable Long id) {
        return usuariosService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Usuarios usuario) {
        usuariosService.save(usuario);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Usuarios usuario) {
        usuario.setIdUsuario(id);
        usuariosService.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        usuariosService.deleteById(id);
    }

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        List<Usuarios> usuarios = usuariosService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "lista";
    }
}
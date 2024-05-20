package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        List<Usuarios> usuarios = usuariosService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "lista";
    }

    @GetMapping("/usuarios")
    @ResponseBody
    public List<Usuarios> findAll() {
        return usuariosService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    @ResponseBody
    public Usuarios findById(@PathVariable Long id) {
        return usuariosService.findById(id);
    }

    @PostMapping("/usuarios")
    @ResponseBody
    public void save(@RequestBody Usuarios usuario) {
        usuariosService.save(usuario);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseBody
    public void update(@PathVariable Long id, @RequestBody Usuarios usuario) {
        usuario.setIdUsuario(id);
        usuariosService.update(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        usuariosService.deleteById(id);
    }
}
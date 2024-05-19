package com.example.demo.controller;

import com.example.demo.dao.UsuariosDao;
import com.example.demo.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosDao usuariosDao;

    @GetMapping
    public List<Usuarios> listar() {
        return usuariosDao.findAll();
    }

    @GetMapping("/{id}")
    public Usuarios leer(@PathVariable Long id) {
        return usuariosDao.findById(id);
    }

    @PostMapping
    public void registrar(@RequestBody Usuarios usuario) {
        usuariosDao.save(usuario);
    }

    @PutMapping
    public void actualizar(@RequestBody Usuarios usuario) {
        usuariosDao.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuariosDao.deleteById(id);
    }
}
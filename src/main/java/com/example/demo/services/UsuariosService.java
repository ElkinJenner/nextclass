package com.example.demo.services;

import com.example.demo.model.Usuarios;
import java.util.List;

public interface UsuariosService {
    List<Usuarios> findAll();

    Usuarios findById(Long id);

    void save(Usuarios usuario);

    void update(Usuarios usuario);

    void deleteById(Long id);
}
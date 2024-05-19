package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@Repository
public class UsuariosDaoImpl implements UsuariosDao {

    private List<Usuarios> usuariosList = new ArrayList<>();

    @Override
    public List<Usuarios> findAll() {
        return new ArrayList<>(usuariosList);
    }

    @Override
    public Usuarios findById(Long id) {
        return usuariosList.stream()
                .filter(u -> u.getIdUsuario().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Usuarios usuario) {
        usuariosList.add(usuario);
    }

    @Override
    public void update(Usuarios usuario) {
        deleteById(usuario.getIdUsuario());
        save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuariosList.removeIf(u -> u.getIdUsuario().equals(id));
    }
}
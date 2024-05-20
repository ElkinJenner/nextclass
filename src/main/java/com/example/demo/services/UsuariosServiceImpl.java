package com.example.demo.services;

import com.example.demo.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosServiceImpl usuariosDao;

    @Override
    public List<Usuarios> findAll() {
        return usuariosDao.findAll();
    }

    @Override
    public Usuarios findById(Long id) {
        return usuariosDao.findById(id);
    }

    @Override
    public void save(Usuarios usuario) {
        usuariosDao.save(usuario);
    }

    @Override
    public void update(Usuarios usuario) {
        usuariosDao.update(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuariosDao.deleteById(id);
    }
}

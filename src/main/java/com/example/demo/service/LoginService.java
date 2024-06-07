package com.example.demo.service;

import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuariosDaoImpl usuariosDao;

    public Usuarios validateUser(String email, String password) {
        return usuariosDao.findByEmailAndPassword(email, password);
    }
}
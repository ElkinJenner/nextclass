package com.example.demo.service;

import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.model.Usuarios;
import com.example.demo.utils.Validation;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuariosDaoImpl usuariosDao;
    @Autowired
    HttpSession session;

    public Usuarios validateUser(String email, String password)
            throws NoSuchAlgorithmException, IOException, CloneNotSupportedException {
        String hashedPassword = Validation.md5(password);
        Usuarios usuarios = usuariosDao.findByEmailAndPassword(email, hashedPassword);
        if (usuarios != null) {
            session.setAttribute("usuarios", usuarios);
        }
        return usuarios;
    }
}
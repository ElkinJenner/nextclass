package com.example.demo.service;
// Importaciones de clases y componentes necesarios
import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.model.Usuarios;
import com.example.demo.utils.Validation;

import jakarta.servlet.http.HttpSession;
// Importaciones para manejar excepciones y seguridad
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
// Importación de anotación de Spring Framework para servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Definición del servicio como un componente de Spring
@Service
public class LoginService {
    // Inyección de dependencia del DAO de Usuarios
    @Autowired
    private UsuariosDaoImpl usuariosDao;
    // Inyección de dependencia de la sesión HTTP
    @Autowired
    HttpSession session;
    // Método para validar y autenticar un usuario por correo electrónico y
    // contraseña
    public Usuarios validateUser(String email, String password)
            throws NoSuchAlgorithmException, IOException, CloneNotSupportedException {
        // Hashing de la contraseña utilizando MD5
        String hashedPassword = Validation.md5(password);
        // Buscar al usuario por correo electrónico y contraseña hasheada en la base de datos
        Usuarios usuarios = usuariosDao.findByEmailAndPassword(email, hashedPassword);
        // Si se encuentra al usuario, se guarda en la sesión HTTP
        if (usuarios != null) {
            session.setAttribute("usuarios", usuarios);
        }
        // Devuelve el objeto Usuarios encontrado (o null si no se encontró)
        return usuarios;
    }
}
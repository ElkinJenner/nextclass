package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Método que maneja las solicitudes de inicio de sesión.
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email, @RequestParam("contrasena") String password)
            throws NoSuchAlgorithmException, IOException, CloneNotSupportedException {
        Usuarios user = loginService.validateUser(email, password);
        if (user != null) {
            // Si los credenciales son correctos, se accede a la plataforma de la aplicación
            return new ModelAndView("redirect:/index");
        } else {
            // En caso contrario, no te permite el acceso y te quedas en la página
            // login.html
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("error", "Correo eléctronico o contraseña inválido");
            return mav;
        }
    }
   
    // Nuevo método para manejar el cierre de sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalida la sesión actual
        return "redirect:/login"; // Redirige a la página de inicio de sesión
    }
}
package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email, @RequestParam("contrasena") String password) {
        Usuarios user = loginService.validateUser(email, password);
        if (user != null) {
            return new ModelAndView("redirect:/index");
        } else {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("error", "Correo eléctronico o contraseña inválido");
            return mav;
        }
    }
}
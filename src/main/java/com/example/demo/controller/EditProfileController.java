package com.example.demo.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.model.Usuarios;
import com.example.demo.utils.Validation;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/perfil")
public class EditProfileController {

    @Autowired
    private UsuariosDaoImpl usuariosDaoImpl;

    @Autowired
    private HttpSession session;

    @GetMapping("/editar")
    public String mostrarFormularioEdicion(Model model) {
        Usuarios usuario = (Usuarios) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login"; // Redirige al login si el usuario no está en sesión
        }
        model.addAttribute("usuario", usuario);
        return "configuracion"; // El nombre del archivo HTML para editar el perfil
    }

    @PostMapping("/editar")
    public String actualizarPerfil(@ModelAttribute("usuario") Usuarios usuarioActualizado, HttpSession session, Model model) throws NoSuchAlgorithmException, IOException, CloneNotSupportedException {
        Usuarios usuario = (Usuarios) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }

        // Actualiza los datos del usuario con los datos del formulario
        usuario.setNombres(usuarioActualizado.getNombres());
        usuario.setApellidos(usuarioActualizado.getApellidos());
        usuario.setUsuario(usuarioActualizado.getUsuario());
        usuario.setTelefono(usuarioActualizado.getTelefono());
        usuario.setEmail(usuarioActualizado.getEmail());

        // Solo actualizar la contraseña si se proporciona una nueva
        if (usuarioActualizado.getContrasena() != null && !usuarioActualizado.getContrasena().isEmpty()) {
            usuario.setContrasena(Validation.md5(usuarioActualizado.getContrasena()));
        }

        usuariosDaoImpl.update(usuario);
        session.setAttribute("usuario", usuario); // Actualiza la sesión con los nuevos datos del usuario

        model.addAttribute("usuario", usuario);
        return "redirect:/perfil/editar?success";
    }
}

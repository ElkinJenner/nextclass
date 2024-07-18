package com.example.demo.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.model.Usuarios;
import com.example.demo.utils.Validation;

import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.FileOutputStream;


import org.springframework.web.multipart.MultipartFile;

@Controller
public class EditProfileController {

    @Autowired
    private UsuariosDaoImpl usuariosDaoImpl;

   
    @GetMapping("/configuracion")
    public String mostrarFormularioEdicion(HttpSession session, Model model) {
        Usuarios usuario = (Usuarios) session.getAttribute("usuarios");

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        } else {
            // Manejar el caso donde no hay usuario en la sesión
            model.addAttribute("usuario", new Usuarios());
        }

        return "configuracion"; // El nombre del archivo HTML para editar el perfil
    }

    @PostMapping("/configuracion")
    public String actualizarPerfil(@ModelAttribute("usuario") Usuarios usuarioActualizado,
                                   @RequestParam("file-input") MultipartFile file,
                                   HttpSession session, Model model) throws NoSuchAlgorithmException, IOException, CloneNotSupportedException {
        Usuarios usuario = (Usuarios) session.getAttribute("usuarios");
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

        // Manejo de la imagen de perfil
        if (!file.isEmpty()) {
            try {
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                String uploadDir = "src/main/resources/static/upload/professors";
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + fileName);
                try (FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile)) {
                    fileOutputStream.write(file.getBytes());
                }
                usuario.setFotoPerfil(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        usuariosDaoImpl.update(usuario);
        session.setAttribute("usuarios", usuario); // Actualiza la sesión con los nuevos datos del usuario

        model.addAttribute("usuario", usuario);
        return "redirect:/configuracion?success";
    }
}

package com.example.demo.controller;

import com.example.demo.dao.PaisesDaoImpl;
import com.example.demo.dao.UsuariosDaoImpl;
import com.example.demo.model.Paises;
import com.example.demo.model.Usuarios;
import com.example.demo.utils.Validation;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//Componentes para mapear
import com.example.demo.components.UsuarioComponent;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegistroController {

    @Autowired
    private PaisesDaoImpl paisesDao;

    @Autowired
    private UsuarioComponent usuarioComponent;

    @Autowired
    private UsuariosDaoImpl usuariosDao; // Inyección de UsuariosDaoImpl

    @Autowired
    private HttpSession session; // Inyeccion de session HTTPP

    // Método para obtener la lista de países y renderizar la página registrarse
    @GetMapping("/registrarse")
    // showPaises
    public String showRegistro(Model model) {
        List<Paises> paisesList = paisesDao.findAll();

        // Mapear imágenes de países
        Map<String, String> paisesImages = new HashMap<>();
        paisesImages.put("Argentina", "upload/flags/argentina.png");
        paisesImages.put("Bolivia", "upload/flags/bolivia.png");
        paisesImages.put("Brasil", "upload/flags/brasil.png");
        paisesImages.put("Chile", "upload/flags/chile.png");
        paisesImages.put("Colombia", "upload/flags/colombia.png");
        paisesImages.put("Costa Rica", "upload/flags/costarica.png");
        paisesImages.put("Cuba", "upload/flags/cuba.png");
        paisesImages.put("Ecuador", "upload/flags/ecuador.png");
        paisesImages.put("España", "upload/flags/espana.png");
        paisesImages.put("El Salvador", "upload/flags/elsalvador.png");
        paisesImages.put("Guatemala", "upload/flags/guatemala.png");
        paisesImages.put("Honduras", "upload/flags/honduras.png");
        paisesImages.put("México", "upload/flags/mexico.png");
        paisesImages.put("Nicaragua", "upload/flags/nicaragua.png");
        paisesImages.put("Panamá", "upload/flags/panama.png");
        paisesImages.put("Paraguay", "upload/flags/paraguay.png");
        paisesImages.put("Perú", "upload/flags/peru.png");
        paisesImages.put("Puerto Rico", "upload/flags/puertorico.png");
        paisesImages.put("República Dominicana", "upload/flags/repdominicana.png");
        paisesImages.put("Uruguay", "upload/flags/uruguay.png");
        paisesImages.put("Venezuela", "upload/flags/venezuela.png");

        model.addAttribute("paisesList", paisesList);
        model.addAttribute("paisesImages", paisesImages);
        model.addAttribute("tiposUsuarioImages", usuarioComponent.getTiposUsuarioImages());
        return "registrarse";
    }
        @PostMapping("/registrarse")
        public String registrarUsuario(@RequestParam("tipoUsuario") String tipoUsuario,
        @RequestParam("nombres") String nombres,
        @RequestParam("apellidos") String apellidos,
        @RequestParam("usuario") String usuario,
        @RequestParam("contrasena") String contrasena,
        @RequestParam("repetircontrasena") String repetirContrasena,
        @RequestParam("email") String email,
        @RequestParam("telefono") int telefono,
        @RequestParam("paises") Long idPais,
        RedirectAttributes redirectAttributes) {
        // Validar que las contraseñas coinciden
        if (!contrasena.equals(repetirContrasena)) {
            redirectAttributes.addFlashAttribute("error", "Las contraseñas no coinciden");
            return "redirect:/registrarse";
        }
         // Encriptar la contraseña usando MD5
        String hashedPassword;
        try {
            hashedPassword = Validation.md5(contrasena);
        } catch (NoSuchAlgorithmException | IOException | CloneNotSupportedException e) {
            redirectAttributes.addFlashAttribute("error", "Error al encriptar la contraseña");
            return "redirect:/registrarse";
        }

        // Crear un nuevo usuario
        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setTipoUsuario(tipoUsuario);
        nuevoUsuario.setNombres(nombres);
        nuevoUsuario.setApellidos(apellidos);
        nuevoUsuario.setUsuario(usuario);
        nuevoUsuario.setContrasena(hashedPassword); // Guardar la contraseña encriptada
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setTelefono(telefono);
        nuevoUsuario.setIdPais(idPais);
        nuevoUsuario.setFechaRegistro(new Date());

        // Generar codUsuario
        String codUsuario = generateCodUsuario(nombres, apellidos);
        nuevoUsuario.setCodUsuario(codUsuario);

        // Guardar el nuevo usuario
        usuariosDao.save(nuevoUsuario);

        // Crear una session para el nuevo usuario
        session.setAttribute("usuarios", nuevoUsuario);

        // Redirigir a la página de inicio después de un registro exitoso
        return "redirect:/registro_completar";
    }
    private String generateCodUsuario(String nombres, String apellidos) {
    // Obtener la primera letra del primer nombre y la primera letra del primer apellido
    char primeraLetraNombre = Character.toUpperCase(nombres.charAt(0));
    char primeraLetraApellido = Character.toUpperCase(apellidos.charAt(0));

    // Obtener la fecha actual
    LocalDateTime now = LocalDateTime.now();
    String dia = String.format("%02d", now.getDayOfMonth());
    String minutos = String.format("%02d", now.getMinute());
    String segundos = String.format("%02d", now.getSecond());

    // Generar el código de usuario
    return String.format("%c%c%c%s%s%s", 'U', primeraLetraNombre, primeraLetraApellido, dia, minutos, segundos);
}
}
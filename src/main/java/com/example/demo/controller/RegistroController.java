package com.example.demo.controller;

import com.example.demo.dao.PaisesDaoImpl;
import com.example.demo.model.Paises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Componentes para mapear
import com.example.demo.components.UsuarioComponent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegistroController {

    @Autowired
    private PaisesDaoImpl paisesDao;

    @Autowired
    private UsuarioComponent usuarioComponent;

    // Método para obtener la lista de países y renderizar la página registrarse
    @GetMapping("/registrarse")
    // showPaises
    public String showRegistro(Model model) {
        List<Paises> paisesList = paisesDao.findAll();

        // Mapear imágenes a países
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
}
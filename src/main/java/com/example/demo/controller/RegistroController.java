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
    public String showPaises(Model model) {
        List<Paises> paisesList = paisesDao.findAll();

        // Mapear imágenes a países
        Map<String, String> paisesImages = new HashMap<>();
        paisesImages.put("Argentina", "img/flags/argentina.png");
        paisesImages.put("Bolivia", "img/flags/bolivia.png");
        paisesImages.put("Brasil", "img/flags/brasil.png");
        paisesImages.put("Chile", "img/flags/chile.png");
        paisesImages.put("Colombia", "img/flags/colombia.png");
        paisesImages.put("Costa Rica", "img/flags/costarica.png");
        paisesImages.put("Cuba", "img/flags/cuba.png");
        paisesImages.put("Ecuador", "img/flags/ecuador.png");
        paisesImages.put("España", "img/flags/espana.png");
        paisesImages.put("El Salvador", "img/flags/elsalvador.png");
        paisesImages.put("Guatemala", "img/flags/guatemala.png");
        paisesImages.put("Honduras", "img/flags/honduras.png");
        paisesImages.put("México", "img/flags/mexico.png");
        paisesImages.put("Nicaragua", "img/flags/nicaragua.png");
        paisesImages.put("Panamá", "img/flags/panama.png");
        paisesImages.put("Paraguay", "img/flags/paraguay.png");
        paisesImages.put("Perú", "img/flags/peru.png");
        paisesImages.put("Puerto Rico", "img/flags/puertorico.png");
        paisesImages.put("República Dominicana", "img/flags/repdominicana.png");
        paisesImages.put("Uruguay", "img/flags/uruguay.png");
        paisesImages.put("Venezuela", "img/flags/venezuela.png");

        model.addAttribute("paisesList", paisesList);
        model.addAttribute("paisesImages", paisesImages);
        model.addAttribute("tiposUsuarioImages", usuarioComponent.getTiposUsuarioImages());
        return "registrarse";
    }
}
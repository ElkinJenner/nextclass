package com.example.demo.components;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class PaisesComponent {
    // Mapa para almacenar las imágenes correspondientes a las imagenes de tipo
    // usuario
    private final Map<String, String> BanderaImages;

    public PaisesComponent() {
        BanderaImages = new HashMap<>(); // Inicializa el mapa
        //Estaticamente se ha añadido las imagenes de los respectivos paises
        BanderaImages.put("Argentina", "upload/flags/argentina.png");
        BanderaImages.put("Bolivia", "upload/flags/bolivia.png");
        BanderaImages.put("Brasil", "upload/flags/brasil.png");
        BanderaImages.put("Chile", "upload/flags/chile.png");
        BanderaImages.put("Colombia", "upload/flags/colombia.png");
        BanderaImages.put("Costa Rica", "upload/flags/costarica.png");
        BanderaImages.put("Cuba", "upload/flags/cuba.png");
        BanderaImages.put("Ecuador", "upload/flags/ecuador.png");
        BanderaImages.put("España", "upload/flags/espana.png");
        BanderaImages.put("El Salvador", "upload/flags/elsalvador.png");
        BanderaImages.put("Guatemala", "upload/flags/guatemala.png");
        BanderaImages.put("Honduras", "upload/flags/honduras.png");
        BanderaImages.put("México", "upload/flags/mexico.png");
        BanderaImages.put("Nicaragua", "upload/flags/nicaragua.png");
        BanderaImages.put("Panamá", "upload/flags/panama.png");
        BanderaImages.put("Paraguay", "upload/flags/paraguay.png");
        BanderaImages.put("Perú", "upload/flags/peru.png");
        BanderaImages.put("Puerto Rico", "upload/flags/puertorico.png");
        BanderaImages.put("República Dominicana", "upload/flags/repdominicana.png");
        BanderaImages.put("Uruguay", "upload/flags/uruguay.png");
        BanderaImages.put("Venezuela", "upload/flags/venezuela.png");
    }

    public Map<String, String> getBanderaImages() {
        return BanderaImages; // Devuelve el mapa de tipos de usuario e imágenes
    }
    
}

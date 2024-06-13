package com.example.demo.components;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/*Indica que esta clase es un componente Spring,lo que permite su inyección en
otros lugares*/
@Component
public class UsuarioComponent {
    // Mapa para almacenar las imágenes correspondientes a las imagenes de tipo usuario
    private final Map<String, String> tiposUsuarioImages;

    public UsuarioComponent() {
        tiposUsuarioImages = new HashMap<>(); // Inicializa el mapa
        //Estaticamente se ha añadido las imagenes de los respectivos tipos de usuario
        tiposUsuarioImages.put("Estudiante", "img/estudiante_acceso.png"); 
        tiposUsuarioImages.put("Profesor", "img/profesor_acceso.png"); 
    }

    public Map<String, String> getTiposUsuarioImages() {
        return tiposUsuarioImages; // Devuelve el mapa de tipos de usuario e imágenes
    }
}
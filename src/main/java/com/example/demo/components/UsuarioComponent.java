package com.example.demo.components;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UsuarioComponent {
    private final Map<String, String> tiposUsuarioImages;
    public UsuarioComponent() {
        tiposUsuarioImages = new HashMap<>();
        tiposUsuarioImages.put("Estudiante", "img/estudiante_acceso.png");
        tiposUsuarioImages.put("Profesor", "img/profesor_acceso.png");
    }

    public Map<String, String> getTiposUsuarioImages() {
        return tiposUsuarioImages;
    }
    
}

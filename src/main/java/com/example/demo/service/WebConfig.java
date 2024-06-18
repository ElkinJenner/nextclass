package com.example.demo.service;
// Importaciones de Spring Framework necesarias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// Configuración de la clase como una configuración de Spring
@Configuration
public class WebConfig implements WebMvcConfigurer {
    // Inyección de dependencia del interceptor UsuarioInteceptor
    @Autowired
    private UsuarioInteceptor usuarioInteceptor;
    // Método para agregar interceptores al registro de interceptores
    @Override
    public void addInterceptors(@SuppressWarnings("null") InterceptorRegistry registry) {
        // Agrega el UsuarioInteceptor al registro de interceptores y lo aplica a todas
        // las rutas ("/**")
        registry.addInterceptor(usuarioInteceptor).addPathPatterns("/**");
    }

}
package com.example.demo.service;
// Importaciones de Spring Framework y clases Servlet necesarias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// Importación del modelo de Usuarios
import com.example.demo.model.Usuarios;

// Importaciones específicas para Servlet API (Jakarta EE)
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// Definición del componente como un interceptor de Spring
@Component
public class UsuarioInteceptor implements HandlerInterceptor {
    // Inyección de dependencia del objeto HttpSession para manejar la sesión HTTP
    @Autowired
    private HttpSession session;
    // Método postHandle: Se ejecuta después de que se ha manejado la solicitud y
    // antes de la renderización de la vista
    @Override
    public void postHandle(@SuppressWarnings("null") HttpServletRequest request,
            @SuppressWarnings("null") HttpServletResponse response, @SuppressWarnings("null") Object handler,
            @SuppressWarnings("null") ModelAndView modelAndView) throws Exception {
        // Verifica que el objeto ModelAndView no sea nulo y que la sesión HTTP no sea
        // nula
        if (modelAndView != null && session != null) {
            // Obtiene el objeto Usuarios almacenado en la sesión
            Usuarios usuarios = (Usuarios) session.getAttribute("usuarios");
            // Si existe un objeto Usuarios en la sesión, lo agrega al modelo de la vista
            if (usuarios != null) {
                modelAndView.addObject("usuarios", usuarios);
            }
        }
    }
}

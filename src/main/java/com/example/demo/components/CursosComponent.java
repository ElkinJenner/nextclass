package com.example.demo.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CursosComponent {
    // Mapa para almacenar las imágenes correspondientes a los cursos
    private final Map<String, String> cursosImages;

    public CursosComponent() {
        cursosImages = new HashMap<>(); // Inicializa el mapa
        // Añade estáticamente las imágenes de los respectivos cursos
        cursosImages.put("administracion_empresarial", "upload/courses/administracion_empresarial.jpg");
        cursosImages.put("aeroespacial", "upload/courses/aeroespacial.jpg");
        cursosImages.put("algebra_abstracta", "upload/courses/algebra_abstracta.jpg");
        cursosImages.put("algebra_lineal", "upload/courses/algebra_lineal.jpg");
        cursosImages.put("analisismatematico", "upload/courses/analisismatematico.jpg");
        cursosImages.put("aritmetica", "upload/courses/aritmetica.jpg");
        cursosImages.put("astronomia", "upload/courses/astronomia.jpg");
        cursosImages.put("automatascom", "upload/courses/automatascom.jpg");
        cursosImages.put("base_datos", "upload/courses/base_datos.jpg");
        cursosImages.put("bibliotecologia", "upload/courses/bibliotecologia.jpg");
        cursosImages.put("biologia", "upload/courses/biologia.jpg");
        cursosImages.put("biotecnologia", "upload/courses/biotecnologia.jpg");
        cursosImages.put("calculo", "upload/courses/calculo.jpg");
        cursosImages.put("centrales_hidraulicas", "upload/courses/centrales_hidraulicas.jpg");
        cursosImages.put("ciberseguridad", "upload/courses/ciberseguridad.jpg");
        cursosImages.put("ciencia_datos", "upload/courses/ciencia_datos.jpg");
        cursosImages.put("composicion_musical", "upload/courses/composicion_musical.jpg");
        cursosImages.put("computacion_cuantica", "upload/courses/computacion_cuantica.jpg");
        cursosImages.put("conexiones_electricas", "upload/courses/conexiones_electricas.jpg");
        cursosImages.put("construccion_civil", "upload/courses/construccion_civil.jpg");
        cursosImages.put("consultoria_estrategia", "upload/courses/consultoria_estrategia.jpg");
        cursosImages.put("contabilidad_financiera", "upload/courses/contabilidad_financiera.jpg");
        cursosImages.put("criminologia", "upload/courses/criminologia.jpg");
        cursosImages.put("dibujo_ingenieria", "upload/courses/dibujo_ingenieria.jpg");
        cursosImages.put("dibujo_pintura", "upload/courses/dibujo_pintura.jpg");
        cursosImages.put("energias_renovables", "upload/courses/energias_renovables.jpg");
        cursosImages.put("estadistica", "upload/courses/estadistica.jpg");
        cursosImages.put("finanzas_corporativas", "upload/courses/finanzas_corporativas.jpg");
        cursosImages.put("fisica_general", "upload/courses/fisica_general.jpg");
        cursosImages.put("fisicoquimica", "upload/courses/fisicoquimica.jpg");
        cursosImages.put("gamers", "upload/courses/gamers.jpg");
        cursosImages.put("geologia", "upload/courses/geologia.jpg");
        cursosImages.put("geometria_analitica", "upload/courses/geometria_analitica.jpg");
        cursosImages.put("geometria_espacial", "upload/courses/geometria_espacial.jpg");
        cursosImages.put("historia_universal", "upload/courses/historia_universal.jpg");
        cursosImages.put("ilustracion_grafica", "upload/courses/ilustracion_grafica.jpg");
        cursosImages.put("inteligencia_negocios", "upload/courses/inteligencia_negocios.jpg");
        cursosImages.put("interracionh", "upload/courses/interracionh.jpg");
        cursosImages.put("logistica_contable", "upload/courses/logistica_contable.jpg");
        cursosImages.put("manufactura_industrial", "upload/courses/manufactura_industrial.jpg");
        cursosImages.put("marketing_digital", "upload/courses/marketing_digital.jpg");
        cursosImages.put("matematicas_discretas", "upload/courses/matematicas_discretas.jpg");
        cursosImages.put("programacion_movil", "upload/courses/programacion_movil.jpg");
        cursosImages.put("programacion_videogames", "upload/courses/programacion_videogames.jpg");
        cursosImages.put("programacion_web", "upload/courses/programacion_web.jpg");
        cursosImages.put("psicologia", "upload/courses/psicologia.jpg");
        cursosImages.put("quimica_organica", "upload/courses/quimica_organica.jpg");
        cursosImages.put("razonamiento_verbal", "upload/courses/razonamiento_verbal.jpg");
        cursosImages.put("realidadvirtual", "upload/courses/realidadvirtual.jpg");
        cursosImages.put("recursos_humanos", "upload/courses/recursos_humanos.jpg");
        cursosImages.put("robotica_programacion", "upload/courses/robotica_programacion.jpg");
        cursosImages.put("seguridad_control", "upload/courses/seguridad_control.jpg");
        cursosImages.put("serigrafia", "upload/courses/serigrafia.jpg");
        cursosImages.put("sistemas_operativos", "upload/courses/sistemas_operativos.jpg");
        cursosImages.put("sociologia", "upload/courses/sociologia.jpg");
        cursosImages.put("trigonometria", "upload/courses/trigonometria.jpg");
    }

    public Map<String, String> getCursosImages() {
        return cursosImages; // Devuelve el mapa de cursos e imágenes
    }
}

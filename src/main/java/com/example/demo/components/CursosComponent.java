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
        cursosImages.put("Algebra Lineal", "upload/courses/algebra_lineal.jpg");
        cursosImages.put("Astronomia", "upload/courses/astronomia.jpg");
        cursosImages.put("Matemáticas Discretas", "upload/courses/matematicas_discretas.jpg");
        cursosImages.put("Geometría Analítica", "upload/courses/geometria_analitica.jpg");
        cursosImages.put("Química Orgánica", "upload/courses/quimica_organica.jpg");
        cursosImages.put("Físico Química", "upload/courses/fisicoquimica.jpg");
        cursosImages.put("Biotecnología", "upload/courses/biotecnologia.jpg");
        cursosImages.put("Computación Cuántica", "upload/courses/computacion_cuantica.jpg");
        cursosImages.put("Algebra Abstracta", "upload/courses/algebra_abstracta.jpg");
        cursosImages.put("Física General", "upload/courses/fisica_general.jpg");
        cursosImages.put("Geometría del Espacio", "upload/courses/geometria_espacial.jpg");
        cursosImages.put("Biología", "upload/courses/biologia.jpg");
        cursosImages.put("Cálculo", "upload/courses/calculo.jpg");
        cursosImages.put("Aritmética", "upload/courses/aritmetica.jpg");
        cursosImages.put("Trigonometria", "upload/courses/trigonometria.jpg");
        cursosImages.put("Estadística y Probabilidades", "upload/courses/estadistica.jpg");
        cursosImages.put("Análisis Matemático", "upload/courses/analisismatematico.jpg");
        cursosImages.put("Geología General", "upload/courses/geologia.jpg");
        cursosImages.put("Programacion Web", "upload/courses/programacion_web.jpg");
        cursosImages.put("Ciencia de Datos", "upload/courses/ciencia_datos.jpg");
        cursosImages.put("Ciberseguridad", "upload/courses/ciberseguridad.jpg");
        cursosImages.put("Programación Móvil", "upload/courses/programacion_movil.jpg");
        cursosImages.put("Sistemas Operativos", "upload/courses/sistemas_operativos.jpg");
        cursosImages.put("Base de Datos", "upload/courses/base_datos.jpg");
        cursosImages.put("Programacion de Videogames", "upload/courses/programacion_videogames.jpg");
        cursosImages.put("Interración Humano Computador", "upload/courses/interracionh.jpg");
        cursosImages.put("Programación Robótica", "upload/courses/robotica_programacion.jpg");
        cursosImages.put("Realidad Virtual", "upload/courses/realidadvirtual.jpg");
        cursosImages.put("Automatas y Compiladores", "upload/courses/automatascom.jpg");
        cursosImages.put("Aeroespacial Meteorológica", "upload/courses/aeroespacial.jpg");
        cursosImages.put("Centrales Hidráulicas", "upload/courses/centrales_hidraulicas.jpg");
        cursosImages.put("Construccion Civil", "upload/courses/construccion_civil.jpg");
        cursosImages.put("Dibujo para Ingeniería", "upload/courses/dibujo_ingenieria.jpg");
        cursosImages.put("Conexiones Eléctricas", "upload/courses/conexiones_electricas.jpg");
        cursosImages.put("Energias Renovables", "upload/courses/energias_renovables.jpg");
        cursosImages.put("Manufactura Industrial", "upload/courses/manufactura_industrial.jpg");
        cursosImages.put("Seguridad de Control", "upload/courses/seguridad_control.jpg");
        cursosImages.put("Bibliotecología", "upload/courses/bibliotecologia.jpg");
        cursosImages.put("Historia Universal", "upload/courses/historia_universal.jpg");
        cursosImages.put("Razonamiento Verbal", "upload/courses/razonamiento_verbal.jpg");
        cursosImages.put("Sociología", "upload/courses/sociologia.jpg");
        cursosImages.put("Psicología Humana", "upload/courses/psicologia.jpg");
        cursosImages.put("Criminología", "upload/courses/criminologia.jpg");
        cursosImages.put("Administracion Empresarial", "upload/courses/administracion_empresarial.jpg");
        cursosImages.put("Inteligencia de Negocios", "upload/courses/inteligencia_negocios.jpg");
        cursosImages.put("Logística Contable", "upload/courses/logistica_contable.jpg");
        cursosImages.put("Finanzas Corporativas", "upload/courses/finanzas_corporativas.jpg");
        cursosImages.put("Contabilidad Financiera", "upload/courses/contabilidad_financiera.jpg");
        cursosImages.put("Marketing Digital", "upload/courses/marketing_digital.jpg");
        cursosImages.put("Recursos Humanos", "upload/courses/recursos_humanos.jpg");
        cursosImages.put("Consultoría y Estrategia", "upload/courses/consultoria_estrategia.jpg");
        cursosImages.put("Ilustración Gráfica", "upload/courses/ilustracion_grafica.jpg");
        cursosImages.put("Serigrafia", "upload/courses/serigrafia.jpg");
        cursosImages.put("Composicion musical", "upload/courses/composicion_musical.jpg");
        cursosImages.put("Dibujo pintura", "upload/courses/dibujo_pintura.jpg");
        cursosImages.put("Gamers", "upload/courses/gamers.jpg");
    }

    public Map<String, String> getCursosImages() {
        return cursosImages; // Devuelve el mapa de cursos e imágenes
    }
}

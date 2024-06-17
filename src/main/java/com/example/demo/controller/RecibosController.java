package com.example.demo.controller;

import com.example.demo.dao.RecibosDaoImpl;
import com.example.demo.model.Recibos;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Marca esta clase como un controlador de Spring MVC
@Controller
public class RecibosController {

    @Autowired
    // Inyección de dependencia del DAO para acceder a los recibos
    private RecibosDaoImpl recibosDao;

    @GetMapping("/recibos")
    public String listRecibos(Model model) {
        // Obtiene todos los recibos desde la base de datos
        List<Recibos> recibosList = recibosDao.findAll();
        // Agrega la lista de recibos al modelo
        model.addAttribute("recibosList", recibosList);
        // Devuelve el nombre lógico de la vista que se debe renderizar
        return "factura";
    }
    
    // Maneja las solicitudes GET a la ruta '/recibos/download' para descargar un archivo Excel
    @GetMapping("/recibos/download")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        // Obtiene todos los recibos desde la base de datos
        List<Recibos> recibosList = recibosDao.findAll();
        // Configuración de la respuesta HTTP para descargar un archivo Excel
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=recibos.xlsx");
        // Creación del libro de trabajo Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Recibos");
        // Creación de la fila de encabezado
        Row headerRow = sheet.createRow(0);
        String[] columns = { "ID Recibo", "Nombre del Profesor", "Nombre del Estudiante", "Curso", "Precio", "Tema",
                "Descripción" };
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }
        // Llenado de datos de los recibos en el archivo Excel
        int rowNum = 1;
        for (Recibos recibo : recibosList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(recibo.getIdRecibo());
            row.createCell(1).setCellValue(recibo.getNombreProfesor());
            row.createCell(2).setCellValue(recibo.getNombreEstudiante());
            row.createCell(3).setCellValue(recibo.getCurso());
            row.createCell(4).setCellValue(recibo.getPrecio().doubleValue());
            row.createCell(5).setCellValue(recibo.getTema());
            row.createCell(6).setCellValue(recibo.getDescripcion());
        }
        /*Ajusta automáticamente el tamaño de las columnas para que el contenido se
        ajuste correctamente*/
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        // Escribe el contenido del libro de trabajo al OutputStream de la respuesta HTTP
        workbook.write(response.getOutputStream());
        workbook.close(); // Cierra el libro de trabajo para liberar recursos
    }
}
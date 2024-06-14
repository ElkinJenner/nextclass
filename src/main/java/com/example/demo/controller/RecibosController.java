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

@Controller
public class RecibosController {

    @Autowired
    private RecibosDaoImpl recibosDao;

    @GetMapping("/recibos")
    public String listRecibos(Model model) {
        List<Recibos> recibosList = recibosDao.findAll();
        model.addAttribute("recibosList", recibosList);
        return "factura";
    }

    @GetMapping("/recibos/download")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        List<Recibos> recibosList = recibosDao.findAll();

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=recibos.xlsx");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Recibos");

        Row headerRow = sheet.createRow(0);
        String[] columns = { "ID Recibo", "Nombre del Profesor", "Nombre del Estudiante", "Curso", "Precio", "Tema",
                "Descripción" };
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

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

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
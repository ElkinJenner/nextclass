package com.example.demo.controller;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.dao.RecibosDaoImpl;
import com.example.demo.model.Recibos;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

    @Autowired
    private RecibosDaoImpl recibosDao;

    @GetMapping("/report/download")
    public void downloadReport(HttpServletResponse response) {
        try {
            // Recupera los datos para el reporte
            List<Recibos> recibosList = recibosDao.findAll();
            recibosList.forEach(System.out::println);
            if (recibosList == null || recibosList.isEmpty()) {
                throw new IllegalStateException("No se encontraron datos para el reporte.");
            }

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(recibosList);

            // Carga y llena la plantilla JasperReport
            ClassPathResource reportResource = new ClassPathResource("report/JasperNextR.jasper");
            if (!reportResource.exists()) {
                throw new RuntimeException("Archivo del reporte no encontrado.");
            }

            InputStream reportStream = reportResource.getInputStream();
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);

            // Llena el reporte con los datos
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ds", dataSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Exporta el reporte a PDF
            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");
            try (OutputStream outputStream = response.getOutputStream()) {
                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el archivo del reporte", e);
        } catch (JRException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al compilar o llenar el reporte Jasper", e);
        }
    }
}
package com.example.demo.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.RecibosDaoImpl;
import com.example.demo.model.Recibos;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class JasperReportService {

    @Autowired
    private static RecibosDaoImpl recibosDaoImpl;

    public void exportPdf(Long idRecibo, HttpServletResponse response) throws Exception {

        // Obtenre datos necesaris para el informe
        Recibos recibo = recibosDaoImpl.findById(idRecibo);

        // Cargar plantilla Jasper
        InputStream jaspStream = this.getClass().getResourceAsStream("/resources/templates/report/Report.jrxml");
        JasperReport JasperReport = (JasperReport) JRLoader.loadObject(jaspStream);

        // Parametros al informe pasar
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idRecibo", recibo.getIdRecibo());
        parametros.put("nombreProfesor", recibo.getNombreProfesor());
        parametros.put("nombreEstudiante", recibo.getNombreEstudiante());
        parametros.put("curso", recibo.getCurso());
        parametros.put("precio", recibo.getPrecio());
        parametros.put("tema", recibo.getTema());
        parametros.put("descripcion", recibo.getDescripcion());

        // Lenar informe jasper.jrxml con los datos recopilados
        JasperPrint jasperPrint = JasperFillManager.fillReport(JasperReport, parametros, new JREmptyDataSource());

        // Exportar informe a PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=recibo.pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}
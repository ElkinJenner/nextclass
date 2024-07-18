package com.example.demo.service;

import jakarta.servlet.http.Part;

// Esto lo saque de uno de los proyectos que envio extrae el nombre del archivo
public class FileName {
    public String getFileName(final Part part) {
        // final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}

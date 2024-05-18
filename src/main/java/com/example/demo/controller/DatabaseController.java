package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class DatabaseController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/validate-db")
    public String validateDatabaseConnection(Model model) {
        String message;
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                message = "Connected to the database successfully!";
            } else {
                message = "Failed to connect to the database.";
            }
        } catch (SQLException e) {
            message = "Failed to connect to the database: " + e.getMessage();
        }
        model.addAttribute("message", message);
        return "validation";
    }
}
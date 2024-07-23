package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("null")
    public int getTotalProfessors() {
        String sql = "SELECT COUNT(*) FROM profesores";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @SuppressWarnings("null")
    public int getTotalAsesorias() {
        String sql = "SELECT COUNT(*) FROM asesorias";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @SuppressWarnings("null")
    public int getTotalStudents() {
        String sql = "SELECT COUNT(*) FROM estudiantes"; // Adjust table name if needed
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @SuppressWarnings("null")
    public int getTotalSessions() {
        String sql = "SELECT COUNT(*) FROM sesiones"; // Adjust table name if needed
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
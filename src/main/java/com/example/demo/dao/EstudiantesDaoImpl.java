package com.example.demo.dao;

import com.example.demo.model.Estudiantes;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EstudiantesDaoImpl extends CrudDaoImpl<Estudiantes, Long> {

    @Override
    protected String getTableName() {
        return "estudiantes";
    }

    @Override
    protected RowMapper<Estudiantes> getRowMapper() {
        return new RowMapper<Estudiantes>() {
            @Override
            public Estudiantes mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                Estudiantes estudiante = new Estudiantes();
                estudiante.setIdEstudiante(rs.getLong("idEstudiante"));
                estudiante.setIdUsuario(rs.getLong("idUsuario"));
                estudiante.setNivelAcademico(rs.getString("nivelAcademico"));
                // Elimina o comenta la línea siguiente si no tienes la columna fotoPerfil
                // estudiante.setFotoPerfil(rs.getString("fotoPerfil"));
                return estudiante;
            }
        };
    }

    public List<Estudiantes> findAll() {
        String sql = "SELECT * FROM " + getTableName();
        return jdbcTemplate.query(sql, getRowMapper());
    }
}
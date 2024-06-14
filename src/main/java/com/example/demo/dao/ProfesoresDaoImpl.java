package com.example.demo.dao;

import com.example.demo.model.Profesores;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProfesoresDaoImpl extends CrudDaoImpl<Profesores, Long> {
    // Método para obtener el nombre de la tabla
    @Override
    protected String getTableName() {
        return "profesores";
    }

    // Método para mapear filas de resultados de la base de datos a objetos
    @Override
    protected RowMapper<Profesores> getRowMapper() {
        return new RowMapper<Profesores>() {
            @Override
            public Profesores mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                Profesores profesores = new Profesores();
                profesores.setIdProfesor(rs.getLong("idProfesor"));
                profesores.setIdUsuario(rs.getLong("idUsuario"));
                profesores.setPermiso(rs.getString("permiso"));
                profesores.setProfesion(rs.getString("profesion"));
                profesores.setDescripcion(rs.getString("descripcion"));
                profesores.setFotoPerfil(rs.getString("fotoPerfil"));
                profesores.setNombrePais(rs.getString("nombrePais"));
                return profesores;
            }
        };
    }

    // Método para obtener una lista de profesores con paginación
    public List<Profesores> findAllWithPagination(int offset, int pageSize) {
        String sql = "SELECT p.*, u.fotoPerfil AS fotoPerfil, pa.pais AS nombrePais " +
                "FROM " + getTableName() + " p " +
                "INNER JOIN usuarios u ON p.idUsuario = u.idUsuario " +
                "INNER JOIN paises pa ON u.idPais = pa.idPais " +
                "LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, getRowMapper(), pageSize, offset);
    }

    // Método para contar el número total de profesores
    public int count() {
        String sql = "SELECT COUNT(*) FROM " + getTableName();
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count : 0; // Si count es null, devuelve 0
    }
}
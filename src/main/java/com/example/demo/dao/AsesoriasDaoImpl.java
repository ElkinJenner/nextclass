package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Asesorias;

import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class AsesoriasDaoImpl extends CrudDaoImpl<Asesorias, Long> {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Método para obtener el nombre de la tabla
    @Override
    protected String getTableName() {
        return "asesorias";
    }

    // Método para capturar todos los campos de la clase modelo
    @Override
    protected RowMapper<Asesorias> getRowMapper() {
        return new RowMapper<Asesorias>() {
            @Override
            public Asesorias mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                Asesorias asesorias = new Asesorias();
                asesorias.setIdAsesoria(rs.getLong("idAsesoria"));
                asesorias.setIdCurso(rs.getLong("idCurso"));
                asesorias.setIdProfesor(rs.getLong("idProfesor"));
                asesorias.setTema(rs.getString("tema"));
                asesorias.setNomProfesor(rs.getString("nomProfesor"));
                asesorias.setNomCurso(rs.getString("nomCurso"));
                asesorias.setDescripcion(rs.getString("descripcion"));
                asesorias.setProfesion(rs.getString("profesion"));
                asesorias.setFotoPerfil(rs.getString("fotoPerfil"));
                asesorias.setCategoriaCurso(rs.getString("categoriaCurso"));
                return asesorias;
            }
        };
    }

    // Método para registrar, guardar el nombre de la tabla
    @Override
    public void save(Asesorias entity) {
        String sql = "INSERT INTO asesorias (idAsesoria, idCurso, idProfesor, tema, descripcion) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getIdAsesoria(), entity.getIdCurso(), entity.getIdProfesor(), entity.getTema(),
                entity.getDescripcion());
    }

    @Override
    public void update(Asesorias entity) {
        String sql = "UPDATE asesorias SET idCurso = ?, idProfesor = ?, tema = ?, descripcion = ? WHERE idAsesoria = ?";
        jdbcTemplate.update(sql, entity.getIdCurso(), entity.getIdProfesor(), entity.getTema(), entity.getDescripcion(),
                entity.getIdAsesoria());
    }

    // Método para obtener asesorías por curso
    public List<Asesorias> findByCurso(String curso) {
        String sql = "SELECT a.*, " +
                "CONCAT(u.nombres, ' ', u.apellidos) AS nomProfesor, " +
                "c.curso AS nomCurso, " +
                "categ.categoriaCurso AS categoriaCurso, " +
                "p.profesion, " +
                "u.fotoPerfil " +
                "FROM asesorias a " +
                "INNER JOIN cursos c ON a.idCurso = c.idCurso " +
                "INNER JOIN categoriacursos categ ON c.idCategoriaCurso = categ.idCategoriaCurso " +
                "INNER JOIN profesores p ON a.idProfesor = p.idProfesor " +
                "INNER JOIN usuarios u ON p.idUsuario = u.idUsuario " +
                "WHERE c.curso = :curso";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("curso", curso);

        return namedParameterJdbcTemplate.query(sql, params, getRowMapper());
    }
}
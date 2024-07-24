package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Inscripciones;

import java.util.List;

@Repository
public class InscripcionesDaoImpl extends CrudDaoImpl<Inscripciones, Long> {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    protected String getTableName() {
        return "inscripciones";
    }

    @Override
    protected RowMapper<Inscripciones> getRowMapper() {
        return (rs, rowNum) -> {
            Inscripciones inscripcion = new Inscripciones();
            inscripcion.setIdInscripcion(rs.getLong("idInscripcion"));
            inscripcion.setIdSesion(rs.getInt("idSesion"));
            inscripcion.setIdEstudiante(rs.getInt("idEstudiante"));
            inscripcion.setIdAsesoria(rs.getInt("idAsesoria"));
            inscripcion.setFechaInscripcion(rs.getDate("fechaInscripcion"));
            inscripcion.setTema(rs.getString("tema"));
            inscripcion.setDuracion(rs.getInt("duracion"));
            inscripcion.setPrecio(rs.getBigDecimal("precio"));
            return inscripcion;
        };
    }

    @Override
    public List<Inscripciones> findAll() {
        String sql = "SELECT i.idInscripcion, i.idSesion, i.idEstudiante, i.idAsesoria, i.fechaInscripcion, "
                + "a.tema, a.duracion, a.precio "
                + "FROM inscripciones i "
                + "INNER JOIN asesorias a ON i.idAsesoria = a.idAsesoria";
        return namedParameterJdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public void save(Inscripciones inscripcion) {
        String sql = "INSERT INTO " + getTableName()
                + " (idSesion, idEstudiante, idAsesoria, fechaInscripcion) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, inscripcion.getIdSesion(), inscripcion.getIdEstudiante(),
                inscripcion.getIdAsesoria(), inscripcion.getFechaInscripcion());
    }

    @Override
    public void update(Inscripciones inscripcion) {
        String sql = "UPDATE " + getTableName()
                + " SET idSesion = ?, idEstudiante = ?, idAsesoria = ?, fechaInscripcion = ? WHERE idInscripcion = ?";
        jdbcTemplate.update(sql, inscripcion.getIdSesion(), inscripcion.getIdEstudiante(),
                inscripcion.getIdAsesoria(),
                inscripcion.getFechaInscripcion(), inscripcion.getIdInscripcion());
    }

    @Override
    public void deleteById(Long idInscripcion) {
        String sql = "DELETE FROM " + getTableName() + " WHERE idInscripcion = ?";
        jdbcTemplate.update(sql, idInscripcion);
    }
}
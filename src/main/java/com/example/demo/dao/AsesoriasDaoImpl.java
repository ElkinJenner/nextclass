package com.example.demo.dao;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Asesorias;

@Repository
public class AsesoriasDaoImpl extends CrudDaoImpl<Asesorias, Long> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    protected String getTableName() {
        return "asesorias";
    }

    @Override
    protected RowMapper<Asesorias> getRowMapper() {
        return (rs, rowNum) -> {
            Asesorias asesoria = new Asesorias();
            asesoria.setIdAsesoria(rs.getLong("idAsesoria"));
            asesoria.setIdCurso(rs.getLong("idCurso"));
            asesoria.setIdProfesor(rs.getLong("idProfesor"));
            asesoria.setTema(rs.getString("tema"));
            asesoria.setDescripcion(rs.getString("descripcion"));

            // Convert sql.Time a LocalTime
            Time duracionSql = rs.getTime("duracion");
            LocalTime duracion = duracionSql.toLocalTime();
            asesoria.setDuracion(duracion);
            asesoria.setPrecio(rs.getBigDecimal("precio"));
            asesoria.setCapacidad(rs.getInt("capacidad"));
            asesoria.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
            asesoria.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
            return asesoria;
        };
    }

    @Override
    public List<Asesorias> findAll() {
        String sql = "SELECT * FROM asesorias";
        return jdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public Asesorias findById(Long id) {
        String sql = "SELECT * FROM asesorias WHERE idAsesoria = ?";
        List<Asesorias> results = jdbcTemplate.query(sql, getRowMapper(), id);
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public void save(Asesorias entity) {
        String sql = "INSERT INTO asesorias (idCurso, idProfesor, tema, descripcion, duracion, precio, capacidad, fechaInicial, fechaFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getIdCurso(), entity.getIdProfesor(), entity.getTema(), entity.getDescripcion(),
                Time.valueOf(entity.getDuracion()), entity.getPrecio(), entity.getCapacidad(), entity.getFechaInicial(),
                entity.getFechaFinal());
    }

    @Override
    public void update(Asesorias entity) {
        String sql = "UPDATE asesorias SET idCurso = ?, idProfesor = ?, tema = ?, descripcion = ?, duracion = ?, precio = ?, capacidad = ?, fechaInicial = ?, fechaFinal = ? WHERE idAsesoria = ?";
        jdbcTemplate.update(sql, entity.getIdCurso(), entity.getIdProfesor(), entity.getTema(), entity.getDescripcion(),
                Time.valueOf(entity.getDuracion()), entity.getPrecio(), entity.getCapacidad(), entity.getFechaInicial(),
                entity.getFechaFinal(), entity.getIdAsesoria());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM asesorias WHERE idAsesoria = ?";
        jdbcTemplate.update(sql, id);
    }
}
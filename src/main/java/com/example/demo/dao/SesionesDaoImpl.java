package com.example.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Sesiones;

@Repository
public class SesionesDaoImpl extends CrudDaoImpl<Sesiones, Integer> {

    @Override
    protected String getTableName() {
        return "sesiones";
    }

    @Override
    protected RowMapper<Sesiones> getRowMapper() {
        return (rs, rowNum) -> {
            Sesiones sesion = new Sesiones();
            sesion.setIdSesion(rs.getInt("idSesion"));
            sesion.setIdAsesoria(rs.getInt("idAsesoria"));
            sesion.setIdProfesor(rs.getInt("idProfesor"));
            sesion.setDia(rs.getString("dia"));
            sesion.setHoraInicial(rs.getTime("horaInicial"));
            sesion.setHoraFinal(rs.getTime("horaFinal"));
            return sesion;
        };
    }

    public List<Sesiones> findByAsesoriaId(int idAsesoria) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE idAsesoria = ?";
        return jdbcTemplate.query(sql, getRowMapper(), idAsesoria);
    }

    @Override
    public void save(Sesiones sesion) {
        String sql = "INSERT INTO " + getTableName()
                + " (idAsesoria, idProfesor, dia, horaInicial, horaFinal) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, sesion.getIdAsesoria(), sesion.getIdProfesor(), sesion.getDia(),
                sesion.getHoraInicial(), sesion.getHoraFinal());
    }

    @Override
    public void update(Sesiones sesion) {
        String sql = "UPDATE " + getTableName()
                + " SET idAsesoria = ?, idProfesor = ?, dia = ?, horaInicial = ?, horaFinal = ? WHERE idSesion = ?";
        jdbcTemplate.update(sql, sesion.getIdAsesoria(), sesion.getIdProfesor(), sesion.getDia(),
                sesion.getHoraInicial(), sesion.getHoraFinal(), sesion.getIdSesion());
    }

    @Override
    public void deleteById(Integer idSesion) {
        String sql = "DELETE FROM " + getTableName() + " WHERE idSesion = ?";
        jdbcTemplate.update(sql, idSesion);
    }
}
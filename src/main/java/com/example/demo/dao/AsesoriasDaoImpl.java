package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Asesorias;

@Repository
public class AsesoriasDaoImpl extends CrudDaoImpl<Asesorias, Long> {

    @Override
    protected String getTableName() {
        return "asesorias";
    }

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
                asesorias.setDescripcionC(rs.getString("descripcionC"));
                asesorias.setDescripcionL(rs.getString("descripcionL"));
                asesorias.setCapacidad(rs.getLong("capacidad"));
                asesorias.setPrecio(rs.getDouble("precio"));
                return asesorias;
            }
        };
    }

    @Override
    public void save(Asesorias entity) {
        String sql = "INSERT INTO asesorias (idCurso, idProfesor, tema, descripcionC, descripcionL, capacidad, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getIdCurso(), entity.getIdProfesor(), entity.getTema(),
                entity.getDescripcionC(), entity.getDescripcionL(), entity.getCapacidad(), entity.getPrecio());
    }

    @Override
    public void update(Asesorias entity) {
        String sql = "UPDATE asesorias SET idCurso = ?, idProfesor = ?, tema = ?, descripcionC = ?, descripcionL = ?, capacidad = ?, precio = ? WHERE idAsesoria = ?";
        jdbcTemplate.update(sql, entity.getIdCurso(), entity.getIdProfesor(), entity.getTema(),
                entity.getDescripcionC(), entity.getDescripcionL(), entity.getCapacidad(), entity.getPrecio(),
                entity.getIdAsesoria());
    }
}
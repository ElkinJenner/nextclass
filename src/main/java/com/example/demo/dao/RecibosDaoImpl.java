package com.example.demo.dao;

import com.example.demo.model.Recibos;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RecibosDaoImpl extends CrudDaoImpl<Recibos, Long> {

    @Override
    protected String getTableName() {
        return "recibos";
    }

    @Override
    protected RowMapper<Recibos> getRowMapper() {
        return new RowMapper<Recibos>() {
            @Override
            public Recibos mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                Recibos recibo = new Recibos();
                recibo.setIdRecibo(rs.getLong("idRecibo"));
                recibo.setIdPago(rs.getLong("idPago"));
                recibo.setIdProfesor(rs.getLong("idProfesor"));
                recibo.setIdEstudiante(rs.getLong("idEstudiante"));
                recibo.setNombreProfesor(rs.getString("nombreProfesor"));
                recibo.setNombreEstudiante(rs.getString("nombreEstudiante"));
                recibo.setCurso(rs.getString("curso"));
                recibo.setPrecio(rs.getBigDecimal("precio"));
                recibo.setTema(rs.getString("tema"));
                recibo.setDescripcion(rs.getString("descripcion"));
                return recibo;
            }
        };
    }

    @Override
    public List<Recibos> findAll() {
        String sql = "SELECT r.idRecibo, r.idPago, r.idProfesor, p.idEstudiante, " +
                "profesor.nombres AS nombreProfesor, estudiante.nombres AS nombreEstudiante, " +
                "c.curso, a.precio, a.tema, a.descripcion AS descripcionC " +
                "FROM recibos r " +
                "INNER JOIN pagos p ON r.idPago = p.idPago " +
                "INNER JOIN usuarios profesor ON r.idProfesor = profesor.idUsuario " +
                "INNER JOIN estudiantes e ON p.idEstudiante = e.idEstudiante " +
                "INNER JOIN usuarios estudiante ON e.idUsuario = estudiante.idUsuario " +
                "INNER JOIN asesorias a ON p.idAsesoria = a.idAsesoria " + // Cambio aquí
                "INNER JOIN cursos c ON a.idCurso = c.idCurso";
        return jdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public Recibos findById(Long id) {
        String sql = "SELECT r.idRecibo, r.idPago, r.idProfesor, p.idEstudiante, " +
                "profesor.nombres AS nombreProfesor, estudiante.nombres AS nombreEstudiante, " +
                "c.curso, a.precio, a.tema, a.descripcion AS descripcionC " +
                "FROM recibos r " +
                "INNER JOIN pagos p ON r.idPago = p.idPago " +
                "INNER JOIN usuarios profesor ON r.idProfesor = profesor.idUsuario " +
                "INNER JOIN estudiantes e ON p.idEstudiante = e.idEstudiante " +
                "INNER JOIN usuarios estudiante ON e.idUsuario = estudiante.idUsuario " +
                "INNER JOIN asesorias a ON p.idAsesoria = a.idAsesoria " + // Cambio aquí
                "INNER JOIN cursos c ON a.idCurso = c.idCurso " +
                "WHERE r.idRecibo = ?";
        List<Recibos> results = jdbcTemplate.query(sql, getRowMapper(), id);
        return results.isEmpty() ? null : results.get(0);
    }
}
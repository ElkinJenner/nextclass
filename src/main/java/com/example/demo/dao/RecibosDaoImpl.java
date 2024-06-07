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
                recibo.setIdAsesoria(rs.getLong("idAsesoria"));
                recibo.setIdEstudiante(rs.getLong("idEstudiante"));
                recibo.setNombreProfesor(rs.getString("nombreProfesor"));
                recibo.setNombreEstudiante(rs.getString("nombreEstudiante"));
                recibo.setCurso(rs.getString("curso"));
                recibo.setPrecio(rs.getBigDecimal("precio"));
                recibo.setHoras(rs.getInt("horas"));
                recibo.setTema(rs.getString("tema"));
                recibo.setDescripcionC(rs.getString("descripcionC"));
                return recibo;
            }
        };
    }

    @Override
    public List<Recibos> findAll() {
        String sql = "SELECT r.idRecibo, r.idPago, r.idProfesor, p.idAsesoria, p.idEstudiante, "
                + "profesor.nombres as nombreProfesor, estudiante.nombres as nombreEstudiante, "
                + "c.curso, a.precio, a.capacidad as horas, a.tema, a.descripcionC "
                + "FROM recibos r "
                + "INNER JOIN pagos p ON r.idPago = p.idPago "
                + "INNER JOIN usuarios profesor ON r.idProfesor = profesor.idUsuario "
                + "INNER JOIN usuarios estudiante ON p.idEstudiante = estudiante.idUsuario "
                + "INNER JOIN asesorias a ON p.idAsesoria = a.idAsesoria "
                + "INNER JOIN cursos c ON a.idCurso = c.idCurso";
        return jdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public Recibos findById(Long id) {
        String sql = "SELECT r.idRecibo, r.idPago, r.idProfesor, p.idAsesoria, p.idEstudiante, "
                + "profesor.nombres as nombreProfesor, estudiante.nombres as nombreEstudiante, "
                + "c.curso, a.precio, a.capacidad as horas, a.tema, a.descripcionC "
                + "FROM recibos r "
                + "INNER JOIN pagos p ON r.idPago = p.idPago "
                + "INNER JOIN usuarios profesor ON r.idProfesor = profesor.idUsuario "
                + "INNER JOIN usuarios estudiante ON p.idEstudiante = estudiante.idUsuario "
                + "INNER JOIN asesorias a ON p.idAsesoria = a.idAsesoria "
                + "INNER JOIN cursos c ON a.idCurso = c.idCurso "
                + "WHERE r.idRecibo = ?";
        List<Recibos> results = jdbcTemplate.query(sql, getRowMapper(), id);
        return results.isEmpty() ? null : results.get(0);
    }
}
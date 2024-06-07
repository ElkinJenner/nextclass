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
    /*
     * Anotación para capturar la capa de datos de
     * nuestro modelo clase Recibos
    */
    @Override
    protected String getTableName() {
        return "recibos";
    }
    
    /*
     * El método RowMapper permite mapear filas de
     * resultados SQL
     */
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

    /*
     * El método findAll busca y devuelve todos los campos disponibles en la base
     * de datos de la tabla Recibos.
     */
    @Override
    public List<Recibos> findAll() {
        String sql = "SELECT r.idRecibo, r.idPago, r.idProfesor, p.idAsesoria, p.idEstudiante, " 
                + "profesor.nombres as nombreProfesor, estudiante.nombres as nombreEstudiante, "
                + "c.curso, a.precio, a.capacidad as horas, a.tema, a.descripcionC "
                + "FROM recibos r "
                /*
                 * Selecciona atraves de JOINS (Inner JOINS) la relación de la tabla Recibos de la base de
                 * datos con las otras tablas que tienen relación y asi poder capturar los otros campos
                 */
                + "INNER JOIN pagos p ON r.idPago = p.idPago "
                + "INNER JOIN usuarios profesor ON r.idProfesor = profesor.idUsuario "
                + "INNER JOIN usuarios estudiante ON p.idEstudiante = estudiante.idUsuario "
                + "INNER JOIN asesorias a ON p.idAsesoria = a.idAsesoria "
                + "INNER JOIN cursos c ON a.idCurso = c.idCurso";
        return jdbcTemplate.query(sql, getRowMapper()); //Devuelve SQL implementado por la clase proporcionada por Spring JDBC
    }
    
    /*
     * Este método findById(Long id) se utiliza para buscar un recibo en la base de
     * datos basado atravez de su id.
     */
    @Override
    public Recibos findById(Long id) {
        String sql = "SELECT r.idRecibo, r.idPago, r.idProfesor, p.idAsesoria, p.idEstudiante, "
                + "profesor.nombres as nombreProfesor, estudiante.nombres as nombreEstudiante, "
                + "c.curso, a.precio, a.capacidad as horas, a.tema, a.descripcionC "
                + "FROM recibos r "
                /*
                 * Selecciona atraves de JOINS (Inner JOINS) la relación de la tabla Recibos de
                 * la base de
                 * datos con las otras tablas que tienen relación y asi poder capturar los otros
                 * campos
                 */
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
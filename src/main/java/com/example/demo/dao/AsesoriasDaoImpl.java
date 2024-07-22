package com.example.demo.dao;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
            asesoria.setIdUsuario(rs.getLong("idUsuario"));
            asesoria.setTema(rs.getString("tema"));
            asesoria.setDescripcion(rs.getString("descripcion"));

            // Añadir el nombre del curso
            asesoria.setNomCurso(rs.getString("nomCurso"));

            // Añadir la categoría del curso
            asesoria.setCategoriaCurso(rs.getString("categoriaCurso"));

            // Añadir detalles del usuario
            asesoria.setNombres(rs.getString("nombres"));
            asesoria.setFotoPerfil(rs.getString("fotoPerfil"));
            asesoria.setProfesion(rs.getString("profesion"));

            // Convertir sql.Time a LocalTime
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
        String sql = "SELECT a.idAsesoria, a.idCurso, a.idProfesor, a.idUsuario, a.tema, a.descripcion, " +
                "c.curso AS nomCurso, cc.categoriaCurso, u.nombres, u.fotoPerfil, p.profesion, a.duracion, a.precio, a.capacidad, a.fechaInicial, a.fechaFinal "
                +
                "FROM asesorias a " +
                "JOIN cursos c ON a.idCurso = c.idCurso " +
                "JOIN categoriacursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso " +
                "JOIN usuarios u ON a.idUsuario = u.idUsuario " +
                "JOIN profesores p ON a.idProfesor = p.idProfesor";
        return jdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public Asesorias findById(Long id) {
        String sql = "SELECT a.idAsesoria, a.idCurso, a.idProfesor, a.idUsuario, a.tema, a.descripcion, " +
                "c.curso AS nomCurso, cc.categoriaCurso, u.nombres, u.fotoPerfil, p.profesion, a.duracion, a.precio, a.capacidad, a.fechaInicial, a.fechaFinal "
                +
                "FROM asesorias a " +
                "JOIN cursos c ON a.idCurso = c.idCurso " +
                "JOIN categoriacursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso " +
                "JOIN usuarios u ON a.idUsuario = u.idUsuario " +
                "JOIN profesores p ON a.idProfesor = p.idProfesor " +
                "WHERE a.idAsesoria = ?";
        List<Asesorias> results = jdbcTemplate.query(sql, getRowMapper(), id);
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public void save(Asesorias entity) {
        String checkSql = "SELECT COUNT(*) FROM profesores WHERE idProfesor = ?";
        @SuppressWarnings("deprecation")
        Integer count = jdbcTemplate.queryForObject(checkSql, new Object[] { entity.getIdProfesor() }, Integer.class);

        if (count != null && count > 0) {
            String sql = "INSERT INTO asesorias (idCurso, idUsuario, idProfesor, tema, descripcion, duracion, precio, capacidad, fechaInicial, fechaFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                jdbcTemplate.update(sql, entity.getIdCurso(), entity.getIdUsuario(),
                        entity.getIdProfesor(), entity.getTema(),
                        entity.getDescripcion(),
                        Time.valueOf(entity.getDuracion()), entity.getPrecio(), entity.getCapacidad(),
                        entity.getFechaInicial(),
                        entity.getFechaFinal());
            } catch (DataIntegrityViolationException e) {
                System.out.println("Error insertando asesoria : " + e);
                throw e;
            }
        } else {
            throw new IllegalArgumentException(
                    "El idProfesor " + entity.getIdProfesor() + " no existe en la tabla profesores.");
        }
    }

    @Override
    public void update(Asesorias entity) {
        String sql = "UPDATE asesorias SET idCurso = ?, idUsuario = ?, idProfesor = ?, tema = ?, descripcion = ?, duracion = ?, precio = ?, capacidad = ?, fechaInicial = ?, fechaFinal = ? WHERE idAsesoria = ?";
        jdbcTemplate.update(sql, entity.getIdCurso(), entity.getIdUsuario(), entity.getIdProfesor(), entity.getTema(),
                entity.getDescripcion(),
                Time.valueOf(entity.getDuracion()), entity.getPrecio(), entity.getCapacidad(), entity.getFechaInicial(),
                entity.getFechaFinal(), entity.getIdAsesoria());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM asesorias WHERE idAsesoria = ?";
        jdbcTemplate.update(sql, id);
    }
}
package com.example.demo.dao;

import com.example.demo.model.Cursos;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CursosDaoImpl extends CrudDaoImpl<Cursos, Long> {

    @Override
    protected String getTableName() {
        return "cursos";
    }

    @Override
    protected RowMapper<Cursos> getRowMapper() {
        return (rs, rowNum) -> {
            Cursos curso = new Cursos();
            curso.setIdCurso(rs.getLong("idCurso"));
            curso.setNombreCurso(rs.getString("curso"));
            curso.setImagenCurso(rs.getString("imagenCurso"));
            curso.setCategoriaCurso(rs.getString("categoriaCurso"));
            return curso;
        };
    }

    public List<Cursos> findAllWithCategoriaNombre() {
        String sql = "SELECT c.idCurso, c.curso, c.imagenCurso, cc.categoriaCurso " +
                "FROM cursos c " +
                "INNER JOIN categoriaCursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso";
        return jdbcTemplate.query(sql, getRowMapper());
    }
}
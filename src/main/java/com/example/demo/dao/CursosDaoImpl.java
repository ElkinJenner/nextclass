package com.example.demo.dao;

import com.example.demo.model.Cursos;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class CursosDaoImpl extends CrudDaoImpl<Cursos, Long> {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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

    public List<Cursos> findAllWithCategoriaNombre(int offset, int limit) {
        String sql = "SELECT c.idCurso, c.curso, c.imagenCurso, cc.categoriaCurso " +
                "FROM cursos c " +
                "INNER JOIN categoriaCursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso " +
                "LIMIT :limit OFFSET :offset";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("limit", limit);
        params.addValue("offset", offset);

        return namedParameterJdbcTemplate.query(sql, params, getRowMapper());
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM cursos";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return (count != null) ? count : 0;
    }
}
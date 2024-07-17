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
            curso.setIdCategoriaCurso(rs.getLong("idCategoriaCurso"));
            curso.setNombreCurso(rs.getString("curso"));
            curso.setImagenCurso(rs.getString("imagenCurso"));
            return curso;
        };
    }

    @Override
    public List<Cursos> findAll() {
        String sql = "SELECT idCurso, idCategoriaCurso, curso, imagenCurso FROM cursos";
        return namedParameterJdbcTemplate.query(sql, getRowMapper());
    }

    public List<Cursos> findAllWithCategoriaNombre(int offset, int limit) {
        String sql = "SELECT c.idCurso, cc.idCategoriaCurso, c.curso, c.imagenCurso " +
                "FROM cursos c " +
                "INNER JOIN categoriacursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso " +
                "ORDER BY c.curso ASC " +
                "LIMIT :limit OFFSET :offset";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("limit", limit);
        params.addValue("offset", offset);

        return namedParameterJdbcTemplate.query(sql, params, getRowMapper());
    }

    public List<Cursos> findByCategoriaWithPagination(String categoria, int offset, int limit) {
        String sql = "SELECT c.idCurso, cc.idCategoriaCurso, c.curso, c.imagenCurso " +
                "FROM cursos c " +
                "INNER JOIN categoriacursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso " +
                "WHERE cc.categoriaCurso = :categoria " +
                "ORDER BY c.curso ASC " +
                "LIMIT :limit OFFSET :offset";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("categoria", categoria);
        params.addValue("limit", limit);
        params.addValue("offset", offset);

        return namedParameterJdbcTemplate.query(sql, params, getRowMapper());
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM cursos";
        Integer count = namedParameterJdbcTemplate.getJdbcTemplate().queryForObject(sql, Integer.class);
        return (count != null) ? count : 0;
    }

    public int countByCategoria(String categoria) {
        String sql = "SELECT COUNT(*) FROM cursos c " +
                "INNER JOIN categoriacursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso " +
                "WHERE cc.categoriaCurso = :categoria";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("categoria", categoria);

        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return (count != null) ? count : 0;
    }
}
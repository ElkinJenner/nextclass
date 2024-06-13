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

    @Autowired // Inyecta automáticamente la instancia de NamedParameterJdbcTemplate
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Método para obtener el nombre de la tabla
    @Override
    protected String getTableName() {
        return "cursos";
    }

    // Método para mapear las filas de la base de datos a objetos de tipo Cursos
    @Override
    protected RowMapper<Cursos> getRowMapper() {
        return (rs, rowNum) -> {
            Cursos curso = new Cursos();
            curso.setIdCurso(rs.getLong("idCurso")); // Mapea el campo idCurso
            curso.setNombreCurso(rs.getString("curso")); // Mapea el campo curso
            curso.setImagenCurso(rs.getString("imagenCurso")); // Mapea el campo imagenCurso
            curso.setCategoriaCurso(rs.getString("categoriaCurso")); // Mapea el campo categoriaCurso
            return curso;
        };
    }

    // Método para obtener todos los cursos con sus categorías con paginación
    public List<Cursos> findAllWithCategoriaNombre(int offset, int limit) {
        String sql = "SELECT c.idCurso, c.curso, c.imagenCurso, cc.categoriaCurso " +
                "FROM cursos c " +
                "INNER JOIN categoriaCursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso " +
                "LIMIT :limit OFFSET :offset";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("limit", limit); // Establece el límite de registros a obtener
        params.addValue("offset", offset); // Establece el desplazamiento de registros

        return namedParameterJdbcTemplate.query(sql, params, getRowMapper());
    }

    // Método para obtener cursos por categoría con paginación
    public List<Cursos> findByCategoriaWithPagination(String categoria, int offset, int limit) {
        String sql = "SELECT c.idCurso, c.curso, c.imagenCurso, cc.categoriaCurso " +
                "FROM cursos c " +
                "INNER JOIN categoriaCursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso " +
                "WHERE cc.categoriaCurso = :categoria " +
                "LIMIT :limit OFFSET :offset";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("categoria", categoria); // Establece el filtro de categoría
        params.addValue("limit", limit); // Establece el límite de registros a obtener
        params.addValue("offset", offset); // Establece el desplazamiento de registros

        return namedParameterJdbcTemplate.query(sql, params, getRowMapper());
    }

    // Método para contar el total de registros en la tabla cursos
    public int count() {
        String sql = "SELECT COUNT(*) FROM cursos";
        Integer count = namedParameterJdbcTemplate.getJdbcTemplate().queryForObject(sql, Integer.class);
        return (count != null) ? count : 0; // Devuelve el conteo o 0 si es nulo
    }

    // Método para contar el total de registros en la tabla cursos filtrados por
    // categoría
    public int countByCategoria(String categoria) {
        String sql = "SELECT COUNT(*) FROM cursos c " +
                "INNER JOIN categoriaCursos cc ON c.idCategoriaCurso = cc.idCategoriaCurso " +
                "WHERE cc.categoriaCurso = :categoria";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("categoria", categoria); // Establece el filtro de categoría

        Integer count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        return (count != null) ? count : 0; // Devuelve el conteo o 0 si es nulo
    }
}
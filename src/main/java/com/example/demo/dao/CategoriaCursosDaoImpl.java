package com.example.demo.dao;

import com.example.demo.model.CategoriaCursos;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaCursosDaoImpl extends CrudDaoImpl<CategoriaCursos, Integer> {

    @Override
    protected String getTableName() {
        return "categoriaCursos";
    }

    @Override
    protected RowMapper<CategoriaCursos> getRowMapper() {
        return (rs, rowNum) -> {
            CategoriaCursos categoriaCursos = new CategoriaCursos();
            categoriaCursos.setIdCategoriaCurso(rs.getInt("idCategoriaCurso"));
            categoriaCursos.setCategoriaCurso(rs.getString("categoriaCurso"));
            return categoriaCursos;
        };
    }
}
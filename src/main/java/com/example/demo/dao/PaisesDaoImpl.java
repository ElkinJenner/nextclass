package com.example.demo.dao;

import com.example.demo.model.Paises;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PaisesDaoImpl extends CrudDaoImpl<Paises, Integer> {
    // Método para obtener el nombre de la tabla
    @Override
    protected String getTableName() {
        return "paises";
    }
    // Método para capturar todos los campos de la clase modelo
    @Override
    protected RowMapper<Paises> getRowMapper() {
        return (rs, rowNum) -> {
            Paises paises = new Paises();
            paises.setIdPais(rs.getLong("idPais"));
            paises.setPais(rs.getString("pais"));
            return paises;
        };
    }
    
}

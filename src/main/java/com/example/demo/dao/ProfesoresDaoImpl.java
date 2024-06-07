package com.example.demo.dao;
import com.example.demo.model.Profesores;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesoresDaoImpl extends CrudDaoImpl<Profesores,Long>{
    // Método para obtener el nombre de la tabla
  @Override
    protected String getTableName() {
        return "profesores";
    }
    
    // Método para mapear filas de resultados de la base de datos a objetos
    @Override
    protected RowMapper<Profesores> getRowMapper() {
        return new RowMapper<Profesores>() {
            @Override
            public Profesores mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                Profesores profesores = new Profesores();
                profesores.setIdProfesor(rs.getLong("idProfesor"));
                profesores.setIdUsuario(rs.getLong("idUsuario"));
                profesores.setPermiso(rs.getString("permiso"));
                profesores.setProfesion(rs.getString("profesion"));
                profesores.setDescripcion(rs.getString("descripcion"));
                return profesores;
            }
        };
    }
    
    // Método para guardar un nuevo profesor en la base de datos, tabla Profesores
    @Override
    public void save(Profesores entity) {
        String sql = "INSERT INTO profesores (idUsuario, permiso, profesion, descripcion) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getIdUsuario(), entity.getPermiso(), entity.getProfesion(), entity.getDescripcion());
    }
    
    // Método para actualizar un nuevo profesor en la base de datos, tabla Profesores
    @Override
    public void update(Profesores entity) {
        String sql = "UPDATE profesores SET idUsuario = ?, permiso = ?, profesion = ?, descripcion = ? WHERE idProfesor = ?";
        jdbcTemplate.update(sql, entity.getIdUsuario(), entity.getPermiso(), entity.getProfesion(), entity.getDescripcion(), entity.getIdProfesor());
    }
}

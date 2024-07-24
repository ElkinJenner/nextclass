package com.example.demo.dao;
//Importacion de librerias
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Estudiantes;

@Repository
public class EstudiantesDaoImpl extends CrudDaoImpl<Estudiantes,Long>{
    // Método para obtener el nombre de la tabla
    @Override
    protected String getTableName() {
        return "cursos";
    }
    
    // Método para mapear filas de resultados de la base de datos a objetos
    @Override
    protected RowMapper<Estudiantes> getRowMapper() {
        return new RowMapper<Estudiantes>() {
            @Override
            public Estudiantes mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException{
                Estudiantes estudiantes = new Estudiantes();
                estudiantes.setIdEstudiante(rs.getLong("idEstudiante"));
                estudiantes.setIdUsuario(rs.getLong("idUsuario"));
                estudiantes.setNivelAcademico(rs.getString("nivelAcademico"));
                estudiantes.setFotoPerfil(rs.getString("fotoPerfil"));
                return estudiantes;
            }
        };
    }
    
    // Método para guardar un nuevo estudiante en la base de datos
    @Override
    public void save(Estudiantes entity) {
        String sql = "INSERT INTO Estudiantes (idUsuario, nivelAcademico) VALUES (?, ?)";
        jdbcTemplate.update(sql, entity.getIdUsuario(), entity.getNivelAcademico());
    }
    // Método para actualizar un nuevo estudiante en la base de datos
    @Override
    public void update(Estudiantes entity) {
        String sql = "UPDATE Estudiantes SET idUsuario = ?, nivelAcademico = ? WHERE idEstudiante = ?";
        jdbcTemplate.update(sql, entity.getIdUsuario(), entity.getNivelAcademico(), entity.getIdEstudiante());
    }
    // Método para eliminar un estudiante atravez de su identificador ID
    @Override
    public void deleteById(Long id){
        String sql= "DELELTE FROM estudiantes WHERE idEstudiante";
        jdbcTemplate.update(sql, id);
    }
}

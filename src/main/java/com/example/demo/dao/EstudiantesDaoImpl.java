package com.example.demo.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Estudiantes;

@Repository
public class EstudiantesDaoImpl extends CrudDaoImpl<Estudiantes,Long>{
    @Override
    protected String getTableName() {
        return "cursos";
    }

    @Override
    protected RowMapper<Estudiantes> getRowMapper() {
        return new RowMapper<Estudiantes>() {
            @Override
            public Estudiantes mapRow(ResultSet rs, int rowNum) throws SQLException{
                Estudiantes estudiantes = new Estudiantes();
                estudiantes.setIdEstudiante(rs.getLong("idEstudiante"));
                estudiantes.setIdUsuario(rs.getLong("idUsuario"));
                estudiantes.setNivelAcademico(rs.getString("nivelAcademico"));
                return estudiantes;
            }
        };
    }
    @Override
    public void save(Estudiantes entity) {
        String sql = "INSERT INTO Estudiantes (idUsuario, nivelAcademico) VALUES (?, ?)";
        jdbcTemplate.update(sql, entity.getIdUsuario(), entity.getNivelAcademico());
    }

    @Override
    public void update(Estudiantes entity) {
        String sql = "UPDATE Estudiantes SET idUsuario = ?, nivelAcademico = ? WHERE idEstudiante = ?";
        jdbcTemplate.update(sql, entity.getIdUsuario(), entity.getNivelAcademico(), entity.getIdEstudiante());
    }

    @Override
    public void deleteById(Long id){
        String sql= "DELELTE FROM estudiantes WHERE idEstudiante";
        jdbcTemplate.update(sql, id);
    }
}

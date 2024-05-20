package com.example.demo.dao;
import com.example.demo.model.Cursos;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CursosDaoImpl extends CrudDaoImpl<Cursos, Long> {

    @Override
    protected String getTableName() {
        return "Cursos";
    }

    @Override
    protected RowMapper<Cursos> getRowMapper() {
        return new RowMapper<Cursos>() {
            @Override
            public Cursos mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cursos curso = new Cursos();
                curso.setIdCurso(rs.getLong("idCurso"));
                curso.setIdCategoriaCurso(rs.getLong("idCategoriaCurso"));
                curso.setNombreCurso(rs.getString("nombreCurso"));
                curso.setImagenCurso(rs.getString("imagenCurso"));
                return curso;
            }
        };
    }

    @Override
    public void save(Cursos entity) {
        String sql = "INSERT INTO Cursos (idCategoriaCurso, nombreCurso, imagenCurso) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, entity.getIdCategoriaCurso(), entity.getNombreCurso(), entity.getImagenCurso());
    }

    @Override
    public void update(Cursos entity) {
        String sql = "UPDATE Cursos SET idCategoriaCurso = ?, nombreCurso = ?, imagenCurso = ? WHERE idCurso = ?";
        jdbcTemplate.update(sql, entity.getIdCategoriaCurso(), entity.getNombreCurso(), entity.getImagenCurso(), entity.getIdCurso());
    }
}
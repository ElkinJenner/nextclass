package com.example.demo.dao;
//import com.example.demo.dao.UsuariosDao;
import com.example.demo.model.Usuarios;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class UsuariosDaoImpl extends CrudDaoImpl<Usuarios, Long> {

    @Override
    protected String getTableName() {
        return "usuarios";
    }

    @Override
    protected RowMapper<Usuarios> getRowMapper() {
        return new RowMapper<Usuarios>() {
            @Override
            public Usuarios mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                Usuarios usuario = new Usuarios();
                usuario.setIdUsuario(rs.getLong("idUsuario"));
                usuario.setTipoUsuario(rs.getString("tipoUsuario"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFotoPerfil(rs.getString("fotoPerfil"));
                usuario.setCodUsuario(rs.getString("codUsuario"));
                usuario.setTelefono(rs.getInt("telefono"));
                usuario.setIdPais(rs.getLong("idpais"));
                usuario.setFechaRegistro(rs.getDate("fechaRegistro"));
                return usuario;
            }
        };
    }

    @Override
    public void save(Usuarios entity) {
        String sql = "INSERT INTO Usuarios (tipoUsuario, nombres, apellidos, usuario, contrasena, email, fotoPerfil, codUsuario, telefono, idPais, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getTipoUsuario(), entity.getNombres(), entity.getApellidos(),
                entity.getUsuario(), entity.getContrasena(), entity.getEmail(), entity.getFotoPerfil(),
                entity.getCodUsuario(), entity.getTelefono(), entity.getIdPais(), entity.getFechaRegistro());
    }

    @Override
    public void update(Usuarios entity) {
        String sql = "UPDATE Usuarios SET tipoUsuario = ?, nombres = ?, apellidos = ?, usuario = ?, contrasena = ?, email = ?, fotoPerfil = ?, codUsuario = ?, telefono = ?, idPais = ?, fechaRegistro = ? WHERE idUsuario = ?";
        jdbcTemplate.update(sql, entity.getTipoUsuario(), entity.getNombres(), entity.getApellidos(),
                entity.getUsuario(), entity.getContrasena(), entity.getEmail(), entity.getFotoPerfil(),
                entity.getCodUsuario(), entity.getTelefono(), entity.getIdPais(), entity.getFechaRegistro(),
                entity.getIdUsuario());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM Usuarios WHERE idUsuario = ?";
        jdbcTemplate.update(sql, id);
    }
}
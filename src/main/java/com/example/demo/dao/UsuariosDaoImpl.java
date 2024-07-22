package com.example.demo.dao;

import com.example.demo.model.Usuarios;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuariosDaoImpl extends CrudDaoImpl<Usuarios, Long> {
    // Método para obtener el nombre de la tabla
    @Override
    protected String getTableName() {
        return "usuarios";
    }
    // Método para mapear filas de resultados de la base de datos a objetos Usuarios
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
                usuario.setIdPais(rs.getLong("idPais"));
                usuario.setNombrePais(rs.getString("pais"));
                usuario.setUbicacion(rs.getString("ubicacion"));
                usuario.setFechaRegistro(rs.getDate("fechaRegistro"));
                return usuario;
            }
        };
    }
    // Método para encontrar todos los usuarios en la base de datos
    @Override
    public List<Usuarios> findAll() {
        String sql = "SELECT u.*, p.pais FROM usuarios u INNER JOIN paises p ON u.idPais = p.idPais";
        return jdbcTemplate.query(sql, getRowMapper());
    }
    // Método para encontrar un usuario por su ID
    @Override
    public Usuarios findById(Long id) {
        String sql = "SELECT u.*, p.pais FROM usuarios u INNER JOIN paises p ON u.idPais = p.idPais WHERE u.idUsuario = ?";
        List<Usuarios> results = jdbcTemplate.query(sql, getRowMapper(), id);
        return results.isEmpty() ? null : results.get(0);
    }
    // Método para registrar un nuevo usuario en la base de datos
    @Override
    public void save(Usuarios entity) {
        String sql = "INSERT INTO usuarios (tipoUsuario, nombres, apellidos, usuario, contrasena, email, fotoPerfil, codUsuario, telefono, idPais, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getTipoUsuario(), entity.getNombres(), entity.getApellidos(),
                entity.getUsuario(), entity.getContrasena(), entity.getEmail(), entity.getFotoPerfil(),
                entity.getCodUsuario(), entity.getTelefono(), entity.getIdPais(), entity.getFechaRegistro());
    }
    // Método para actualizar un usuario existente en la base de datos
    @Override
    public void update(Usuarios entity) {
        String sql = "UPDATE usuarios SET tipoUsuario = ?, nombres = ?, apellidos = ?, usuario = ?, contrasena = ?, email = ?, fotoPerfil = ?, codUsuario = ?, telefono = ?, idPais = ?, fechaRegistro = ? WHERE idUsuario = ?";
        jdbcTemplate.update(sql, entity.getTipoUsuario(), entity.getNombres(), entity.getApellidos(),
                entity.getUsuario(), entity.getContrasena(), entity.getEmail(), entity.getFotoPerfil(),
                entity.getCodUsuario(), entity.getTelefono(), entity.getIdPais(), entity.getFechaRegistro(),
                entity.getIdUsuario());
    }
    // Método para eliminar un usuario por su ID
    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM usuarios WHERE idUsuario = ?";
        jdbcTemplate.update(sql, id);
    }
    // Método para encontrar un usuario por su correo electrónico y contraseña
    public Usuarios findByEmailAndPassword(String email, String password) {
        String sql = "SELECT u.*, p.pais FROM usuarios u INNER JOIN paises p ON u.idPais = p.idPais WHERE u.email = ? AND u.contrasena = ?";
        List<Usuarios> results = jdbcTemplate.query(sql, getRowMapper(), email, password);
        return results.isEmpty() ? null : results.get(0);
    }


    // Método para encontrar el idProfesor a partir del idUsuario usando JOIN
    public Long findIdProfesorByIdUsuario(Long idUsuario) {
        String sql = "SELECT p.idProfesor FROM profesores p INNER JOIN usuarios u ON p.idUsuario = u.idUsuario WHERE u.idUsuario = ?";
        List<Long> results = jdbcTemplate.query(sql, (rs, rowNum) -> rs.getLong("idProfesor"), idUsuario);
        return results.isEmpty() ? null : results.get(0);
    }




}
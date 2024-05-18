package com.example.demo.dao;
import com.example.demo.model.*;
import org.springframework.data.repository.CrudRepository;
public interface UserDao extends CrudRepository <Usuarios, Long>{
    Usuarios findByEmail(String email);
}

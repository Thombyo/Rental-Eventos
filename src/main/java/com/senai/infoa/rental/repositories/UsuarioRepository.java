package com.senai.infoa.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.infoa.rental.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    @Query(value = "select * from usuario where email = :email and senha = :senha", nativeQuery = true)
    public Usuario findByUsuario(String email, String senha);

    Usuario findByEmail(String email);
}

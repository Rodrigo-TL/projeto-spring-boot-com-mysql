package com.example.projetospringbootcommysql.repository;

import com.example.projetospringbootcommysql.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

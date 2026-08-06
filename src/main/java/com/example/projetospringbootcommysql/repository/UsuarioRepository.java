package com.example.projetospringbootcommysql.repository;

import com.example.projetospringbootcommysql.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}

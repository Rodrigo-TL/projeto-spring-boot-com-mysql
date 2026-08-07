package com.example.projetospringbootcommysql.repository;

import com.example.projetospringbootcommysql.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}

package com.example.projetospringbootcommysql.controller;

import com.example.projetospringbootcommysql.entity.Usuario;
import com.example.projetospringbootcommysql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Permite requisições do front-end
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        // retornar todos os valores da tabela
        // usuario
        return repository.findAll();
    }
}

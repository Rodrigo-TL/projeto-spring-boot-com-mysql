package com.example.projetospringbootcommysql.controller;

import com.example.projetospringbootcommysql.entity.UsuarioEntity;
import com.example.projetospringbootcommysql.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Permite requisições HTTP do FRONT-END
public class UsuarioController {

    @Autowired // ela simplifica uma insntância.
    private UsuarioRepository comandos;
    //É como se escrevesse:
    // UsuarioRepository comandos = new UsuarioRepository();
    // automáticamente

    @PostMapping
    public UsuarioEntity salvarUsuario(
            @RequestBody UsuarioEntity usuario){
        return comandos.save(usuario);
        // INSERT INTO usuario_entity VALUES("João", "joao@gmail.com");
    }

    @GetMapping
    public List<UsuarioEntity> listarUsuarios(){
        // retornar todos os valores da tabela
        // usuario_entity
        return comandos.findAll();
        // SELECT * FROM usuario_entity;
    }

    @PutMapping("/{id}")
    public UsuarioEntity atualizarUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioEntity usuarioAtualizado) {

        UsuarioEntity usuarioAtual = comandos.findById(id).orElseThrow();

        usuarioAtual.setNome(usuarioAtualizado.getNome());
        usuarioAtual.setEmail(usuarioAtualizado.getEmail());

        return comandos.save(usuarioAtual);
    }

}


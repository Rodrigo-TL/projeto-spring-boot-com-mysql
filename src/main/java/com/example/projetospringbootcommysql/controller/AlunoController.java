package com.example.projetospringbootcommysql.controller;

import com.example.projetospringbootcommysql.entity.AlunoEntity;
import com.example.projetospringbootcommysql.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*") // <-- Adicione esta linha aqui
public class AlunoController {

    @Autowired
    private AlunoRepository comandos;

    // 1. POST - Cadastrar Aluno
    @PostMapping
    public AlunoEntity cadastrarAluno(@RequestBody AlunoEntity novoAluno) {
        return comandos.save(novoAluno);
    }

    // 2. GET - Listar Todos os Alunos
    @GetMapping
    public List<AlunoEntity> listarAlunos() {
        return comandos.findAll();
    }

    // 3. PUT - Atualizar Aluno por ID
    @PutMapping("/{id}")
    public AlunoEntity atualizarAluno(@PathVariable Long id, @RequestBody AlunoEntity alunoAtualizado) {
        AlunoEntity alunoAtual = comandos.findById(id).orElseThrow();

        alunoAtual.setNome(alunoAtualizado.getNome());
        alunoAtual.setIdade(alunoAtualizado.getIdade());
        alunoAtual.setRegistroAluno(alunoAtualizado.getRegistroAluno());
        alunoAtual.setEmailInstitucional(alunoAtualizado.getEmailInstitucional());
        alunoAtual.setTurma(alunoAtualizado.getTurma());
        alunoAtual.setPeriodo(alunoAtualizado.getPeriodo());
        alunoAtual.setApresentacao(alunoAtualizado.getApresentacao());

        return comandos.save(alunoAtual);
    }

    // 4. DELETE - Deletar Aluno por ID
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        AlunoEntity aluno = comandos.findById(id).orElseThrow();
        comandos.delete(aluno);
    }
}

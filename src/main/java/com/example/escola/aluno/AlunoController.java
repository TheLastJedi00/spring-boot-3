package com.example.escola.aluno;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno postAluno(@RequestBody Aluno a){
        return this.alunoService.salvar(a);
    }

    @GetMapping
    public List<Aluno> listarTodos(){
        return this.alunoService.listarAlunos();
    }

//  GET api.link.com/alunos/1
    @GetMapping("/{id}")
    public Aluno getById(@PathVariable("id") Long id){
        return this.alunoService.getById(id);
    }

    @PutMapping("/{id}")
    public Aluno putAluno(@PathVariable("id") Long id,@RequestBody Aluno a){
        return this.alunoService.atualizarAluno(id, a);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable("id") Long id){
        this.alunoService.apagarAluno(id);
    }
}

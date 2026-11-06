package com.example.escola.turmas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public Turma postTurma(@RequestBody TurmaDTO t){
        return this.turmaService.criarTurma(t);
    }

    @GetMapping
    public List<Turma> getAll(){
        return this.turmaService.listarTodas();
    }

    @PutMapping("/{idTurma}")
    public Turma adicionarAluno(@PathVariable("idTurma") Long idTurma, @RequestBody Long idAluno){
        return this.turmaService.adicionarAluno(idTurma, idTurma);
    }
}

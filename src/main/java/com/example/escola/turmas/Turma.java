package com.example.escola.turmas;

import com.example.escola.aluno.Aluno;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Aluno> alunos;

    public Turma(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Turma() {

    }
}

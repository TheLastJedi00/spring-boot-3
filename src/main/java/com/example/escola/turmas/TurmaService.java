package com.example.escola.turmas;

import com.example.escola.aluno.Aluno;
import com.example.escola.aluno.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private RepositoryMethodInvocationListener repositoryMethodInvocationListener;

    public Turma criarTurma(TurmaDTO t){
        List<Aluno> listaAlunos = new ArrayList<>();

        for (int i = 0; i < t.alunosId().size(); i++) {
            Aluno aluno = this.alunoService.getById(t.alunosId().get(i));
            listaAlunos.add(aluno);
        }

        Turma turma = new Turma(listaAlunos);
        return this.turmaRepository.save(turma);
    }

    public List<Turma> listarTodas(){
        return this.turmaRepository.findAll();
    }

    public Turma adicionarAluno(Long idTurma, Long idAluno) {
        boolean hasTurma = this.turmaRepository.findById(idTurma).isPresent();
        if(hasTurma){
            Turma t = this.turmaRepository.findById(idTurma).get();
            Aluno a = this.alunoService.getById(idAluno);
            t.getAlunos().add(a);
            return this.turmaRepository.save(t);
        } else {
            return null;
        }
    }
}

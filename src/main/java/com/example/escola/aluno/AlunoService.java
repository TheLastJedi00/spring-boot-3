package com.example.escola.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno a){
        return this.alunoRepository.save(a);
    }

    public List<Aluno> listarAlunos(){
        return this.alunoRepository.findAll();
    }

    public Aluno getById(Long id) {
        boolean hasAluno = this.alunoRepository.findById(id).isPresent();
        if(hasAluno){
            return this.alunoRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Aluno getById(int id) {
        boolean hasAluno = this.alunoRepository.findById(Integer.toUnsignedLong(id)).isPresent();
        if(hasAluno){
            return this.alunoRepository.findById(Integer.toUnsignedLong(id)).get();
        } else {
            return null;
        }
    }

    public Aluno atualizarAluno(Long id, Aluno a) {
        boolean hasAluno = this.alunoRepository.findById(id).isPresent();
        if (hasAluno){
            Aluno alunoEncontrado = this.alunoRepository.findById(id).get();
            alunoEncontrado.setNome(a.getNome());
            alunoEncontrado.setIdade(a.getIdade());
            alunoEncontrado.setTelefone(a.getTelefone());
            alunoEncontrado.setDataMatricula(a.getDataMatricula());
            return this.alunoRepository.save(alunoEncontrado);
        } else {
            return null;
        }
    }

    public void apagarAluno(Long id) {
        boolean hasAluno = this.alunoRepository.findById(id).isPresent();
        if(hasAluno){
            this.alunoRepository.deleteById(id);
        } else {
            System.out.println("Aluno não encontrado");
        }
    }
}

package com.ufc.br.service;

import com.ufc.br.model.Aluno;
import com.ufc.br.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void save(Aluno aluno/*, MultipartFile image*/){
        alunoRepository.save(aluno);

      //  String caminho = "src/main/resources/static/images/" + aluno.getNome() + ".png";
    }

    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id){
        return alunoRepository.getOne(id);
    }

    public Aluno findByMatricula(String matricula){
        return alunoRepository.findByMatricula(matricula);
    }

    public void delete(Long id){
        alunoRepository.deleteById(id);
    }

}

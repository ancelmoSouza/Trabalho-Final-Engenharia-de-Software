package com.ufc.br.service;

import com.ufc.br.model.Aluno;
import com.ufc.br.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void save(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id){
        return alunoRepository.getOne(id);
    }

    public void delete(Long id){
        alunoRepository.deleteById(id);
    }



}

package com.ufc.br.service;

import com.ufc.br.model.Turma;
import com.ufc.br.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public void save(Turma turma){
        this.turmaRepository.save(turma);
    }

    public List<Turma> listarTurmas(){
        return this.turmaRepository.findAll();
    }

    public Turma findById(Long id){
        return this.turmaRepository.getOne(id);
    }

    public void delete(Long id){
        this.turmaRepository.deleteById(id);
    }

}

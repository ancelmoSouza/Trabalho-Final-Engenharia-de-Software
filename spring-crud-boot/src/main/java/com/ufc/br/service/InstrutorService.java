package com.ufc.br.service;

import com.ufc.br.model.Instrutor;
import com.ufc.br.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public void save(Instrutor instrutor){
        this.instrutorRepository.save(instrutor);
    }

    public List<Instrutor> listarInstrutores(){
        return this.instrutorRepository.findAll();
    }

    public Instrutor findById(Long id){
        return instrutorRepository.getOne(id);
    }

    public Instrutor findByMatricula(String matricula){
        return instrutorRepository.findByMatricula(matricula);
    }

    public void delete(Long id){
        this.instrutorRepository.deleteById(id);
    }


}

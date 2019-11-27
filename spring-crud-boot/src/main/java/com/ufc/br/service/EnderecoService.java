package com.ufc.br.service;

import com.ufc.br.model.Endereco;
import com.ufc.br.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void save(Endereco endereco){
        this.enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos(){
        return this.enderecoRepository.findAll();
    }

    public Endereco findById(Long id){
        return this.enderecoRepository.getOne(id);
    }

    public void delete(Long id){
        this.enderecoRepository.deleteById(id);
    }

}

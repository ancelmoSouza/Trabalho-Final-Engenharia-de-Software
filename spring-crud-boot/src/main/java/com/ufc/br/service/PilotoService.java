package com.ufc.br.service;

import com.ufc.br.model.Piloto;
import com.ufc.br.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    public void save(Piloto piloto){
        this.pilotoRepository.save(piloto);
    }

    public List<Piloto> listarPilotos(){
        return this.pilotoRepository.findAll();
    }

    public Piloto findById(Long id){
        return this.pilotoRepository.getOne(id);
    }

    public void delete(Long id){
        this.pilotoRepository.deleteById(id);
    }


}

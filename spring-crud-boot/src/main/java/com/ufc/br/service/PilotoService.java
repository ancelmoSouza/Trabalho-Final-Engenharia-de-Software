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
        pilotoRepository.save(piloto);
    }

    public void delete(String breve){
        pilotoRepository.deleteByBreve(breve);
    }

    public List<Piloto> listarPilotos(){
        return pilotoRepository.findAll();
    }

    public Piloto findByBreve(String breve){
        return pilotoRepository.findByBreve(breve);
    }


}

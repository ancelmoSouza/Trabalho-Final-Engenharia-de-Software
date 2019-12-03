package com.ufc.br.service;

import com.ufc.br.model.Frequencia;
import com.ufc.br.repository.FrequenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrequenciaService {

    @Autowired
    private FrequenciaRepository frequenciaRepository;

    public void save(Frequencia frequencia){
        this.frequenciaRepository.save(frequencia);
    }

    public List<Frequencia> listarFrequencia(){
        return this.frequenciaRepository.findAll();
    }

    public Frequencia findById(Long id){
        return this.frequenciaRepository.getOne(id);
    }
}

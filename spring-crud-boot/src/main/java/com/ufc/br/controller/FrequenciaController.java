package com.ufc.br.controller;

import com.ufc.br.model.Frequencia;
import com.ufc.br.service.FrequenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frequencia")
public class FrequenciaController {

    @Autowired
    private FrequenciaService frequenciaService;

    @RequestMapping(value = "/verificar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void atualizarFrequencia(@PathVariable Long id){
        Frequencia f = frequenciaService.findById(id);
        f.setAulasPresent(f.getAulasPresent() + 1);

        frequenciaService.save(f);
    }
}

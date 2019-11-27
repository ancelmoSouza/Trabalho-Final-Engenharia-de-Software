package com.ufc.br.controller;

import com.ufc.br.model.Endereco;
import com.ufc.br.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    public void save(Endereco endereco){
        this.enderecoService.save(endereco);
    }

    public void delete(Endereco endereco){
        this.enderecoService.delete(endereco.getId());
    }

}

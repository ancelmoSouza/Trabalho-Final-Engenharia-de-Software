package com.ufc.br.controller;

import com.ufc.br.model.Piloto;
import com.ufc.br.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/piloto")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("FormularioPiloto");
        mv.addObject("piloto", new Piloto());

        return mv;
    }

    @RequestMapping("/salvar")
    public String salvar(Piloto piloto){
        this.pilotoService.save(piloto);

        return "OlaMundo";
    }
}

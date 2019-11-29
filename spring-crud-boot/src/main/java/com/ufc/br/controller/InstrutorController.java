package com.ufc.br.controller;

import com.ufc.br.model.Instrutor;
import com.ufc.br.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("FormularioInstrutor");
        mv.addObject("instrutor", new Instrutor());

        return mv;
    }

    @RequestMapping("/salvar")
    public String salvar(Instrutor instrutor){
        instrutor.setPapel("user_default");
        instrutorService.save(instrutor);

        return "OlaMundo";
    }
}

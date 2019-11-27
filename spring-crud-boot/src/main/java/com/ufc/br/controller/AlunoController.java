package com.ufc.br.controller;

import com.ufc.br.model.Aluno;
import com.ufc.br.model.Endereco;
import com.ufc.br.service.AlunoService;
import com.ufc.br.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private EnderecoService enderecoService;

    @RequestMapping("/olamundo")
    public String olamundo(){
        return "OlaMundo";
    }

    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("FormularioAluno");
        mv.addObject("aluno", new Aluno());

        return mv;
    }

    @RequestMapping("/salvar")
    public String salvar(Aluno aluno){
        alunoService.save(aluno);
        return "OlaMundo";
    }

}

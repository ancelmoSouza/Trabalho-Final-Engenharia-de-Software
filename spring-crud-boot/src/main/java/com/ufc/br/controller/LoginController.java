package com.ufc.br.controller;

import com.ufc.br.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("Login");

        return mv;
    }

    @RequestMapping("/logar")
    public String logar(Usuario user){

        return "redirect:/turma/listarTurmas";
    }
}

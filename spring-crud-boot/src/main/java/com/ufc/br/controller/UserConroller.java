package com.ufc.br.controller;

import com.ufc.br.model.Aluno;
import com.ufc.br.model.Instrutor;
import com.ufc.br.model.User;
import com.ufc.br.service.AlunoService;
import com.ufc.br.service.InstrutorService;
import com.ufc.br.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class UserConroller {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private PilotoService pilotoService;

    @RequestMapping("/form")
    public ModelAndView form(HttpSession session){
        ModelAndView mv = new ModelAndView("Login");
        mv.addObject("user", new User());

        return mv;
    }

    @RequestMapping("/logar")
    public String login(User user, HttpSession session){

        if(this.authoriseUser(user)){
           session.setAttribute("user", user);
           return "redirect:/turma/formMatricula";
        }else{
            return "Error";
        }

    }


    public boolean authoriseUser(User user) {
        if(user.getPapel().equals("user_default")){
            Instrutor instrutor = instrutorService.findByLogin(user.getLogin());

            if(instrutor == null) {
                return false;
            }else{
                if(!instrutor.getPassword().equals(user.getPassword())){
                    return false;
                }else{
                    return true;
                }
            }

        } else if(user.getPapel().equals("user_pilot")){
            //Lógica para guardar o user == 'piloto' na sessão e redirecionar p/ uma página home

        } else if (user.getPapel().equals("user_aluno")){
                Aluno a = alunoService.findByLogin(user.getLogin());

                if(a == null) {
                    return false;
                }else{
                    if(!a.getPassword().equals(user.getPassword())){
                        return false;
                    }else{
                        return true;
                    }
                }


        }

        return false;

    }
}

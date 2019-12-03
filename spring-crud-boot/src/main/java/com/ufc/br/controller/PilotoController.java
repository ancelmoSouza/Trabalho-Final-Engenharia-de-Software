package com.ufc.br.controller;

import com.ufc.br.model.Piloto;
import com.ufc.br.model.Turma;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.PilotoService;
import com.ufc.br.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/piloto")
public class PilotoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PilotoService pilotoService;


    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("FormularioPiloto");
        mv.addObject("piloto", new Piloto());

        return mv;
    }

    @RequestMapping("/salvar")
    public String salvar(Piloto piloto, HttpSession session){
        Usuario user = piloto.getUsuario();
        user.setUsername(piloto.getBreve());

        user.getPilotos().add(piloto);
        piloto.setUsuario(user);

        usuarioService.cadastrarUsuarioPiloto(user);
        pilotoService.save(piloto);

        return "redirect:/admin/listarPilotos";
    }
}

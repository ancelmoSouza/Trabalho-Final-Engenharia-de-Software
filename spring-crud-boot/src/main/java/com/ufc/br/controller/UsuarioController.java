package com.ufc.br.controller;

import com.ufc.br.model.*;
import com.ufc.br.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UsuarioController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private PilotoService pilotoService;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/home")
    public String admin(){
        return "adm";
    }

    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("UsuarioForm");
        mv.addObject("admin", new Usuario());

        return mv;
    }

    @RequestMapping("/salvar")
    public String salvar(Usuario user){
        usuarioService.cadastrarUsuarioAdmin(user);

        return "redirect:/admin/home";
    }

    @RequestMapping("/listarAlunos")
    public ModelAndView listarAlunos(){
        ModelAndView mv = new ModelAndView("ListarAlunos");
        List<Aluno> alunos = alunoService.listarAlunos();

        mv.addObject("alunos", alunos);

        return mv;
    }

    @RequestMapping("/listarInstrutores")
    public ModelAndView listarInstrutores(){
        ModelAndView mv = new ModelAndView("ListarInstrutores");
        List<Instrutor> listaInstrutores = instrutorService.listarInstrutores();

        mv.addObject("listaInstrutores", listaInstrutores);

        return mv;
    }

    @RequestMapping("/listarPilotos")
    public ModelAndView listarPilotos(){
        ModelAndView mv = new ModelAndView("ListarPilotos");
        List<Piloto> pilotos = pilotoService.listarPilotos();

        mv.addObject("listaPilotos", pilotos);

        return mv;
    }

    @RequestMapping("/listarTurmas")
    public ModelAndView listarTurmas(){
        ModelAndView mv = new ModelAndView("ListarTodasTurmas");
        List<Turma> turmas = turmaService.listarTurmas();

        mv.addObject("listaTurmas", turmas);
        return mv;
    }


    @RequestMapping("/homePage")
    public String redirectLoginPage(){
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = (UserDetails) auth;

        Usuario usuario = usuarioService.findByLogin(user.getUsername());

        if(usuario.getRoles().get(0).getPapel().equals("ROLE_ADMIN")){
            return "redirect:/admin/home";
        }

        if(usuario.getRoles().get(0).getPapel().equals("ROLE_INSTRUTOR")){
            return "redirect:/instrutor/listar";
        }

        if(usuario.getRoles().get(0).getPapel().equals("ROLE_ALUNO")){
            return "redirect:/turma/listarTurmas";
        }

        return "Error";

    }


}

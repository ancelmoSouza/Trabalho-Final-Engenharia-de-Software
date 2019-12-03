package com.ufc.br.controller;

import com.ufc.br.model.*;
import com.ufc.br.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private FrequenciaService frequenciaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private InstrutorService instrutorService;

    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("FormularioInstrutor");
        mv.addObject("instrutor", new Instrutor());

        return mv;
    }

    @RequestMapping("/listar")
    public ModelAndView listarTurmas(){
        ModelAndView mv = new ModelAndView("InstrutorHome");
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDetails user = (UserDetails) auth;
        Instrutor instrutor = instrutorService.findByMatricula(user.getUsername());
        List<Turma> turmas = instrutor.getTurmas();
        mv.addObject("listaTurmas", turmas);

        return mv;
    }


    @RequestMapping("/salvar")
    public String salvar(Instrutor instrutor){
        Usuario user = instrutor.getUsuario();
        user.setUsername(instrutor.getMatricula());

        user.getInstrutores().add(instrutor);
        instrutor.setUsuario(user);

        usuarioService.cadastrarUsuarioInstrutor(user);
        instrutorService.save(instrutor);

        return "redirect:/admin/listarInstrutores";
    }


    @RequestMapping("/listaralunosporturma")
    public ModelAndView listarAlunosTurma(){
        ModelAndView mv = new ModelAndView("ListagemAlunosFrequencia");

        List<Frequencia> frequencias = turmaService.findById(Long.valueOf(10)).getFrequencia();
        mv.addObject("listaFrequencia",frequencias);
        return mv;
    }

   public String home(){
        return "OlaMundo";
   }
}

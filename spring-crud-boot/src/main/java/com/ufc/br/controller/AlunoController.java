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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private FrequenciaService frequenciaService;

    @Autowired
    private UsuarioService usuarioService;

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
    public String salvar(Aluno aluno /*@RequestParam(value = "image") MultipartFile image*/){
        Usuario user = aluno.getUsuario();
        user.setUsername(aluno.getMatricula());

        Endereco endereco = aluno.getEndereco();
        endereco.getAlunos().add(aluno);
        user.getAlunos().add(aluno);

        aluno.setEndereco(endereco);
        aluno.setUsuario(user);

        usuarioService.cadastrarUsuarioAluno(user);
        enderecoService.save(endereco);
        alunoService.save(aluno);

        return "redirect:/admin/listarAlunos";
    }

    @RequestMapping("/perfil")
    public ModelAndView dadosAluno(){
        ModelAndView mv = new ModelAndView("PerfilAluno");

        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDetails user = (UserDetails) auth;
        Aluno aluno = alunoService.findByMatricula(user.getUsername());

        mv.addObject("aluno", aluno);

        return mv;
    }


}

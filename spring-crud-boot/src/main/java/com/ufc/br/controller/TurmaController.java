package com.ufc.br.controller;

import com.ufc.br.model.*;
import com.ufc.br.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Security;
import java.util.List;

@Controller
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private FrequenciaService frequenciaService;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private PilotoService pilotoServeice;

    @Autowired
    private AlunoService alunoService;

    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("FormularioTurma");

        Instrutor instrutor = new Instrutor();
        Piloto piloto = new Piloto();
        Turma turma = new Turma();

        turma.setInstrutor(instrutor);
        turma.setPiloto(piloto);

        mv.addObject("turma", new Turma());

        return mv;
    }

    @RequestMapping("/salvar")
    public String salavr(Turma turma/*, @RequestParam(value = "image") MultipartFile image*/){
        turma.setStatus(true);
        Instrutor instrutor = instrutorService.findByMatricula(turma.getInstrutor().getMatricula());
        Piloto piloto = pilotoServeice.findByBreve(turma.getPiloto().getBreve());

        instrutor.getTurmas().add(turma);
        piloto.getTurmas().add(turma);
        turma.setInstrutor(instrutor);
        turma.setPiloto(piloto);

        instrutorService.save(instrutor);
        pilotoServeice.save(piloto);
        this.turmaService.save(turma);

        return "redirect:/admin/listarTurmas";
    }

    @RequestMapping("/listarTurmas")
    public ModelAndView listarTurmas(){
        ModelAndView mv = new ModelAndView("ListagemTurmas");
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDetails user = (UserDetails) auth;
        Aluno aluno = alunoService.findByMatricula(user.getUsername());


        List<Turma> turmas = aluno.getTurmas();

        mv.addObject("listaDeTurmas", turmas);

        return mv;
    }

    @RequestMapping("/listarTurmas1")
    public ModelAndView listarTurmas1(){
        ModelAndView mv = new ModelAndView("ListagemTurmas1");

        List<Turma> turmas = turmaService.listarTurmas();
        mv.addObject("listaDeTurmas", turmas);

        return mv;
    }

    @RequestMapping("/concluir/{id}")
    public String concluir(@PathVariable Long id){
        //Obtendo a turma
        Turma turma = turmaService.findById(id);

        //Torna a turma ativa
        turma.setStatus(true);

        //Obter o usuário logado na sessão
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDetails user = (UserDetails) auth;
        Aluno aluno = alunoService.findByMatricula(user.getUsername());

        //Adicionando o aluno a lista de alunos da turma e a turma à lista de turmas do aluno
        aluno.getTurmas().add(turma);
        turma.getAlunos().add(aluno);

        //Incrementa em 1 o número de alunos matriculados na turma
        turma.setCurrentAlunos(turma.getCurrentAlunos() + 1);

        //Criar a frequência do aluno referente aquela turma
        Frequencia f = new Frequencia(aluno, turma);

        //Associa a frequência 'f' a turma específica e ao aluno
        aluno.getFrequencia().add(f);
        turma.getFrequencia().add(f);


        turmaService.save(turma);
        alunoService.save(aluno);
        frequenciaService.save(f);

        return "redirect:/turma/listarTurmas";
    }


    @RequestMapping("/info/{id}")
    public ModelAndView info(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("TurmaInfo");
        Turma turma = turmaService.findById(id);

        mv.addObject("turma", turma);
        return mv;
    }

    @RequestMapping("/infoAlu/{id}")
    public ModelAndView infoAlu(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("TurmaInfoAlu");
        Turma turma = turmaService.findById(id);

        mv.addObject("turma", turma);
        return mv;
    }

    @RequestMapping("/infoI/{id}")
    public ModelAndView infoI(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("TurmaInfoI");
        Turma turma = turmaService.findById(id);

        mv.addObject("turma", turma);
        return mv;
    }

}

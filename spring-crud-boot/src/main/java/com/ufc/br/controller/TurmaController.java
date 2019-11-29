package com.ufc.br.controller;

import com.ufc.br.model.*;
import com.ufc.br.service.AlunoService;
import com.ufc.br.service.InstrutorService;
import com.ufc.br.service.PilotoService;
import com.ufc.br.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/turma")
public class TurmaController {

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
        turma.setPiloto(this.pilotoServeice.findByBreve(turma.getPiloto().getLogin()));
        turma.setInstrutor(this.instrutorService.findByLogin(turma.getInstrutor().getLogin()));
        turma.setStatus(true);

        this.turmaService.save(turma);

        return "OlaMundo";
    }

    @RequestMapping("/listarTurmas")
    public ModelAndView listarTurmas(){
        ModelAndView mv = new ModelAndView("ListagemTurmas");

        List<Turma> turmas = turmaService.listarTurmas();
        mv.addObject("listaDeTurmas", turmas);

        return mv;
    }


}

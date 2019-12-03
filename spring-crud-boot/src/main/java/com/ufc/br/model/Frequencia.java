package com.ufc.br.model;

import javax.persistence.*;

@Entity
public class Frequencia {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int totalAulas;

    private int aulasPresent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma")
    private Turma turma;

    public Frequencia(){
        this.totalAulas = 120;
        this.aulasPresent = 0;
    }

    public Frequencia(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
        this.totalAulas = 120;
        this.aulasPresent = 0;
    }

    public Frequencia(int totalAulas, int aulasPresent, Aluno aluno, Turma turma) {
        this.totalAulas = totalAulas;
        this.aulasPresent = aulasPresent;
        this.aluno = aluno;
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public int getTotalAulas() {
        return totalAulas;
    }

    public void setTotalAulas(int totalAulas) {
        this.totalAulas = totalAulas;
    }

    public int getAulasPresent() {
        return aulasPresent;
    }

    public void setAulasPresent(int aulasPresent) {
        this.aulasPresent = aulasPresent;
    }


}

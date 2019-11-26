package com.ufc.br.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int qtdMax; // Capacidade máxima de alunos da turma;
    private int currentAlunos; // Alunos matriculados efetivamente

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_instrutor")
    private Instrutor instrutor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_piloto")
    private Piloto piloto;

    @ManyToMany(mappedBy = "turmas", cascade = CascadeType.ALL)
    private List<Aluno> alunos;


    // -------------------------------------- Construtor, Getter's e Setter's ----------------------------------------- //

    public Turma(int qtdMax, int currentAlunos, Instrutor instrutor, Piloto piloto, List<Aluno> alunos) {
        this.qtdMax = qtdMax;
        this.currentAlunos = currentAlunos;
        this.instrutor = instrutor;
        this.piloto = piloto;
        this.alunos = alunos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQtdMax() {
        return qtdMax;
    }

    public void setQtdMax(int qtdMax) {
        this.qtdMax = qtdMax;
    }

    public int getCurrentAlunos() {
        return currentAlunos;
    }

    public void setCurrentAlunos(int currentAlunos) {
        this.currentAlunos = currentAlunos;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
}

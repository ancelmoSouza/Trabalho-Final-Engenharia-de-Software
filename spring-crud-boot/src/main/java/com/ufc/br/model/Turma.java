package com.ufc.br.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int qtdMax; // Capacidade máxima de alunos da turma;
    private int currentAlunos = 0; // Alunos matriculados efetivamente

    private boolean status;

    private String semestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instrutor")
    private Instrutor instrutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_piloto")
    private Piloto piloto;

    @ManyToMany(mappedBy = "turmas")
    private List<Aluno> alunos;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "turma")
    private List<Frequencia> frequencia;


    // -------------------------------------- Construtor, Getter's e Setter's ----------------------------------------- //

    public Turma(){
        this.currentAlunos = 0;
        alunos = new ArrayList<Aluno>();
        frequencia = new ArrayList<Frequencia>();
        piloto = new Piloto();
        instrutor = new Instrutor();
        this.status = false;
    }

    public Turma(int qtdMax, int currentAlunos, boolean status, String semestre, Instrutor instrutor, Piloto piloto, List<Aluno> alunos, List<Frequencia> frequencia) {
        this.qtdMax = qtdMax;
        this.currentAlunos = currentAlunos;
        this.status = status;
        this.semestre = semestre;
        this.instrutor = instrutor;
        this.piloto = piloto;
        this.alunos = alunos;
        this.frequencia = frequencia;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Frequencia> getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(List<Frequencia> frequencia) {
        this.frequencia = frequencia;
    }
}

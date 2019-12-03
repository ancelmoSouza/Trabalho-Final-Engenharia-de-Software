package com.ufc.br.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aluno{
    //Teste commit e push
    //------------------------------- Dados Pessoais ----------------------------------------//
    @Id
    private String matricula;
    private String nome;

    //Atributo usado para checar se o aluno está presente
    private int inAula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "turmas_aluno",
               joinColumns = @JoinColumn(
                       name = "id_aluno", referencedColumnName = "matricula"),
               inverseJoinColumns = @JoinColumn(
                       name = "id_turma", referencedColumnName = "id"
               )
    )
    private List<Turma> turmas = new ArrayList<Turma>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Frequencia> frequencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // ---------------------------------- Construtor e Getter's e setter's -------------------//

    public Aluno(){
        turmas = new ArrayList<Turma>();
        frequencia = new ArrayList<Frequencia>();
        this.inAula = 0;
    }

    public Aluno(String matricula, String nome, int inAula, Endereco endereco, List<Turma> turmas, List<Frequencia> frequencia, Usuario usuario) {
        this.matricula = matricula;
        this.nome = nome;
        this.inAula = inAula;
        this.endereco = endereco;
        this.turmas = turmas;
        this.frequencia = frequencia;
        this.usuario = usuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Frequencia> getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(List<Frequencia> frequencia) {
        this.frequencia = frequencia;
    }

    public int getInAula() {
        return inAula;
    }

    public void setInAula(int inAula) {
        this.inAula = inAula;
    }
}

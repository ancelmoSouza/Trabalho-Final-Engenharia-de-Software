package com.ufc.br.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Instrutor {


    // ----------------------------------------- Dados específicos -------------------------------- //
    @Id
    private String matricula;
    private String nome;
    private String curso;
    private String instituicao;

    @Temporal(TemporalType.DATE)
    private Date dataObtencao;

    @OneToMany(mappedBy = "instrutor", fetch = FetchType.LAZY)
    private List<Turma> turmas;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // ----------------------------------- Construtor, Getter's e Setter's -------------------------- //

    public Instrutor(){
        this.turmas = new ArrayList<Turma>();
    };

    public Instrutor(String matricula, String nome, String curso, String instituicao, Date dataObtencao, List<Turma> turmas, Usuario usuario) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.instituicao = instituicao;
        this.dataObtencao = dataObtencao;
        this.turmas = turmas;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Date getDataObtencao() {
        return dataObtencao;
    }

    public void setDataObtencao(Date dataObtencao) {
        this.dataObtencao = dataObtencao;
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
}

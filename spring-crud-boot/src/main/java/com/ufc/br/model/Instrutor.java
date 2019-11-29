package com.ufc.br.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Instrutor extends User {


    // ----------------------------------------- Dados específicos -------------------------------- //
    private String curso;
    private String instituicao;

    @Temporal(TemporalType.DATE)
    private Date dataObtencao;

    @OneToMany(mappedBy = "instrutor", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Turma> turmas;

    // ----------------------------------- Construtor, Getter's e Setter's -------------------------- //

    public Instrutor(){};

    public Instrutor(String curso, String instituicao, Date dataObtencao, List<Turma> turmas) {
        this.curso = curso;
        this.instituicao = instituicao;
        this.dataObtencao = dataObtencao;
        this.turmas = turmas;
    }

    public Instrutor(String password, String nome, String login, String curso, String instituicao, Date dataObtencao, List<Turma> turmas) {
        super(password, nome, login);
        this.curso = curso;
        this.instituicao = instituicao;
        this.dataObtencao = dataObtencao;
        this.turmas = turmas;
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
}

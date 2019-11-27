package com.ufc.br.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Instrutor {

    // ---------------------------------------- Dados pessoais ---------------------------------- //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long matricula;
    private String name;


    // ----------------------------------------- Dados específicos -------------------------------- //
    private String curso;
    private String instituicao;

    @Temporal(TemporalType.DATE)
    private Date dataObtencao;

    @OneToMany(mappedBy = "instrutor", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Turma> turmas;

    // ----------------------------------- Construtor, Getter's e Setter's -------------------------- //
    public Instrutor(){}

    public Instrutor(Long matricula, String name, String curso, String instituicao, Date dataObtencao, List<Turma> turmas) {
        this.matricula = matricula;
        this.name = name;
        this.curso = curso;
        this.instituicao = instituicao;
        this.dataObtencao = dataObtencao;
        this.turmas = turmas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

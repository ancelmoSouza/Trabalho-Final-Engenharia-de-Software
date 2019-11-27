package com.ufc.br.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aluno {
    //Teste commit e push
    //------------------------------- Dados Pessoais -----------------------------------------//
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long matricula;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "turmas_aluno",
               joinColumns = {@JoinColumn(name = "id_turma")},
               inverseJoinColumns = {@JoinColumn(name = "id_aluno")})
    private List<Turma> turmas;



    // ---------------------------------- Construtor e Getter's e setter's -------------------//

    public Aluno(){}

    public Aluno(Long matricula, String name, Endereco endereco, List<Turma> turmas) {
        this.matricula = matricula;
        this.name = name;
        this.endereco = endereco;
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
}

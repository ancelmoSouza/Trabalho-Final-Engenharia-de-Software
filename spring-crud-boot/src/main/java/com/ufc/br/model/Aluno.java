package com.ufc.br.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aluno extends User{
    //Teste commit e push
    //------------------------------- Dados Pessoais -----------------------------------------//
    private Long matricula;

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

    public Aluno(Long matricula, Endereco endereco, List<Turma> turmas) {
        this.matricula = matricula;
        this.endereco = endereco;
        this.turmas = turmas;
    }

    public Aluno(String papel, String password, String nome, Long matricula, Endereco endereco, List<Turma> turmas) {
        super(papel, password, nome);
        this.matricula = matricula;
        this.endereco = endereco;
        this.turmas = turmas;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
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

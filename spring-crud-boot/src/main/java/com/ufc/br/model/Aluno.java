package com.ufc.br.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aluno extends User{
    //Teste commit e push
    //------------------------------- Dados Pessoais ----------------------------------------//

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "turmas_aluno",
               joinColumns = {@JoinColumn(name = "id_turma")},
               inverseJoinColumns = {@JoinColumn(name = "id_aluno")})
    private List<Turma> turmas;

    // ---------------------------------- Construtor e Getter's e setter's -------------------//

    public Aluno(){
        super();
    }

    public Aluno(String password, String nome, String login, Endereco endereco, List<Turma> turmas) {
        super(password, nome, login);
        this.endereco = endereco;
        this.turmas = turmas;
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

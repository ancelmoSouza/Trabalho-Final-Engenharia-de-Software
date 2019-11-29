package com.ufc.br.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Piloto extends User{

    // ------------------------------------ Dados Pessoais ------------------------------------ //

    @OneToMany(mappedBy = "piloto", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Turma> turmas;

    // ------------------------------ Construtor, Getter's e Setter's ------------------------- //

    public Piloto(){}

    public Piloto(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Piloto(String password, String nome, String login, List<Turma> turmas) {
        super(password, nome, login);
        this.turmas = turmas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}

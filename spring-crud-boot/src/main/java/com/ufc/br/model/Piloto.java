package com.ufc.br.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Piloto extends User{

    // ------------------------------------ Dados Pessoais ------------------------------------ //

    private Long breve;

    @OneToMany(mappedBy = "piloto", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Turma> turmas;

    // ------------------------------ Construtor, Getter's e Setter's ------------------------- //

    public Piloto(){}

    public Piloto(Long breve, List<Turma> turmas) {
        this.breve = breve;
        this.turmas = turmas;
    }

    public Piloto(String papel, String password, String nome, Long breve, List<Turma> turmas) {
        super(papel, password, nome);
        this.breve = breve;
        this.turmas = turmas;
    }

    public Long getBreve() {
        return breve;
    }

    public void setBreve(Long breve) {
        this.breve = breve;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}

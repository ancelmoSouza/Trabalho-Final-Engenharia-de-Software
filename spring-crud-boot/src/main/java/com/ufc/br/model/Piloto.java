package com.ufc.br.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // ------------------------------------ Dados Pessoais ------------------------------------ //

    private String nome;
    private Long breve;

    @OneToMany(mappedBy = "piloto", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Turma> turmas;

    // ------------------------------ Construtor, Getter's e Setter's ------------------------- //
    public Piloto(){}

    public Piloto(String nome, Long breve, List<Turma> turmas) {
        this.nome = nome;
        this.breve = breve;
        this.turmas = turmas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getBreve() {
        return breve;
    }

    public void setBreve(Long breve) {
        this.breve = breve;
    }
}

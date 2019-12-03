package com.ufc.br.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Piloto {

    // ------------------------------------ Dados Pessoais ------------------------------------ //

    @Id
    private String breve;
    private String nome;

    @OneToMany(mappedBy = "piloto", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private List<Turma> turmas;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Piloto(){
        this.turmas = new ArrayList<Turma>();
    }

    public Piloto(String breve, String nome, List<Turma> turmas, Usuario usuario) {
        this.breve = breve;
        this.nome = nome;
        this.turmas = turmas;
        this.usuario = usuario;
    }

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

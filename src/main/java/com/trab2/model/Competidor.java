/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.model;

/**
 *
 * @author Jordan
 */

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="COMPETIDOR")
public class Competidor extends Id{
    
    @Column(nullable=false)
    private String nome;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="competidor_id")
    private List<Participacao> participacoes;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="competidor1_id")
    private List<Evento> eventos1;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="competidor2_id")
    private List<Evento> eventos2;

    public Competidor() {
    }

    public Competidor(String nome, List<Participacao> participacoes, List<Evento> eventos1, List<Evento> eventos2) {
        this.nome = nome;
        this.participacoes = participacoes;
        this.eventos1 = eventos1;
        this.eventos2 = eventos2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = participacoes;
    }

    public List<Evento> getEventos1() {
        return eventos1;
    }

    public void setEventos1(List<Evento> eventos1) {
        this.eventos1 = eventos1;
    }

    public List<Evento> getEventos2() {
        return eventos2;
    }

    public void setEventos2(List<Evento> eventos2) {
        this.eventos2 = eventos2;
    }   
}

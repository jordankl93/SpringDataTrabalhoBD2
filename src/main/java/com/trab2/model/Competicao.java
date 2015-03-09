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

import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;


@Entity
@Table(name="COMPETICAO")
public class Competicao extends Id{
    
    @Column(nullable=false)
    private String nome;
    @Temporal(DATE)
    private Calendar dt_inicio;
    @Temporal(DATE)
    private Calendar dt_fim;
    @ManyToOne
    @JoinColumn(name="politica_id")
    private Politica politica;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="competicao_id")
    private List<Participacao> participacoes;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="competicao_id")
    private List<Evento> eventos;

    public Competicao() {
    }

    public Competicao(String nome, Calendar dt_inicio, Calendar dt_fim, Politica politica, List<Participacao> participacoes, List<Evento> eventos) {
        this.nome = nome;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.politica = politica;
        this.participacoes = participacoes;
        this.eventos = eventos;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Calendar dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public Calendar getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(Calendar dt_fim) {
        this.dt_fim = dt_fim;
    }

    public Politica getPolitica() {
        return politica;
    }

    public void setPolitica(Politica politica) {
        this.politica = politica;
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = participacoes;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}

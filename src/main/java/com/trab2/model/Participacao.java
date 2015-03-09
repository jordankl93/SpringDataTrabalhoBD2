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

import javax.persistence.*;

@Entity
@Table(name="PARTICIPACAO")
public class Participacao extends Id{
    
    @Column
    private int colocacao;
    @Column 
    private Double premio;
    @ManyToOne
    @JoinColumn(name="competidor_id")
    private Competidor competidor;
    @ManyToOne
    @JoinColumn(name="competicao_id")
    private Competicao competicao;

    public Participacao() {
    }

    public Participacao(int colocacao, Double premio, Competidor competidor, Competicao competicao) {
        this.colocacao = colocacao;
        this.premio = premio;
        this.competidor = competidor;
        this.competicao = competicao;
    }

    public int getColocacao() {
        return colocacao;
    }

    public void setColocacao(int colocacao) {
        this.colocacao = colocacao;
    }

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }

    public Competidor getCompetidor() {
        return competidor;
    }

    public void setCompetidor(Competidor competidor) {
        this.competidor = competidor;
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }
    
}

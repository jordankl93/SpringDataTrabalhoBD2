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
@Table(name="EVENTO")
public class Evento extends Id{
    
    @Column
    private int vencedor_cod;
    @ManyToOne
    @JoinColumn(name="competidor1_id")
    private Competidor competidor1;
    @ManyToOne
    @JoinColumn(name="competidor2_id")
    private Competidor competidor2;
    @ManyToOne
    @JoinColumn(name="competicao_id")
    private Competicao competicao;

    public Evento() {
    }

    public Evento(int vencedor_cod, Competidor competidor1, Competidor competidor2, Competicao competicao) {
        this.vencedor_cod = vencedor_cod;
        this.competidor1 = competidor1;
        this.competidor2 = competidor2;
        this.competicao = competicao;
    }

    public int getVencedor_cod() {
        return vencedor_cod;
    }

    public void setVencedor_cod(int vencedor_cod) {
        this.vencedor_cod = vencedor_cod;
    }

    public Competidor getCompetidor1() {
        return competidor1;
    }

    public void setCompetidor1(Competidor competidor1) {
        this.competidor1 = competidor1;
    }

    public Competidor getCompetidor2() {
        return competidor2;
    }

    public void setCompetidor2(Competidor competidor2) {
        this.competidor2 = competidor2;
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }
}

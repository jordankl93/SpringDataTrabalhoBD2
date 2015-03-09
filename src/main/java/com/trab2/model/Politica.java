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
@Table(name="POLITICA")
public class Politica extends Id{
    
    @Column
    private int p_vitoria;
    @Column
    private int p_empate;
    @Column
    private int p_derrota;
    @Column
    private boolean permissao;
    @OneToMany(fetch = FetchType.LAZY, mappedBy="politica", cascade = CascadeType.ALL)
    //@JoinColumn(name="politica_id")
    private List<Competicao> competicoes;

    public Politica() {
    }

    public Politica(int p_vitoria, int p_empate, int p_derrota, boolean permissao, List<Competicao> competicoes) {
        this.p_vitoria = p_vitoria;
        this.p_empate = p_empate;
        this.p_derrota = p_derrota;
        this.permissao = permissao;
        this.competicoes = competicoes;
    }

    public int getP_vitoria() {
        return p_vitoria;
    }

    public void setP_vitoria(int p_vitoria) {
        this.p_vitoria = p_vitoria;
    }

    public int getP_empate() {
        return p_empate;
    }

    public void setP_empate(int p_empate) {
        this.p_empate = p_empate;
    }

    public int getP_derrota() {
        return p_derrota;
    }

    public void setP_derrota(int p_derrota) {
        this.p_derrota = p_derrota;
    }

    public boolean isPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }

    public List<Competicao> getCompeticoes() {
        return competicoes;
    }

    public void setCompeticoes(List<Competicao> competicoes) {
        this.competicoes = competicoes;
    }
    
}

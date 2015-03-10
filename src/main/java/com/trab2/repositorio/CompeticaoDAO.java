/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.repositorio;

import com.trab2.model.Competicao;
import com.trab2.model.Politica;
import java.util.Calendar;

/**
 *
 * @author Jordan
 */
public class CompeticaoDAO extends DAO{
    
    public Competicao insertCompeticao(String nome, Calendar dt_inicio, Calendar dt_fim, Politica politica){
        Competicao competicao = new Competicao();
        competicao.setNome(nome);
        competicao.setDt_inicio(dt_inicio);
        competicao.setDt_fim(dt_fim);
        competicao.setPolitica(politica);
        return this.getRepositorioCompeticao().save(competicao);
    }
    
    public Competicao updateCompeticao(Competicao competicao){
        return this.getRepositorioCompeticao().save(competicao);
    }
    
    public void deleteCompeticao(Competicao competicao){
        this.getRepositorioCompeticao().delete(competicao);
    }  
        
}

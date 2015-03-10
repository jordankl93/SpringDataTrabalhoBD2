/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.repositorio;

import com.trab2.model.Politica;
import java.util.List;

/**
 *
 * @author Jordan
 */
public class PoliticaDAO extends DAO{
    
    public Politica insertPolitica(int vit, int emp, int derr, Boolean per){
        Politica politica = new Politica();
        politica.setP_vitoria(vit);
        politica.setP_empate(emp);
        politica.setP_derrota(derr);
        politica.setPermissao(per);
        return this.getRepositorioPolitica().save(politica);
    }
    
    public Politica updatePolitica(Politica politica){
        return this.getRepositorioPolitica().save(politica);
    }
    
    public void deletePolitica(Politica politica){
        this.getRepositorioPolitica().delete(politica);
    }
    
    public List<Politica> BuscaPoliticas(){
        return this.getRepositorioPolitica().findAll();
    }
    
}

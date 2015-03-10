/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.repositorio;

import com.trab2.model.Competidor;
import com.trab2.model.Participacao;

/**
 *
 * @author Jordan
 */
public class CompetidorDAO extends DAO{    
    
    public Competidor insertCompetidor(String nome){
        Competidor competidor = new Competidor();
        competidor.setNome(nome);
        return this.getRepositorioCompetidor().save(competidor);        
    }
    
    public Competidor updateCompetidor(Competidor competidor){
        return this.getRepositorioCompetidor().save(competidor);
    }
    
    public void deleteCompetidor(Competidor competidor){
        this.getRepositorioCompetidor().delete(competidor);
    }
    
    public void BuscaByCompetidor(int id){
        if(getRepositorioCompetidor().exists(id)){
            Competidor competidor = getRepositorioCompetidor().findOne(id);       

            System.out.println("------------------------------------------------------------------------");
            System.out.println("Nome Competidor: " + competidor.getNome()+"\n");        
            for(Participacao part : competidor.getParticipacoes()){
                System.out.println("Competicao: "+ part.getCompeticao().getNome()+" | Colocao: "+ part.getColocacao());
            }
        }
        else
            System.out.println("ID inválido");
        System.out.println("------------------------------------------------------------------------\n");
    }
    
}

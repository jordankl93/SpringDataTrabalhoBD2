/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.repositorio;

import com.trab2.model.Competicao;
import com.trab2.model.Competidor;
import com.trab2.model.Participacao;

/**
 *
 * @author Jordan
 */
public class ParticipacaoDAO extends DAO{
    
    public Participacao insertParticipacao(int colocacao, Double premio, Competidor competidor, Competicao competicao){
        Participacao participacao = new Participacao();
        participacao.setColocacao(colocacao);
        participacao.setPremio(premio);
        participacao.setCompetidor(competidor);
        participacao.setCompeticao(competicao);
        return this.getRepositorioParticipacao().save(participacao);
    }
    
    public Participacao updateParticipacao(Participacao participacao){
        return this.getRepositorioParticipacao().save(participacao);
    }
    
    public void deleteParticipacao(Participacao participacao){
        this.getRepositorioParticipacao().delete(participacao);
    }
    
    public void BuscaByColocacao(){
        System.out.println("------------------------------------------------------------------------");
        for(Object[] part : this.getRepositorioParticipacao().findByColocacao()){
            System.out.println("Nome competidor: "+ part[0].toString()+ " - Campeonatos vencidos: "+ part[1].toString());
        }
        System.out.println("------------------------------------------------------------------------\n");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.repositorio;

import com.trab2.model.Competicao;
import com.trab2.model.Competidor;
import com.trab2.model.Evento;
import java.util.List;

/**
 *
 * @author Jordan
 */
public class EventoDAO extends DAO{
    
    public Evento insertEvento(int vencedor_cod, Competidor competidor1, Competidor competidor2, Competicao competicao){
        Evento evento = new Evento();
        evento.setVencedor_cod(vencedor_cod);
        evento.setCompetidor1(competidor1);
        evento.setCompetidor2(competidor2);
        evento.setCompeticao(competicao);
        return this.getRepositorioEvento().save(evento);
    }   
    
    public Evento updateEvento(Evento evento){
        return this.getRepositorioEvento().save(evento);
    }
    
    public void deleteEvento(Evento evento){
        this.getRepositorioEvento().delete(evento);
    }    
    
    public void BuscaByCompetidorAndCompeticao(int idCompetidor, int idCompeticao){
        Competidor competidor = getRepositorioCompetidor().findOne(idCompetidor);
        Competicao competicao = getRepositorioCompeticao().findOne(idCompeticao);
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Competidor: " + competidor.getNome()+ " | Competicao: " + competicao.getNome()+"\n");
        
        List<Evento> listEvento = getRepositorioEvento().findByCompeticaoAndCompetidor(competicao, competidor);
        
        for(Evento ev : listEvento){
            if(ev.getVencedor_cod() == idCompetidor)
                System.out.println("Rodada: "+ ev.getCompetidor1().getNome() +" x "+ ev.getCompetidor2().getNome()+" - Venceu");
            else
                System.out.println("Rodada: "+ ev.getCompetidor1().getNome() +" x "+ ev.getCompetidor2().getNome()+" - Perdeu");
        }
        
        System.out.println("------------------------------------------------------------------------\n");
    }
    
}

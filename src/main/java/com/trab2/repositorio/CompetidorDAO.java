/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.repositorio;

import com.trab2.model.Competicao;
import com.trab2.model.Competidor;
import com.trab2.model.Evento;
import com.trab2.model.Participacao;
import java.util.List;

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
    
    public void BuscaInfoCompetidorByCompeticao(Competicao competicao){
        int ptos = 0, vit = 0, emp = 0, derr = 0; 
        
        //Lista todas as participações dessa determinada competicao
        List<Participacao> participacoes = this.getRepositorioParticipacao().findByCompeticao(competicao);        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Competicao: " + competicao.getNome()+"\n");
        
        //Lista Por competidores
        for(Participacao part : participacoes){
            System.out.println("- Competidor: "+part.getCompetidor().getNome());
            System.out.println("\t\tColocacao: "+ part.getColocacao());
            for(Evento ev : part.getCompetidor().getEventos1()){
                //caso de vitória..
                if(ev.getVencedor_cod() == part.getCompetidor().getId()){
                    ptos += competicao.getPolitica().getP_vitoria();
                    vit++;
                }
                else{
                    //se vencedor_cod == 0 significa empate
                    if(ev.getVencedor_cod() == 0 && competicao.getPolitica().isPermissao()){
                        ptos += competicao.getPolitica().getP_empate();
                        emp++;
                    }
                    //demais casos == derrota
                    else{
                        ptos += competicao.getPolitica().getP_derrota();
                        derr++;
                    }
                }
            }
            System.out.println("\t\tPontuacao: "+ptos+"| Vitorias: "+vit+"| Empates: "+emp+"| Derrotas: "+derr);
        }
        System.out.println("------------------------------------------------------------------------");
    }
    
}

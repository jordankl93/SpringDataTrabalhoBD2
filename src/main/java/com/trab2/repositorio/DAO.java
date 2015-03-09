/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.repositorio;

import com.trab2.Config;
import com.trab2.model.Competicao;
import com.trab2.model.Competidor;
import com.trab2.model.Evento;
import com.trab2.model.Participacao;
import com.trab2.model.Politica;
import java.util.Calendar;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Jordan
 */
public class DAO {
    private ApplicationContext context;
    private RepositorioCompetidor repositorioCompetidor;
    private RepositorioParticipacao repositorioParticipacao;
    private RepositorioEvento repositorioEvento;
    private RepositorioCompeticao repositorioCompeticao;
    private RepositorioPolitica repositorioPolitica;
    
    public DAO() {
        this.context = new AnnotationConfigApplicationContext(Config.class);
        this.repositorioCompetidor = context.getBean(RepositorioCompetidor.class);
        this.repositorioParticipacao = context.getBean(RepositorioParticipacao.class);
        this.repositorioCompeticao = context.getBean(RepositorioCompeticao.class);
        this.repositorioEvento = context.getBean(RepositorioEvento.class);
        this.repositorioPolitica = context.getBean(RepositorioPolitica.class);
    }
    
    public Competidor insertCompetidor(String nome){
        Competidor competidor = new Competidor();
        competidor.setNome(nome);
        return repositorioCompetidor.save(competidor);        
    }
    
    public Politica insertPolitica(int vit, int emp, int derr, Boolean per){
        Politica politica = new Politica();
        politica.setP_vitoria(vit);
        politica.setP_empate(emp);
        politica.setP_derrota(derr);
        politica.setPermissao(per);
        return repositorioPolitica.save(politica);
    }
    
    public Competicao insertCompeticao(String nome, Calendar dt_inicio, Calendar dt_fim, Politica politica){
        Competicao competicao = new Competicao();
        competicao.setNome(nome);
        competicao.setDt_inicio(dt_inicio);
        competicao.setDt_fim(dt_fim);
        competicao.setPolitica(politica);
        return repositorioCompeticao.save(competicao);        
    }
    
    public Participacao insertParticipacao(int colocacao, Double premio, Competidor competidor, Competicao competicao){
        Participacao participacao = new Participacao();
        participacao.setColocacao(colocacao);
        participacao.setPremio(premio);
        participacao.setCompetidor(competidor);
        participacao.setCompeticao(competicao);
        return repositorioParticipacao.save(participacao);
    }
    
    public Evento insertEvento(int vencedor_cod, Competidor competidor1, Competidor competidor2, Competicao competicao){
        Evento evento = new Evento();
        evento.setVencedor_cod(vencedor_cod);
        evento.setCompetidor1(competidor1);
        evento.setCompetidor2(competidor2);
        evento.setCompeticao(competicao);
        return repositorioEvento.save(evento);
    }
    
    public void BuscaByCompetidor(int id){
        if(repositorioCompetidor.exists(id)){
            Competidor competidor = repositorioCompetidor.findOne(id);       

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
    
    public void BuscaByCompetidorAndCompeticao(int idCompetidor, int idCompeticao){
        Competidor competidor = repositorioCompetidor.findOne(idCompetidor);
        Competicao competicao = repositorioCompeticao.findOne(idCompeticao);
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Competidor: " + competidor.getNome()+ " | Competicao: " + competicao.getNome()+"\n");
        
        List<Evento> listEvento = repositorioEvento.findByCompeticaoAndCompetidor(competicao, competidor);
        
        for(Evento ev : listEvento){
            if(ev.getVencedor_cod() == idCompetidor)
                System.out.println("Rodada: "+ ev.getCompetidor1().getNome() +" x "+ ev.getCompetidor2().getNome()+" - Venceu");
            else
                System.out.println("Rodada: "+ ev.getCompetidor1().getNome() +" x "+ ev.getCompetidor2().getNome()+" - Perdeu");
        }
        
        System.out.println("------------------------------------------------------------------------\n");
    }
    
    public void BuscaTopCinco(){
        
    }
    
    public List<Politica> BuscaPoliticas(){
        return repositorioPolitica.findAll();
    }
}

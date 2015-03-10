/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.competicoesesportivas;

import com.trab2.Config;
import com.trab2.model.Competicao;
import com.trab2.model.Competidor;
import com.trab2.model.Evento;
import com.trab2.model.Participacao;
import com.trab2.model.Politica;
import com.trab2.repositorio.*;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Jordan
 */
public class App {
    
    public static void main(String[] args){
        CompetidorDAO acessoCompetidor = new CompetidorDAO();
        CompeticaoDAO acessoCompeticao = new CompeticaoDAO();
        PoliticaDAO acessoPolitica = new PoliticaDAO();
        ParticipacaoDAO acessoParticipacao = new ParticipacaoDAO();
        EventoDAO acessoEvento = new EventoDAO();
        
        List<Competidor> competidores = new ArrayList<>();
        List<Politica> politicas = new ArrayList<>();
        List<Competicao> competicoes = new ArrayList<>();
        List<Participacao> participacoes = new ArrayList<>();
        List<Evento> eventos = new ArrayList<>();
        
        //Apenas descomentar se o banco estivar vazio
        //Inserindo Competidor
//        competidores.add(acessoCompetidor.insertCompetidor("Joao Luiz"));
//        competidores.add(acessoCompetidor.insertCompetidor("Alberto Augusto"));
//        competidores.add(acessoCompetidor.insertCompetidor("Maria Antonieta"));
//        competidores.add(acessoCompetidor.insertCompetidor("Lara Mendes"));
//        competidores.add(acessoCompetidor.insertCompetidor("Julia Souza Souza"));
//        competidores.add(acessoCompetidor.insertCompetidor("Jorge Elias"));
//        competidores.add(acessoCompetidor.insertCompetidor("Matias Neto"));
//        competidores.add(acessoCompetidor.insertCompetidor("Joao Victor Elias"));
//        competidores.add(acessoCompetidor.insertCompetidor("Mauro Galvao Bueno"));
//        competidores.add(acessoCompetidor.insertCompetidor("Luiz Wagner Miranda"));
//        
//        //Inserindo Politica
//        politicas.add(acessoPolitica.insertPolitica(2, 1, 0, Boolean.TRUE));
//        politicas.add(acessoPolitica.insertPolitica(3, 1, 0, Boolean.TRUE));
//        politicas.add(acessoPolitica.insertPolitica(3, 0, 0, Boolean.FALSE));
//        politicas.add(acessoPolitica.insertPolitica(5, 3, 1, Boolean.TRUE));
//        politicas.add(acessoPolitica.insertPolitica(5, 0, -1, Boolean.FALSE));
//        
//        //Inserindo Competicao
//        competicoes.add(acessoCompeticao.insertCompeticao("Campeonato Brasilerio", Calendar.getInstance(), Calendar.getInstance(), politicas.get(2)));
//        competicoes.add(acessoCompeticao.insertCompeticao("Sulamericana", Calendar.getInstance(), Calendar.getInstance(), politicas.get(1)));
//        competicoes.add(acessoCompeticao.insertCompeticao("Campeonato de Remo", Calendar.getInstance(), Calendar.getInstance(), politicas.get(2)));
//        competicoes.add(acessoCompeticao.insertCompeticao("Libertadores", Calendar.getInstance(), Calendar.getInstance(), politicas.get(1)));
//        competicoes.add(acessoCompeticao.insertCompeticao("Copa do Brasil", Calendar.getInstance(), Calendar.getInstance(), politicas.get(4)));
//        
//        //Inserindo Participacao
//        participacoes.add(acessoParticipacao.insertParticipacao(1,1000.0,competidores.get(0),competicoes.get(0)));
//        participacoes.add(acessoParticipacao.insertParticipacao(1,1000.0,competidores.get(0),competicoes.get(1)));
//        participacoes.add(acessoParticipacao.insertParticipacao(1,1000.0,competidores.get(0),competicoes.get(2)));
//        participacoes.add(acessoParticipacao.insertParticipacao(2,500.0,competidores.get(1),competicoes.get(3)));
//        participacoes.add(acessoParticipacao.insertParticipacao(2,500.0,competidores.get(1),competicoes.get(4)));
//        participacoes.add(acessoParticipacao.insertParticipacao(3,200.0,competidores.get(8),competicoes.get(0)));
//        participacoes.add(acessoParticipacao.insertParticipacao(3,200.0,competidores.get(9),competicoes.get(3)));
//        participacoes.add(acessoParticipacao.insertParticipacao(1,0.0,competidores.get(3),competicoes.get(0)));
//        participacoes.add(acessoParticipacao.insertParticipacao(1,0.0,competidores.get(3),competicoes.get(1)));
//        participacoes.add(acessoParticipacao.insertParticipacao(1,0.0,competidores.get(4),competicoes.get(3)));
//        participacoes.add(acessoParticipacao.insertParticipacao(1,0.0,competidores.get(5),competicoes.get(3)));
//        participacoes.add(acessoParticipacao.insertParticipacao(1,0.0,competidores.get(5),competicoes.get(2)));
//        
//        //Inserindo Evento
//        eventos.add(acessoEvento.insertEvento(1, competidores.get(0), competidores.get(1), competicoes.get(2)));
//        eventos.add(acessoEvento.insertEvento(2, competidores.get(2), competidores.get(1), competicoes.get(1)));
//        eventos.add(acessoEvento.insertEvento(3, competidores.get(3), competidores.get(2), competicoes.get(0)));
//        eventos.add(acessoEvento.insertEvento(4, competidores.get(4), competidores.get(3), competicoes.get(3)));
//        eventos.add(acessoEvento.insertEvento(6, competidores.get(6), competidores.get(5), competicoes.get(0)));
//        eventos.add(acessoEvento.insertEvento(7, competidores.get(7), competidores.get(6), competicoes.get(3)));
//        eventos.add(acessoEvento.insertEvento(2, competidores.get(2), competidores.get(1), competicoes.get(1)));
//        eventos.add(acessoEvento.insertEvento(5, competidores.get(5), competidores.get(4), competicoes.get(2)));
//        eventos.add(acessoEvento.insertEvento(7, competidores.get(8), competidores.get(6), competicoes.get(4)));
//        eventos.add(acessoEvento.insertEvento(5, competidores.get(9), competidores.get(4), competicoes.get(2)));
        
        
        System.out.println("\nQUESTÃO 2");
        System.out.println("a) Buscando Competições e Colocação por Competidor: ");
        acessoCompetidor.BuscaByCompetidor(5);
        
        System.out.println("b) Dado um competidor e uma competição, recuperar os eventos em que o time participou e\n" +
        "se o time venceu o evento: ");
        acessoEvento.BuscaByCompetidorAndCompeticao(5, 18);
        
        System.out.println("c) Top 5 competidores que mais venceram campeonatos: ");
        acessoParticipacao.BuscaByColocacao();
        
        
        
         
    }
    
}

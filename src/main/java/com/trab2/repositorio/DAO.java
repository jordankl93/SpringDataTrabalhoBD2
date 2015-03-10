/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.repositorio;

import com.trab2.Config;
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

    public RepositorioCompetidor getRepositorioCompetidor() {
        return repositorioCompetidor;
    }

    public RepositorioParticipacao getRepositorioParticipacao() {
        return repositorioParticipacao;
    }

    public RepositorioEvento getRepositorioEvento() {
        return repositorioEvento;
    }

    public RepositorioCompeticao getRepositorioCompeticao() {
        return repositorioCompeticao;
    }

    public RepositorioPolitica getRepositorioPolitica() {
        return repositorioPolitica;
    }
}

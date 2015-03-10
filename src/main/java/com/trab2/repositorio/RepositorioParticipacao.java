/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2.repositorio;

/**
 *
 * @author Jordan
 */

import com.trab2.model.Competicao;
import com.trab2.model.Competidor;
import com.trab2.model.Participacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioParticipacao extends JpaRepository<Participacao, Integer>, JpaSpecificationExecutor<Participacao>{
    
    /*Tomando base os campeonatos (como dito no enunciado da questao 2-b) e não os eventos*/
    @Query(value="select c.nome, count(p.competidor_id) as qtd \n" +
                "from participacao p inner join competidor c on p.competidor_id = c.id \n" +
                "where p.colocacao = 1 \n" +
                "group by c.nome \n" +
                "order by qtd desc", nativeQuery=true)
    public List<Object[]> findByColocacao();
    
    public List<Participacao> findByCompeticao(Competicao competicao);    
    
}

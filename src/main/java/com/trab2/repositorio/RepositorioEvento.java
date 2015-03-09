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
import com.trab2.model.Evento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEvento extends JpaRepository<Evento, Integer> {
    
    @Query("select e from Evento e where e.competicao = :competicao and e.competidor1 = :competidor or e.competidor2 = :competidor")
    public List<Evento> findByCompeticaoAndCompetidor(@Param("competicao") Competicao competicao, 
                                                @Param("competidor") Competidor competidor);
    
}

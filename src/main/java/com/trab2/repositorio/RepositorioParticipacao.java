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

import com.trab2.model.Participacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioParticipacao extends JpaRepository<Participacao, Integer>{
    
    public List<Participacao> findByCompetidor_Id(int idCompetidor);
   
    
}

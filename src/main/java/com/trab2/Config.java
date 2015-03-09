/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trab2;

/**
 *
 * @author Jordan
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
// Procura por componentes a partir desse pacote.
@ComponentScan(basePackages = "com.trab2")
// Ativa o Spring Data JPA
@EnableJpaRepositories
public class Config {

}
package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dspesquisa.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{ //tipo da entidade, tipo da Id da entidade

}

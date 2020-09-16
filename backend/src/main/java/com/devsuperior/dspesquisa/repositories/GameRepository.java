package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Game;

@Repository //registra o mecanismo de dependência
public interface GameRepository extends JpaRepository<Game, Long>{ //tipo da entidade, tipo da Id da entidade

}

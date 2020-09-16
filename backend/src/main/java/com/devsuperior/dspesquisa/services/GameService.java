package com.devsuperior.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;  //dependencia do GameRepository

	@Transactional(readOnly = true)   //garantir que o BD será realizado e finalizado no service //apenas busca (readOnly)
	public List<GameDTO> findAll(){		//buscar no BD todos os games, guardar em uma lista. Transofrmar a lista de games no GamesDTO 
		List<Game> list = repository. findAll();
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());			//tranformar a lista em stream, cada elemento, e transforma novamente em uma lista
	}
}

package com.devsuperior.dspesquisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.services.GameService;

@RestController 					//controlador web-service
@RequestMapping(value = "/games") 	//rota principal do recurso
public class GameResource{ 			//implementa o recurso em games
	
	@Autowired
	private GameService service; 	//dependencia do GameService
	
	@GetMapping //requisição get
	public ResponseEntity<List<GameDTO>> findAll(){	//web-service
		List<GameDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}

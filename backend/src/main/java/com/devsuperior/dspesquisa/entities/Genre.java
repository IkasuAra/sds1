package com.devsuperior.dspesquisa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;			//ctrl + shif + O (importar)

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 		//classe mapeada no banco de dados
@Table(name = "tb_genre")   //mapear a tabela do banco de dados com o nome tb_genre
public class Genre implements Serializable {	 //interface serializable (conversão de bites para o tráfego na rede)
	private static final long serialVersionUID = 1L;
	
	@Id //auto incrementável no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //banco de dados H2 e de produção postgresql.
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "genre")		
	private List<Game> games = new ArrayList<>();    //associar a classe Genre ao Game
	
	public Genre() {
		
	}

	public Genre(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() { 		  	//obter id
		return id;
	}

	public void setId(Long id) {  	//atribuir id a classe
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Game> getGames() {
		return games;
	}

	@Override
	public int hashCode() {						//parâmetro de comparação de códigos entre objetos (rápido)
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {  		//comparação de objetos (lento)
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

package com.devsuperior.dspesquisa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dspesquisa.entities.enums.Platform;

@Entity 		//classe mapeada no banco de dados
@Table(name = "tb_game")   //mapear a tabela do banco de dados com o nome tb_genre
public class Game implements Serializable {	 //interface serializable (conversão de bites para o tráfego na rede)
	private static final long serialVersionUID = 1L;

	@Id //auto incrementável no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //banco de dados H2 e de produção postgresql.
	private Long id;
	private String title;
	private Platform platform;  	//ctrl + spacebar (completar)
	
	@ManyToOne //chave estrangeira no BD que irá referenciar na tabela.
	@JoinColumn(name = "genre_id")
	private Genre genre;            //associar a classe Game ao Genre
	
	@OneToMany(mappedBy = "game")   //mapear objeto-relacional
	private List<Record> records = new ArrayList<>();
	// private define o encapsulamento do tributo
	public Game() {	
	}

	public Game(Long id, String title, Platform platform, Genre genre) {
		super();
		this.id = id;
		this.title = title;
		this.platform = platform;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Record> getRecords() {
		return records;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

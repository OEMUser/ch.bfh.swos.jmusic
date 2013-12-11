package ch.bfh.swos.jmusic.model;

import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Entity implementation class for Entity: Album
 * 
 */
@Entity
public class Album implements Serializable {

	private String name;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private Blob cover;
	private Integer playtime;
	@OneToMany(cascade = PERSIST)
	private List<Genre> genres;
	
	@OneToMany(cascade = PERSIST)
	private List<Title> titles;

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	private static final long serialVersionUID = 1L;

	public Album() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Blob getCover() {
		return cover;
	}

	public void setCover(Blob cover) {
		this.cover = cover;
	}

	public Integer getPlaytime() {
		return playtime;
	}

	public void setPlaytime(Integer playtime) {
		this.playtime = playtime;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

}

package ch.bfh.swos.jmusic.service.dto;

import java.sql.Blob;
import java.util.List;

import ch.bfh.swos.jmusic.model.Genre;
import ch.bfh.swos.jmusic.model.Title;

public class AlbumDTO {

	private Long id;
	private String name;
	private Blob cover;
	private Integer playtime;
	private List<Genre> genres;	
	private List<Title> titles;	

	public AlbumDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}
	

}

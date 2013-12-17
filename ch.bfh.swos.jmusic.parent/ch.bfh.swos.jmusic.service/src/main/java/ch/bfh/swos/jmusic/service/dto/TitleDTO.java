package ch.bfh.swos.jmusic.service.dto;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;


/**
 * Entity implementation class for Entity: Title
 * 
 */

public class TitleDTO implements Serializable {


	private Long id;
	private String name;
	private Integer length;

	private Date publication;

	private List<ArtistDTO> artists;

	private List<AlbumDTO> albums;
	private static final long serialVersionUID = 1L;

	public TitleDTO() {
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

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Date getPublication() {
		return publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	public List<ArtistDTO> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistDTO> artists) {
		this.artists = artists;
	}

	public List<AlbumDTO> getAlbums() {
		return albums;
	}

	public void setAlbums(List<AlbumDTO> albums) {
		this.albums = albums;
	}

}

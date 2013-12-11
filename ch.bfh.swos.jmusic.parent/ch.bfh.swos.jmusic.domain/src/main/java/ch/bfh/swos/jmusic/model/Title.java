package ch.bfh.swos.jmusic.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Entity implementation class for Entity: Title
 * 
 */
@Entity
public class Title implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String name;
	private Integer length;
	@Temporal(TemporalType.DATE)
	private Date publication;
	@OneToMany(cascade = PERSIST)
	private List<Artist> artists;
	private List<Album> albums;
	private static final long serialVersionUID = 1L;

	public Title() {
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

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

}

package ch.bfh.swos.jmusic.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity implementation class for Entity: Genre
 * 
 */
@Entity
public class Genre implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String name;
	private static final long serialVersionUID = 1L;

	public Genre() {
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

}

package ch.bfh.swos.jmusic.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity implementation class for Entity: Artist
 * 
 */
@Entity
public class Artist implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date birthday;
//	private List<Title> titles;
	private static final long serialVersionUID = 1L;

	public Artist() {
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
		System.out.println(this.birthday);		
	}

/*	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	} */


}

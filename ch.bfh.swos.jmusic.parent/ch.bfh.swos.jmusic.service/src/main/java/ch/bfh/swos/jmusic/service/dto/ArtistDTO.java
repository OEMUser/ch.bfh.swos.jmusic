package ch.bfh.swos.jmusic.service.dto;

import java.util.Date;

public class ArtistDTO {

	private Long id;
	private String name;
	private Date birthday;

	public ArtistDTO() {
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
	}

}

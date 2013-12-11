package ch.bfh.swos.jmusic.service;

import java.util.Collection;

import ch.bfh.swos.jmusic.service.dto.GenreDTO;

public interface GenreService {

	public GenreDTO create(GenreDTO genre);

	public GenreDTO read(long id);

	public Collection<GenreDTO> list();

	public GenreDTO update(GenreDTO genre);

	public void delete(GenreDTO genre);

}

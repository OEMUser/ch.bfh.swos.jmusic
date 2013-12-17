package ch.bfh.swos.jmusic.service;

import java.util.Collection;

import ch.bfh.swos.jmusic.service.dto.TitleDTO;

public interface TitleService {

	public TitleDTO create(TitleDTO Title);

	public TitleDTO read(long id);

	public Collection<TitleDTO> list();

	public TitleDTO update(TitleDTO Title);

	public void delete(TitleDTO Title);

}

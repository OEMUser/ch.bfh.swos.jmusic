package ch.bfh.swos.jmusic.service;

import java.util.Collection;

import ch.bfh.swos.jmusic.service.dto.ArtistDTO;

public interface ArtistService {
	public ArtistDTO create(ArtistDTO artist);

	public ArtistDTO read(long id);

	public Collection<ArtistDTO> list();

	public ArtistDTO update(ArtistDTO artist);

	public void delete(ArtistDTO artist);
}

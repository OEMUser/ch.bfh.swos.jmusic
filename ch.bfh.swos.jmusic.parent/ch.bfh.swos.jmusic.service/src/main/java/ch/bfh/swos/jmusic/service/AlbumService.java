package ch.bfh.swos.jmusic.service;

import java.util.Collection;

import ch.bfh.swos.jmusic.service.dto.AlbumDTO;

public interface AlbumService {

	public AlbumDTO create(AlbumDTO Album);

	public AlbumDTO read(long id);

	public Collection<AlbumDTO> list();

	public AlbumDTO update(AlbumDTO Album);

	public void delete(AlbumDTO Album);

}

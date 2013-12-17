package ch.bfh.swos.jmusic.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.swos.jmusic.model.Album;
import ch.bfh.swos.jmusic.repository.AlbumRepository;
import ch.bfh.swos.jmusic.service.AlbumService;
import ch.bfh.swos.jmusic.service.dto.AlbumDTO;

@Named
public class DefaultAlbumServiceImpl implements AlbumService {

	@Inject
	private AlbumRepository AlbumRepository;

	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public AlbumDTO create(AlbumDTO Album) {
		Album entity = modelMapper.map(Album, Album.class);
		entity = AlbumRepository.save(entity);
		return modelMapper.map(entity, AlbumDTO.class);
	}

	@Override
	public AlbumDTO read(long id) {
		Album Album = AlbumRepository.findOne(id);
		if (Album != null) {
			return modelMapper.map(Album, AlbumDTO.class);
		}
		return null;
	}

	@Override
	public Collection<AlbumDTO> list() {
		Iterable<Album> AlbumList = AlbumRepository.findAll();
		Type listType = new TypeToken<Collection<AlbumDTO>>() {
		}.getType();

		return modelMapper.map(AlbumList, listType);
	}

	@Override
	public AlbumDTO update(AlbumDTO Album) {
		Album entity = modelMapper.map(Album, Album.class);
		entity = AlbumRepository.save(entity);
		return modelMapper.map(entity, AlbumDTO.class);
	}

	@Override
	public void delete(AlbumDTO Album) {
		Album entity = AlbumRepository.findOne(Album.getId());
		AlbumRepository.delete(entity);
	}

}

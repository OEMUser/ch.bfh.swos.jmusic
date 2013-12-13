package ch.bfh.swos.jmusic.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.swos.jmusic.model.Artist;
import ch.bfh.swos.jmusic.repository.ArtistRepository;
import ch.bfh.swos.jmusic.service.ArtistService;
import ch.bfh.swos.jmusic.service.dto.ArtistDTO;

@Named
public class DefaultArtistServiceImpl implements ArtistService {

	@Inject
	private ArtistRepository artistRepository;

	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public ArtistDTO create(ArtistDTO artist) {
		Artist entity = modelMapper.map(artist, Artist.class);
//		System.out.println(entity.getBirthday().toString());
		entity = artistRepository.save(entity);
		return modelMapper.map(entity, ArtistDTO.class);
	}

	@Override
	public ArtistDTO read(long id) {
		Artist artist = artistRepository.findOne(id);
		if (artist != null) {
			return modelMapper.map(artist, ArtistDTO.class);
		}
		return null;
	}

	@Override
	public Collection<ArtistDTO> list() {
		Iterable<Artist> artistList = artistRepository.findAll();
		Type listType = new TypeToken<Collection<ArtistDTO>>() {
		}.getType();

		return modelMapper.map(artistList, listType);
	}

	@Override
	public ArtistDTO update(ArtistDTO artist) {
		Artist entity = modelMapper.map(artist, Artist.class);
		entity = artistRepository.save(entity);
		return modelMapper.map(entity, ArtistDTO.class);
	}

	@Override
	public void delete(ArtistDTO artist) {
		Artist entity = artistRepository.findOne(artist.getId());
		artistRepository.delete(entity);
	}

}

package ch.bfh.swos.jmusic.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.swos.jmusic.model.Genre;
import ch.bfh.swos.jmusic.repository.GenreRepository;
import ch.bfh.swos.jmusic.service.GenreService;
import ch.bfh.swos.jmusic.service.dto.GenreDTO;

@Named
public class DefaultGenreServiceImpl implements GenreService {

	@Inject
	private GenreRepository genreRepository;

	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public GenreDTO create(GenreDTO genre) {
		Genre entity = modelMapper.map(genre, Genre.class);
		entity = genreRepository.save(entity);
		return modelMapper.map(entity, GenreDTO.class);
	}

	@Override
	public GenreDTO read(long id) {
		Genre genre = genreRepository.findOne(id);
		if (genre != null) {
			return modelMapper.map(genre, GenreDTO.class);
		}
		return null;
	}

	@Override
	public Collection<GenreDTO> list() {
		Iterable<Genre> genreList = genreRepository.findAll();
		Type listType = new TypeToken<Collection<GenreDTO>>() {
		}.getType();

		return modelMapper.map(genreList, listType);
	}

	@Override
	public GenreDTO update(GenreDTO genre) {
		Genre entity = modelMapper.map(genre, Genre.class);
		entity = genreRepository.save(entity);
		return modelMapper.map(entity, GenreDTO.class);
	}

	@Override
	public void delete(GenreDTO genre) {
		Genre entity = genreRepository.findOne(genre.getId());
		genreRepository.delete(entity);
	}

}

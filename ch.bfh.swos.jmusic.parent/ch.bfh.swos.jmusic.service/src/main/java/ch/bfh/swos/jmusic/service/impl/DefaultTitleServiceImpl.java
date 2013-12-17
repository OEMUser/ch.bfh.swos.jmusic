package ch.bfh.swos.jmusic.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.swos.jmusic.model.Title;
import ch.bfh.swos.jmusic.repository.TitleRepository;
import ch.bfh.swos.jmusic.service.TitleService;
import ch.bfh.swos.jmusic.service.dto.TitleDTO;

@Named
public class DefaultTitleServiceImpl implements TitleService {

	@Inject
	private TitleRepository TitleRepository;

	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public TitleDTO create(TitleDTO Title) {
		Title entity = modelMapper.map(Title, Title.class);
		entity = TitleRepository.save(entity);
		return modelMapper.map(entity, TitleDTO.class);
	}

	@Override
	public TitleDTO read(long id) {
		Title Title = TitleRepository.findOne(id);
		if (Title != null) {
			return modelMapper.map(Title, TitleDTO.class);
		}
		return null;
	}

	@Override
	public Collection<TitleDTO> list() {
		Iterable<Title> TitleList = TitleRepository.findAll();
		Type listType = new TypeToken<Collection<TitleDTO>>() {
		}.getType();

		return modelMapper.map(TitleList, listType);
	}

	@Override
	public TitleDTO update(TitleDTO Title) {
		Title entity = modelMapper.map(Title, Title.class);
		entity = TitleRepository.save(entity);
		return modelMapper.map(entity, TitleDTO.class);
	}

	@Override
	public void delete(TitleDTO Title) {
		Title entity = TitleRepository.findOne(Title.getId());
		TitleRepository.delete(entity);
	}

}

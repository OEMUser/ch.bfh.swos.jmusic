package ch.bfh.swos.jmusic.repository;

import org.springframework.data.repository.CrudRepository;

import ch.bfh.swos.jmusic.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

}

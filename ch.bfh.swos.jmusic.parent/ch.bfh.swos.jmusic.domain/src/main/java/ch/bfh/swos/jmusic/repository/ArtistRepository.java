package ch.bfh.swos.jmusic.repository;

import org.springframework.data.repository.CrudRepository;

import ch.bfh.swos.jmusic.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long>{

}

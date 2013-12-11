package ch.bfh.swos.jmusic.repository;

import org.springframework.data.repository.CrudRepository;

import ch.bfh.swos.jmusic.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long>{

}

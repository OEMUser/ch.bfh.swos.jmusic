package ch.bfh.swos.jmusic.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.bfh.swos.jmusic.service.AlbumService;
import ch.bfh.swos.jmusic.service.dto.AlbumDTO;

@Controller
@RequestMapping("/album")
public class AlbumController {

	@Inject
	private AlbumService AlbumService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public AlbumDTO createAlbum(@RequestBody AlbumDTO Album) {
		AlbumDTO createdAlbum = AlbumService.create(Album);
		System.out.println("Album created with id = " + createdAlbum.getId());
		return createdAlbum;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<AlbumDTO> getAlbums() {
		System.out.println("Collection of Albums requested");
		return AlbumService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public AlbumDTO getAlbum(@PathVariable long id) {
		System.out.println("Album requested with id = " + id);
		return AlbumService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	public AlbumDTO updateAlbum(@RequestBody AlbumDTO Album,@PathVariable long id) {
		AlbumDTO updatedAlbum = AlbumService.update(Album);
		System.out.println("Album updated with id = " + updatedAlbum.getId());
		return updatedAlbum;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteAlbum(@PathVariable long id) {
		AlbumDTO Album = AlbumService.read(id);
		AlbumService.delete(Album);
		System.out.println("Delete Album with id = " + id);
	}
}

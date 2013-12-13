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

import ch.bfh.swos.jmusic.service.ArtistService;
import ch.bfh.swos.jmusic.service.dto.ArtistDTO;

@Controller
@RequestMapping("/artist")
public class ArtistController {

	@Inject
	private ArtistService artistService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ArtistDTO createArtist(@RequestBody ArtistDTO artist) {
		ArtistDTO createdArtist = artistService.create(artist);
		System.out.println("Artist created with id = " + createdArtist.getId());
		return createdArtist;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<ArtistDTO> getArtists() {
		System.out.println("Collection of Artists requested");
		return artistService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ArtistDTO getArtist(@PathVariable long id) {
		System.out.println("Artist requested with id = " + id);
		return artistService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	public ArtistDTO updateArtist(@RequestBody ArtistDTO artist,@PathVariable long id) {
		ArtistDTO updatedArtist = artistService.update(artist);
		System.out.println("Artist updated with id = " + updatedArtist.getId());
		return updatedArtist;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteArtist(@PathVariable long id) {
		ArtistDTO artist = artistService.read(id);
		artistService.delete(artist);
		System.out.println("Delete Artist with id = " + id);
	}
}

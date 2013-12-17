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

import ch.bfh.swos.jmusic.service.TitleService;
import ch.bfh.swos.jmusic.service.dto.TitleDTO;

@Controller
@RequestMapping("/title")
public class TitleController {

	@Inject
	private TitleService TitleService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public TitleDTO createTitle(@RequestBody TitleDTO Title) {
		TitleDTO createdTitle = TitleService.create(Title);
		System.out.println("Title created with id = " + createdTitle.getId());
		return createdTitle;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<TitleDTO> getTitles() {
		System.out.println("Collection of Titles requested");
		return TitleService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public TitleDTO getTitle(@PathVariable long id) {
		System.out.println("Title requested with id = " + id);
		return TitleService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	public TitleDTO updateTitle(@RequestBody TitleDTO Title,@PathVariable long id) {
		TitleDTO updatedTitle = TitleService.update(Title);
		System.out.println("Title updated with id = " + updatedTitle.getId());
		return updatedTitle;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteTitle(@PathVariable long id) {
		TitleDTO Title = TitleService.read(id);
		TitleService.delete(Title);
		System.out.println("Delete Title with id = " + id);
	}
}

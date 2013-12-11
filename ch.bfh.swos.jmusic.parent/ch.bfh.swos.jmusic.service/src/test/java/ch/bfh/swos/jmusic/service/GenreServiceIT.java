package ch.bfh.swos.jmusic.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.jmusic.service.dto.GenreDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class GenreServiceIT {

	@Inject
	private GenreService genreService;

	@Test
	public void test() {
		// Create
		GenreDTO newGenre = new GenreDTO();
		newGenre.setName("Test");
		newGenre = genreService.create(newGenre);

		// Read
		GenreDTO readGenre = genreService.read(newGenre.getId());
		Assert.assertTrue(newGenre.getName().equals(readGenre.getName()));

		// Update
		readGenre.setName("Test2");
		readGenre = genreService.update(readGenre);
		GenreDTO updatedGenre = genreService.read(readGenre.getId());
		Assert.assertTrue(readGenre.getName().equals(updatedGenre.getName()));

		// Delete
		genreService.delete(updatedGenre);
		GenreDTO deletedAuthor = genreService.read(readGenre.getId());
		Assert.assertNull(deletedAuthor);
	}

}

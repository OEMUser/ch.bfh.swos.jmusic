package ch.bfh.swos.jmusic.repository;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.jmusic.model.Genre;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class GenreRepositoryIT {

	@Inject
	private GenreRepository genreRepository;
	
	@Test
	public void test() {
		//Create
		Genre genre = new Genre();
		genre.setName("Hip Hop");
		
		genreRepository.save(genre);
		
		//Read
		Genre readGenre = genreRepository.findOne(genre.getId());
		Assert.assertEquals(genre.getName(), readGenre.getName());
		
		//Update
		readGenre.setName("Jazz");
		readGenre = genreRepository.save(readGenre);
		Genre updatedGenre = genreRepository.findOne(readGenre.getId());
		Assert.assertEquals(readGenre.getName(), updatedGenre.getName());
		
		//Delete
		genreRepository.delete(readGenre);
		Genre deletedGenre = genreRepository.findOne(readGenre.getId());
		Assert.assertNull(deletedGenre);
		
		
	}

}

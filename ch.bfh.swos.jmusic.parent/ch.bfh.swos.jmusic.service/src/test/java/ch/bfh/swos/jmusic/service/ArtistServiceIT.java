package ch.bfh.swos.jmusic.service;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.jmusic.service.dto.ArtistDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class ArtistServiceIT {

	@Inject
	private ArtistService artistService;

	@Test
	public void test() {
		// Create
		ArtistDTO newArtist = new ArtistDTO();
		newArtist.setName("Test");
//		newArtist.setBirthday(new Date());
//		System.out.println(newArtist.getBirthday());
		newArtist = artistService.create(newArtist);

		// Read
		ArtistDTO readArtist = artistService.read(newArtist.getId());
		Assert.assertTrue(newArtist.getName().equals(readArtist.getName()));

		// Update
		readArtist.setName("Test2");
		readArtist = artistService.update(readArtist);
		ArtistDTO updatedArtist = artistService.read(readArtist.getId());
		Assert.assertTrue(readArtist.getName().equals(updatedArtist.getName()));

		// Delete
		artistService.delete(updatedArtist);
		ArtistDTO deletedAuthor = artistService.read(readArtist.getId());
		Assert.assertNull(deletedAuthor);
	}

}

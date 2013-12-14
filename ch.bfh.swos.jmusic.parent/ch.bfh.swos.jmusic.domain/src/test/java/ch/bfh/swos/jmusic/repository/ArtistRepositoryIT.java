package ch.bfh.swos.jmusic.repository;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.jmusic.model.Artist;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class ArtistRepositoryIT {

	
	@Inject
	private ArtistRepository artistRepository;
	
	@Test
	public void test() {
		//Create
		Artist artist = new Artist();
		artist.setBirthday(new Date());
		artist.setName("Bob Marley");
		
		artistRepository.save(artist);
		
		
		//Read
		Artist readArtist = artistRepository.findOne(artist.getId());
		System.out.println("read: "+ readArtist.getBirthday());
		Assert.assertEquals(artist.getName(), readArtist.getName());
		
		//Update
		readArtist.setName("Eric Clapton");
		readArtist = artistRepository.save(readArtist);
		Artist updatedArtist = artistRepository.findOne(readArtist.getId());
		Assert.assertEquals(readArtist.getName(), updatedArtist.getName());
		
		//Delete
		artistRepository.delete(readArtist);
		Artist deletedArtist = artistRepository.findOne(readArtist.getId());
		Assert.assertNull(deletedArtist);
		
		
	}
	
}

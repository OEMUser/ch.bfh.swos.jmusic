package ch.bfh.swos.jmusic.model;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;

public class ReadIT {

	@Test
	public void test() {
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.jmusic.domain").createEntityManager();
		
		TypedQuery<Genre> genreQuery = em.createQuery("SELECT g FROM Genre g", Genre.class);
		List<Genre> genreList = genreQuery.getResultList();
		Assert.assertEquals(2, genreList.size());
		
		TypedQuery<Artist> artistQuery = em.createQuery("SELECT a FROM Artist a", Artist.class);
		Artist artist = artistQuery.getSingleResult();
		Assert.assertEquals("Eric Clapton", artist.getName());
		
		TypedQuery<Album> albumQuery = em.createQuery("SELECT a FROM Album a", Album.class);
		Album album = albumQuery.getSingleResult();
		Assert.assertEquals("Unplugged", album.getName());
		Assert.assertEquals(450, album.getPlaytime().intValue());
		
	}

}

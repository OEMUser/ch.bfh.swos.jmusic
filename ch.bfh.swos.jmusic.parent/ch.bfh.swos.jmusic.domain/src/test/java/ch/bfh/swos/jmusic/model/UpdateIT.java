package ch.bfh.swos.jmusic.model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;

public class UpdateIT {

	@Test
	public void test() {
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.jmusic.domain").createEntityManager();
		TypedQuery<Artist> artistQuery = em.createQuery(
				"SELECT a FROM Artist a", Artist.class);
		Artist artist = artistQuery.getSingleResult();

		em.getTransaction().begin();
		artist.setName("This is not Eric Clapton anymore");
		em.getTransaction().commit();

		Assert.assertEquals("This is not Eric Clapton anymore",
				artist.getName());
	}

}

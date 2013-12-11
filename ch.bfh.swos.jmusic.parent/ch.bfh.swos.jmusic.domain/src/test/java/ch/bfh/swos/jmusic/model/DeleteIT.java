package ch.bfh.swos.jmusic.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;

public class DeleteIT {

	@Test
	public void test() {
		
		//TODO: delete of foreign key
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.jmusic.domain").createEntityManager();
		TypedQuery<Genre> genreQuery = em.createQuery(
				"SELECT g FROM Genre g", Genre.class);
		List<Genre> genreList = genreQuery.getResultList();

		em.getTransaction().begin();
		
		for (Genre genre : genreList) {
			em.remove(genre);
		}
		em.getTransaction().commit();
		
		TypedQuery<Long> countQuery = em.createQuery("SELECT COUNT(g) FROM Genre g", Long.class);
		Assert.assertEquals(0L, countQuery.getSingleResult().longValue());
	}

}

package ch.bfh.swos.jmusic.model;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;

public class DeleteIT {

	@Test
	public void test() {

		// TODO: delete of foreign key

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.jmusic.domain").createEntityManager();
		TypedQuery<Genre> genreQuery = em.createQuery("SELECT g FROM Genre g",
				Genre.class);
		List<Genre> genreList = genreQuery.getResultList();
		TypedQuery<Album> albumQuery = em.createQuery("SELECT a FROM Album a",
				Album.class);
		List<Album> albumList = albumQuery.getResultList();
		TypedQuery<Title> titleQuery = em.createQuery("SELECT t FROM Title t",
				Title.class);
		List<Title> titleList = titleQuery.getResultList();
		TypedQuery<Artist> artistQuery = em.createQuery(
				"SELECT g FROM Artist g", Artist.class);
		List<Artist> artistList = artistQuery.getResultList();
		Sout1(artistList);
		Sout2(titleList);
		Sout3(albumList);
		Sout4(genreList);
		em.getTransaction().begin();

		for (Genre genre : genreList) {
			em.remove(genre);
		}
		for (Album album : albumList) {
			em.remove(album);
		}
		for (Title title : titleList) {
			em.remove(title);
		}
		for (Artist artist : artistList) {
			em.remove(artist);
		}
		em.getTransaction().commit();
		Sout1(artistList);
		Sout2(titleList);
		Sout3(albumList);
		Sout4(genreList);
		TypedQuery<Long> countQuery = em.createQuery(
				"SELECT COUNT(g) FROM Genre g", Long.class);
		Assert.assertEquals(0L, countQuery.getSingleResult().longValue());
	}

	private void Sout1(List<Artist> artists) {
		Iterator<Artist> artistIt = artists.iterator();
		System.out.print("artists: ");
		while (artistIt.hasNext()) {
			Artist tmpGenre = artistIt.next();
			System.out.print(tmpGenre.getName() + " "+tmpGenre.getBirthday()+";");
		}
		System.out.println();
	}

	private void Sout2(List<Title> titles) {
		Iterator<Title> titleIt = titles.iterator();
		System.out.print("titles: ");
		while (titleIt.hasNext()) {
			Title tmpGenre = titleIt.next();
			System.out.print(tmpGenre.getName() + " ");
		}
		System.out.println();
	}

	private void Sout3(List<Album> albums) {
		Iterator<Album> albumIt = albums.iterator();
		System.out.print("albums: ");
		while (albumIt.hasNext()) {
			Album tmpGenre = albumIt.next();
			System.out.print(tmpGenre.getName() + " ");
		}
		System.out.println();
	}

	private void Sout4(List<Genre> genres) {
		Iterator<Genre> genreIt = genres.iterator();
		System.out.print("genres: ");
		while (genreIt.hasNext()) {
			Genre tmpGenre = (Genre) genreIt.next();
			System.out.print(tmpGenre.getName() + " ");
		}
		System.out.println();
	}
}

package ch.bfh.swos.jmusic.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

public class CreateIT {

	@Test
	public void test() {
		Genre genre1 = new Genre();
		genre1.setName("Rock");
		Genre genre2 = new Genre();
		genre2.setName("Blue");

		List<Genre> genres = new ArrayList<>();
		genres.add(genre1);
		genres.add(genre2);
		
		Artist artist = new Artist();
		artist.setBirthday(new Date());
		artist.setName("Eric Clapton");
		List<Artist> artists = new ArrayList<>();
		artists.add(artist);
		
		
		Title title1 = new Title();
		title1.setLength(134);
		title1.setName("Before you accuse me");
		title1.setPublication(new Date());
		title1.setArtists(artists);
		
		Title title2 = new Title();
		title2.setLength(178);
		title2.setName("Hey Hey");
		title2.setPublication(new Date());
		title2.setArtists(artists);

		
		Title title3 = new Title();
		title3.setLength(154);
		title3.setName("Signe");
		title3.setPublication(new Date());
		title3.setArtists(artists);

		
		List<Title> titles = new ArrayList<>();
		titles.add(title1);
		titles.add(title2);
		titles.add(title3);

		
		Album album = new Album();
		album.setName("Unplugged");
		album.setPlaytime(450);
		
		album.setGenres(genres);
		album.setTitles(titles);
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.jmusic.domain").createEntityManager();

		em.getTransaction().begin();
		em.persist(album);
		em.getTransaction().commit();

	}

}

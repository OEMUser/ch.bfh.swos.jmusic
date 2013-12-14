package ch.bfh.swos.jmusic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
		genre2.setName("Blues");

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

		List<Album> albums = new ArrayList<>();
		Album album = new Album();
		album.setName("Unplugged");
		album.setPlaytime(450);

		album.setGenres(genres);
		album.setTitles(titles);
		albums.add(album);
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.jmusic.domain").createEntityManager();

		em.getTransaction().begin();
		em.persist(album);
		em.getTransaction().commit();
		Sout1(artists);
		Sout2(titles);
		Sout3(albums);
		Sout4(genres);
	}

	private void Sout1(List<Artist> artists) {
		Iterator<Artist> artistIt = artists.iterator();
		System.out.print("artists: ");
		while (artistIt.hasNext()) {
			Artist tmpGenre = artistIt.next();
			System.out.print(tmpGenre.getName()+" ");
		}
		System.out.println();
	}

	private void Sout2(List<Title> titles) {
		Iterator<Title> titleIt = titles.iterator();
		System.out.print("titles: ");
		while (titleIt.hasNext()) {
			Title tmpGenre = titleIt.next();
			System.out.print(tmpGenre.getName()+" ");
		}
		System.out.println();
	}

	private void Sout3(List<Album> albums) {
		Iterator<Album> albumIt = albums.iterator();
		System.out.print("albums: ");
		while (albumIt.hasNext()) {
			Album tmpGenre = albumIt.next();
			System.out.print(tmpGenre.getName()+" ");
		}
		System.out.println();
	}

	private void Sout4(List<Genre> genres) {
		Iterator<Genre> genreIt = genres.iterator();
		System.out.print("genres: ");
		while (genreIt.hasNext()) {
			Genre tmpGenre = (Genre) genreIt.next();
			System.out.print(tmpGenre.getName()+" ");
		}
		System.out.println();
	}
}

package harjoitustyo.Movies;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import harjoitustyo.Movies.domain.Genre;
import harjoitustyo.Movies.domain.GenreRepository;
import harjoitustyo.Movies.domain.Movie;
import harjoitustyo.Movies.domain.MovieRepository;
import harjoitustyo.Movies.domain.User;
import harjoitustyo.Movies.domain.UserRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTests {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private GenreRepository grepository;

	@Autowired
	private UserRepository urepository;

	@Test
	public void findByNameReturnMovie() {
		List<Movie> movies = repository.findByName("Titanic");

		assertThat(movies).hasSize(1);
		assertThat(movies.get(0).getDirector()).isEqualTo("James Cameron");
	}

	@Test
	public void createMovie() {
		Movie movie = new Movie("Annabelle", 2014 , new Genre("Kauhu"), "John R. Leonetti", 5);
				
		repository.save(movie);
		

	}

	@Test
	public void deleteMovie() {
		Movie movie = new Movie("Annabelle", 2014 , new Genre("Kauhu"), "John R. Leonetti", 5);
		
		repository.save(movie);
		assertThat(movie.getId()).isNotNull();
		Long movieId = movie.getId();
		repository.deleteById(movieId);

	}

	@Test
	public void findByNameReturnGenre() {
		List<Genre> genres = grepository.findByName("Comedy");

		assertThat(genres).hasSize(1);
	}

	@Test
	public void createNewGenre() {
		Genre genre = new Genre("Toiminta");
		grepository.save(genre);
	}

	@Test
	public void deleteCategory() {
		Genre genre = new Genre("Toiminta");
		grepository.save(genre);
		grepository.delete(genre);

	}

	

	@Test
	public void createNewUser() {
		User user2 = new User("user2", "salasana", "user@gmail.com",
				"USER");
		urepository.save(user2);
	}

	@Test
	public void deleteUser() {
		User user2 = new User("user2", "salasana", "user@gmail.com",
				"USER");
		urepository.save(user2);
		assertThat(user2.getId()).isNotNull();
		Long userId = user2.getId();
		urepository.deleteById(userId);

	}
}
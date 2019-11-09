package harjoitustyo.Movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.Movies.domain.Genre;
import harjoitustyo.Movies.domain.GenreRepository;
import harjoitustyo.Movies.domain.Movie;
import harjoitustyo.Movies.domain.MovieRepository;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Bean
	public CommandLineRunner movieSampleData(MovieRepository repository, GenreRepository grepository) {
		return (args) -> {
			
			grepository.save(new Genre("Toiminta"));
			grepository.save(new Genre("Komedia"));
			grepository.save(new Genre("Fantasia"));

			repository.save(new Movie("Titanic", 1990, grepository.findByName("Toiminta").get(0), 2));

		};
	}
}


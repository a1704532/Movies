package harjoitustyo.Movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.Movies.domain.Movie;
import harjoitustyo.Movies.domain.MovieRepository;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Bean
	public CommandLineRunner movieSampleData(MovieRepository repository) {
		return (args) -> {

			

			repository.save(new Movie("Titanic", 1990, "Komedia", 2));

		};
	}
}


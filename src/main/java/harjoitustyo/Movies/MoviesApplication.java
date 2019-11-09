package harjoitustyo.Movies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.Movies.domain.Genre;
import harjoitustyo.Movies.domain.GenreRepository;
import harjoitustyo.Movies.domain.Movie;
import harjoitustyo.Movies.domain.MovieRepository;


@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(MovieRepository repository, GenreRepository grepository) {
		return (args) -> {
			
			grepository.save(new Genre("Komedia"));
			grepository.save(new Genre("Fantasia"));
			grepository.save(new Genre("Toiminta"));
			
			
			
			repository.save(new Movie("Titanic", 1990, grepository.findByName("Komedia").get(0), 1));
			;	
		
			

		};
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}


package harjoitustyo.Movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import harjoitustyo.Movies.domain.Genre;
import harjoitustyo.Movies.domain.GenreRepository;
import harjoitustyo.Movies.domain.Movie;
import harjoitustyo.Movies.domain.MovieRepository;
import harjoitustyo.Movies.domain.UserRepository;


@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(MovieRepository repository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			
			grepository.save(new Genre("Comedy"));
			grepository.save(new Genre("Fantasy"));
			grepository.save(new Genre("Action"));
			grepository.save(new Genre("Drama"));
			grepository.save(new Genre("Horror"));
			
			
			
			repository.save(new Movie("Titanic", 1997, grepository.findByName("Drama").get(0), "James Cameron", 2));
			repository.save(new Movie("Lumikki ja metsästäjä", 2012, grepository.findByName("Fantasy").get(0), "Rupert Sanders", 5));
			repository.save(new Movie("Hohto", 1980, grepository.findByName("Horror").get(0), "Stanley Kubrick", 4));
			repository.save(new Movie("Zombieland 2", 2019, grepository.findByName("Comedy").get(0), "Ruben Fleischer", 3));
			repository.save(new Movie("Annabelle", 2014, grepository.findByName("Horror").get(0), "John R. Leonetti", 5));
	
		};
	}
	
	

	@Override
	public void run(String... args) throws Exception {

	}
}


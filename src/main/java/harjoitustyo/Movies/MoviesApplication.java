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
import harjoitustyo.Movies.domain.User;
import harjoitustyo.Movies.domain.UserRepository;


@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(MovieRepository repository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			
			grepository.save(new Genre("Komedia"));
			grepository.save(new Genre("Fantasia"));
			grepository.save(new Genre("Toiminta"));
			grepository.save(new Genre("Draama"));
			
			
			
			repository.save(new Movie("Titanic", 1997, grepository.findByName("Draama").get(0), 1));
			
			User user1 = new User("user", "$2a$10$nuHc9JW7ceOOOcR/b9i/hu/5ZHteDAS13pDb.j.7EIIPCrpjRB1P2",
					"user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$gmmjZHOL8X.0kCnpq/5sj.J0jLPo0SLoDAfFkwVClNmyCBGY6sWZ2",
					"admin@wippies.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		
			

		};
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}


package harjoitustyo.Movies.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import harjoitustyo.Movies.domain.GenreRepository;
import harjoitustyo.Movies.domain.Movie;
import harjoitustyo.Movies.domain.MovieRepository;
import harjoitustyo.Movies.domain.UserRepository;



@Controller
public class MovieController {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private GenreRepository grepository;
	
	@Autowired
	private UserRepository urepository;

	
	@GetMapping("/moviejson")
    public @ResponseBody List<Movie> movieListRest() {	
        return (List<Movie>) repository.findAll();
    }
	
	@GetMapping("/moviejson/{id}")
	public @ResponseBody Optional<Movie> findMovieRest(@PathVariable("id") Long movieId) {	
    	return repository.findById(movieId);
    } 

	
	@GetMapping({"/movies","/"})
	public String movieList(Model model) {
		model.addAttribute("movies", repository.findAll());

		return "movies";
	}


	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
		repository.deleteById(movieId);
		return "redirect:../movies";
	}

	@RequestMapping("/addmovie")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("genres", grepository.findAll());
		return "addmovie";
	}

	@PostMapping("/save")
	public String save(Movie movie) {
		repository.save(movie);
		return "redirect:movies";
	}

	@GetMapping("/edit/{id}")
    public String editMovie(@PathVariable("id") Long movieId, Model model) {
    	model.addAttribute("movie", repository.findById(movieId));
    	model.addAttribute("genres", grepository.findAll());
    	
    	return "editmovie";
    }
	
	@GetMapping("/login")
	public String login()  {
		
		return "login";
	}
}
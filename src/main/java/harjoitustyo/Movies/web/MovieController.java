package harjoitustyo.Movies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

	
	


	@GetMapping("/movies")
	public String bookList(Model model) {
		model.addAttribute("movies", repository.findAll());

		return "movies";
	}


	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
		repository.deleteById(movieId);
		return "redirect:../movies";
	}

	@RequestMapping(value = "/addmovie")
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

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editMovie(@PathVariable("id") Long movieId, Model model) {
    	model.addAttribute("movie", repository.findById(movieId));
    	model.addAttribute("genres", grepository.findAll());
    	
    	return "editmovie";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login()  {
		
		return "login";
	}
}
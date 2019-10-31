package harjoitustyo.Movies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import harjoitustyo.Movies.domain.Movie;
import harjoitustyo.Movies.domain.MovieRepository;


@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository repository;
	
	@GetMapping("/movies")
	public String bookList(Model model) {
		model.addAttribute("movies", repository.findAll());
		
		return "movies";
	}

}

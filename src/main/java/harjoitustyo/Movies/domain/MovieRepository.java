package harjoitustyo.Movies.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {   
}
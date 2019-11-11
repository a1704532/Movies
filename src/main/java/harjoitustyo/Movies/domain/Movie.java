package harjoitustyo.Movies.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int release;
	private int rating;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "genreid")
	private Genre genre;

	public Movie() {
	}

	public Movie(String name, int release, Genre genre, int rating) {
		super();
		this.name = name;
		this.release = release;
		this.rating = rating;
		this.release = release;

		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRelease() {
		return release;
	}

	public void setRelease(int release) {
		this.release = release;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", release=" + release + ", rating=" + rating + ", genre=" + genre
				+ "]";
	}
	
}
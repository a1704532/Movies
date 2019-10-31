package harjoitustyo.Movies.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nimi;
	private int julkaisuvuosi;
	private String genre;
	private int arviointi;
	
	public Movie() {}

	public Movie(String nimi, int julkaisuvuosi, String genre, int arviointi) {
		super();
		this.nimi = nimi;
		this.julkaisuvuosi = julkaisuvuosi;
		this.genre = genre;
		this.arviointi = arviointi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public int getJulkaisuvuosi() {
		return julkaisuvuosi;
	}

	public void setJulkaisuvuosi(int julkaisuvuosi) {
		this.julkaisuvuosi = julkaisuvuosi;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getArviointi() {
		return arviointi;
	}

	public void setArviointi(int arviointi) {
		this.arviointi = arviointi;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", nimi=" + nimi + ", julkaisuvuosi=" + julkaisuvuosi + ", genre=" + genre
				+ ", arviointi=" + arviointi + "]";
	}

}

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nimi;
	private int julkaisuvuosi;
	private String genre;
	private int arviointi;
	
	
	public Movie() {}

	public Movie (String nimi, int julkaisuvuosi, String genre, int arviointi) {
		super();
		this.nimi = nimi;
		this.julkaisuvuosi = julkaisuvuosi;
		this.genre = genre;
		this.arviointi = arviointi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public int getJulkaisuvuosi() {
		return julkaisuvuosi;
	}

	public void setJulkaisuvuosi(int julkaisuvuosi) {
		this.julkaisuvuosi = julkaisuvuosi;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getArviointi() {
		return arviointi;
	}

	public void setArviointi(int arviointi) {
		this.arviointi = arviointi;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", nimi=" + nimi + ", julkaisuvuosi=" + julkaisuvuosi + ", genre=" + genre
				+ ", arviointi=" + arviointi + "]";
	}
	
	
	
}*/
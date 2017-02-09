import java.io.Serializable;

/**
 * @author ��Ӱʵ����
 * 
 */

public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * ��Ӱ����
	 */
	private String movieName;
	/**
	 * ��ӰӢ������
	 */
	private String poster;
	/**
	 * ����
	 */
	private String director;
	/**
	 * ��Ա
	 */
	private String actor;
	/**
	 * ��Ӱ����
	 */
	private MovieType movieType;
	/**
	 * ��ӰƱ��
	 */
	private int price;

	public Movie() {
		super();
	}

	public Movie(String movieName, String poster, String director,
			String actor, MovieType movieType, int price) {
		super();
		this.movieName = movieName;
		this.poster = poster;
		this.director = director;
		this.actor = actor;
		this.movieType = movieType;
		this.price = price;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

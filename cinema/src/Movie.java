import java.io.Serializable;

/**
 * @author 电影实体类
 * 
 */

public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 电影名称
	 */
	private String movieName;
	/**
	 * 电影英文名称
	 */
	private String poster;
	/**
	 * 导演
	 */
	private String director;
	/**
	 * 演员
	 */
	private String actor;
	/**
	 * 电影类型
	 */
	private MovieType movieType;
	/**
	 * 电影票价
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

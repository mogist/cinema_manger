import java.io.Serializable;


public class ScheduleItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String time;

	private Movie movie;

	public ScheduleItem() {
		super();
	}

	public ScheduleItem(String time, Movie movie) {
		super();
		this.time = time;
		this.movie = movie;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		String objectString = "\t" + movie.getMovieName() + "\t"
				+ movie.getPoster() + "\t" + movie.getDirector() + "\t"
				+ movie.getActor() + "\t" + movie.getMovieType() + "\t"
				+ movie.getPrice() + "\t" + this.getTime() + "\t";
		return objectString;
	}
}
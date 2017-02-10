import java.io.Serializable;


public class Seat implements Serializable {

	private static final long serialVersionUID = 1L;

	private String seatNum;

	public Seat() {
		super();
	}

	public Seat(String seatNum) {
		super();
		this.seatNum = seatNum;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
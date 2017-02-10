import java.io.Serializable;

/**
 * @author 座位实体类
 * 
 */
public class Seat implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 座位号
	 */
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
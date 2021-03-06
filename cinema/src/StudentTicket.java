import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
/**
 * 学生票
 */
public class StudentTicket extends Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	private int discount;
	private Seat seat;
	private int price;
	private ScheduleItem scheduleItem;

	/**
	 * 计算票价
	 */
	public void compute() {
		price = this.scheduleItem.getMovie().getPrice() * discount / 10;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ScheduleItem getScheduleItem() {
		return scheduleItem;
	}

	public void setScheduleItem(ScheduleItem scheduleItem) {
		this.scheduleItem = scheduleItem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StudentTicket(Seat seat, int price, ScheduleItem scheduleItem,
			int discount) {
		this.discount = discount;
		this.seat = seat;
		this.price = price;
		this.scheduleItem = scheduleItem;
	}

	public StudentTicket() {
		super();
	}

	public StudentTicket(Seat seat, int price, ScheduleItem scheduleItem) {
		super(seat, price, scheduleItem);
	}

	/**
	 * 输出购买的电影票
	 */
	public void print() throws IOException {
		String[] name = this.scheduleItem.getTime().split(":");
		String fileName = "c:/ticket/"
				+ this.scheduleItem.getMovie().getMovieName() + "  "
				+ this.seat.getSeatNum() + "座" + "  " + name[0] + "点" + name[1]
				+ "分" + ".txt";
		FileWriter fs;
		try {
			fs = new FileWriter(fileName, true);
			BufferedWriter sw = new BufferedWriter(fs);
			sw.write("***************************");
			sw.newLine();
			sw.write("     青鸟影院 (学生)");
			sw.newLine();
			sw.write("---------------------------");
			sw.newLine();
			sw.write(" 电影名：" + this.scheduleItem.getMovie().getMovieName()
					+ "\t");
			sw.newLine();
			sw.write(" 时间：  " + this.scheduleItem.getTime() + "\t");
			sw.newLine();
			sw.write(" 座位号：" + this.seat.getSeatNum() + "\t");
			sw.newLine();
			sw.write(" 价格：  " + Integer.toString(this.price) + "\t");
			sw.newLine();
			sw.write("***************************");
			sw.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

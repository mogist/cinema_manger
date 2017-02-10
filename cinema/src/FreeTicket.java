import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
/**
 * 赠票
 */
public class FreeTicket extends Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	private Seat seat;
	private int price;
	private ScheduleItem scheduleItem;
	private String customerName;

	/**
	 * 计算票价
	 */
	public void compute() {
		this.price = 0;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FreeTicket(Seat seat, int price, ScheduleItem scheduleItem,
			String customerName) {
		this.seat = seat;
		this.price = price;
		this.scheduleItem = scheduleItem;
		this.customerName = customerName;
	}

	public FreeTicket() {
		super();
	}

	public FreeTicket(Seat seat, int price, ScheduleItem scheduleItem) {
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
			sw.write("     青鸟影院 (赠票)");
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
			sw.write(" 姓名：  " + this.customerName + "\t");
			sw.newLine();
			sw.write("***************************");
			sw.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
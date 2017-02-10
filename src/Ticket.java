import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	private Seat seat;
	private int price;
	private ScheduleItem scheduleItem;


	public void compute() {
		this.price = this.scheduleItem.getMovie().getPrice();
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

	public Ticket(Seat seat, int price, ScheduleItem scheduleItem) {
		this.seat = seat;
		this.price = price;
		this.scheduleItem = scheduleItem;
	}

	public Ticket() {
		super();
	}

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
			sw.write("        青鸟影院");
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

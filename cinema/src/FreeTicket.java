import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
/**
 * ��Ʊ
 */
public class FreeTicket extends Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	private Seat seat;
	private int price;
	private ScheduleItem scheduleItem;
	private String customerName;

	/**
	 * ����Ʊ��
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
	 * �������ĵ�ӰƱ
	 */
	public void print() throws IOException {
		String[] name = this.scheduleItem.getTime().split(":");
		String fileName = "c:/ticket/"
				+ this.scheduleItem.getMovie().getMovieName() + "  "
				+ this.seat.getSeatNum() + "��" + "  " + name[0] + "��" + name[1]
				+ "��" + ".txt";
		FileWriter fs;
		try {
			fs = new FileWriter(fileName, true);
			BufferedWriter sw = new BufferedWriter(fs);
			sw.write("***************************");
			sw.newLine();
			sw.write("     ����ӰԺ (��Ʊ)");
			sw.newLine();
			sw.write("---------------------------");
			sw.newLine();
			sw.write(" ��Ӱ����" + this.scheduleItem.getMovie().getMovieName()
					+ "\t");
			sw.newLine();
			sw.write(" ʱ�䣺  " + this.scheduleItem.getTime() + "\t");
			sw.newLine();
			sw.write(" ��λ�ţ�" + this.seat.getSeatNum() + "\t");
			sw.newLine();
			sw.write(" ������  " + this.customerName + "\t");
			sw.newLine();
			sw.write("***************************");
			sw.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
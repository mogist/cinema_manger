import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Cinema {

	private Seat seats;

	private Schedule schedule;

	private List<Ticket> soldTickets = new ArrayList<Ticket>();

	private ScheduleItem scheduleItem;

	public Seat getSeats() {
		return seats;
	}

	public void setSeats(Seat seats) {
		this.seats = seats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<Ticket> getSoldTickets() {
		return soldTickets;
	}

	public void setSoldTickets(ArrayList<Ticket> soldTickets) {
		this.soldTickets = soldTickets;
	}

	public ScheduleItem getScheduleItem() {
		return scheduleItem;
	}

	public void setScheduleItem(ScheduleItem scheduleItem) {
		this.scheduleItem = scheduleItem;
	}

	public Cinema(Seat seats, Schedule schedule, ArrayList<Ticket> soldTickets,
			ScheduleItem scheduleItem) {
		super();
		this.seats = seats;
		this.schedule = schedule;
		this.soldTickets = soldTickets;
		this.scheduleItem = scheduleItem;
	}

	public Cinema() {
		super();
	}

	public void save() throws FileNotFoundException, IOException {
		FileOutputStream fo = new FileOutputStream("c:/ticket/ticket.txt");
		ObjectOutputStream fs = new ObjectOutputStream(fo);
		fs.writeObject(soldTickets);
		fs.close();
		fo.close();
	}


	@SuppressWarnings("unchecked")
	public void load() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		File file = new File("c:/ticket");
		File file2 = new File("c:/ticket/ticket.txt");
		if (!file.exists()) {// 判断文件是否存在
			file.mkdirs();// 创建文件
		}

		if (file2.length() != 0) {
			FileInputStream fi = new FileInputStream("c:/ticket/ticket.txt");
			ObjectInputStream is = new ObjectInputStream(fi);
			soldTickets = (ArrayList<Ticket>) is.readObject();
			is.close();
			fi.close();
		}
	}
}
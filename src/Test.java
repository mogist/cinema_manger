import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Test {

	private String movieName = null;
	private String seatNum = null;
	private int discount = 0;
	private String customerName = null;
	private String time = null;
	private String type = null;
	private int price = 0;

	ScheduleItem item = new ScheduleItem();
	Cinema cinema = new Cinema();
	Schedule schedule = new Schedule();
	static Scanner input;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		Test test = new Test();

		boolean flags = true;
		while (flags == true) {
			try {
				test.loadSchedule();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			test.chooseName();
			test.chooseTime();
			test.chooseType();
			test.chooseSeat();

			try {
				test.checkTicket();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("输入数字0继续购票，其它任意数字键退出");
			input = new Scanner(System.in);
			if (input.nextInt() != 0) {
				flags = false;
			}
		}
	}

	public void loadSchedule() throws Exception {
		schedule.loadItems();
		cinema.setSchedule(schedule);
		List<ScheduleItem> items = cinema.getSchedule().getItems();
		System.out.println("序号\t电影名称\t英文名称\t导演\t演员\t电影类型\t价格\t时间\t");
		for (int i = 0; i < items.size(); i++) {
			item = (ScheduleItem) items.get(i);
			System.out.println(i + 1 + "." + item.toString());
		}
		System.out.println("下面为影院的座位结构图：");
		System.out.println("                                              屏幕");
		for (int k = 1; k < 6; k++) {
			for (int j = 1; j < 8; j++) {
				if (j != 7) {
					System.out.print(k + "-" + j + "   ");
				} else {
					System.out.println(k + "-" + j);
				}
			}
		}
	}
	
	public void chooseName() {
		System.out.print("请输入电影名称：");
		Boolean flag = true;
		input = new Scanner(System.in);
		while (flag == true) {
			movieName = input.next();
			List<ScheduleItem> items = schedule.getItems();
			for (int i = 0; i < items.size(); i++) {
				item = (ScheduleItem) items.get(i);
				if (item.getMovie().getMovieName().equals(movieName.trim())) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.println("电影名称有误，请重新输入电影名称：");
			}
		}
	}

	public void chooseTime() {
		System.out.println("请输入电影播放时间：以xx:xx的格式");
		Boolean flag = true;
		input = new Scanner(System.in);
		while (flag == true) {
			time = input.next();
			List<ScheduleItem> items = schedule.getItems();
			for (int i = 0; i < items.size(); i++) {
				item = (ScheduleItem) items.get(i);
				if (item.getMovie().getMovieName().equals(movieName)) {
					if(time.trim().contains("：")){
					String[] temp = time.split("：");
					time = temp[0]+":"+temp[1];	
					}
					if (item.getTime().equals(time.trim())) {
						price = item.getMovie().getPrice();
						flag = false;
						break;
					}
				}
			}
			if (flag == true) {
				System.out.println("请重输入正确的电影播放时间：");
			}
		}
	}

	public void chooseType() {
		System.out.println("请输入您所要购买的票的类型：1.普通票   2.学生票   3.赠送票");
		Boolean flag = true;
		int choice;
		input = new Scanner(System.in);
		while (flag == true) {
			choice = input.nextInt();
			switch (choice) {
			case 1:
				flag = false;
				type = "";
				break;
			case 2:
				System.out.println("请输入您所需要的折扣：1到9的整数");
				type = "student";
				while (1 == 1) {
					discount = input.nextInt();
					if (discount < 1 || discount > 9) {
						System.out.println("请输入1到9的整数");
					} else {
						break;
					}
				}
				flag = false;
				break;
			case 3:
				System.out.print("请输入赠票者的姓名:");
				customerName = input.next();
				customerName.trim();
				type = "free";
				flag = false;
				break;
			default:
				System.out.println("请输入1.2.3整数");
				break;
			}
		}
	}

	public void chooseSeat() {
		System.out.println("请输入您所需要的座位号：以排-列的形式");
		Boolean flag = true;
		StringBuilder number = new StringBuilder();
		input = new Scanner(System.in);
		while (flag == true) {
			seatNum = input.next();
			for (int k = 1; k < 6; k++) {
				for (int j = 1; j < 8; j++) {
					if (number.length() > 0) {
						number.delete(0, number.length());
					}
					number.append(k + "-" + j);
					if (seatNum.trim().equals(number.toString())) {
						flag = false;
						break;
					}
				}
			}
			if (flag == false) {
				break;
			} else {
				System.out.println("请输入正确的座位号");
			}
		}
	}

	public void checkTicket() throws IOException, ClassNotFoundException {
		cinema.load();
		if (cinema.getSoldTickets() != null) {
			Boolean flag = true;
			List<Ticket> list = cinema.getSoldTickets();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getSeat().getSeatNum().equals(seatNum)
						&& list.get(i).getScheduleItem().getTime().equals(time)
						&& list.get(i).getScheduleItem().getMovie()
								.getMovieName().equals(movieName)) {
					System.out.println("该票已售出，请重新购票");
					flag = false;
					break;
				}
			}
			if (flag == true) {
				Seat seat = new Seat();
				seat.setSeatNum(seatNum);
				cinema.setScheduleItem(item);
				TicketFactory ticketFactory = new TicketFactory();
				Ticket ticket = ticketFactory.createTicket(cinema
						.getScheduleItem(), seat, discount, customerName, type,
						price);
				cinema.getSoldTickets().add(ticket);
				cinema.save();
			}
		}
	}
}
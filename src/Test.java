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
			System.out.println("��������0������Ʊ�������������ּ��˳�");
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
		System.out.println("���\t��Ӱ����\tӢ������\t����\t��Ա\t��Ӱ����\t�۸�\tʱ��\t");
		for (int i = 0; i < items.size(); i++) {
			item = (ScheduleItem) items.get(i);
			System.out.println(i + 1 + "." + item.toString());
		}
		System.out.println("����ΪӰԺ����λ�ṹͼ��");
		System.out.println("                                              ��Ļ");
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
		System.out.print("�������Ӱ���ƣ�");
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
				System.out.println("��Ӱ�������������������Ӱ���ƣ�");
			}
		}
	}

	public void chooseTime() {
		System.out.println("�������Ӱ����ʱ�䣺��xx:xx�ĸ�ʽ");
		Boolean flag = true;
		input = new Scanner(System.in);
		while (flag == true) {
			time = input.next();
			List<ScheduleItem> items = schedule.getItems();
			for (int i = 0; i < items.size(); i++) {
				item = (ScheduleItem) items.get(i);
				if (item.getMovie().getMovieName().equals(movieName)) {
					if(time.trim().contains("��")){
					String[] temp = time.split("��");
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
				System.out.println("����������ȷ�ĵ�Ӱ����ʱ�䣺");
			}
		}
	}

	public void chooseType() {
		System.out.println("����������Ҫ�����Ʊ�����ͣ�1.��ͨƱ   2.ѧ��Ʊ   3.����Ʊ");
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
				System.out.println("������������Ҫ���ۿۣ�1��9������");
				type = "student";
				while (1 == 1) {
					discount = input.nextInt();
					if (discount < 1 || discount > 9) {
						System.out.println("������1��9������");
					} else {
						break;
					}
				}
				flag = false;
				break;
			case 3:
				System.out.print("��������Ʊ�ߵ�����:");
				customerName = input.next();
				customerName.trim();
				type = "free";
				flag = false;
				break;
			default:
				System.out.println("������1.2.3����");
				break;
			}
		}
	}

	public void chooseSeat() {
		System.out.println("������������Ҫ����λ�ţ�����-�е���ʽ");
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
				System.out.println("��������ȷ����λ��");
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
					System.out.println("��Ʊ���۳��������¹�Ʊ");
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
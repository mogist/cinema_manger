import java.io.IOException;


public class TicketFactory {

	private Ticket newTicket;


	public Ticket createTicket(ScheduleItem scheduleItem, Seat seat,
			int discount, String customerName, String type, int price)
			throws IOException {
		int choose;
		if (type.equals("student")) {
			choose = 1;
		} else if (type.equals("free")) {
			choose = 2;
		} else {
			choose = 3;
		}
		switch (choose) {
		case 1:
			StudentTicket studentTicket = new StudentTicket(seat, price,
					scheduleItem, discount);
			studentTicket.compute();
			newTicket = studentTicket;
			break;
		case 2:
			FreeTicket freeTicket = new FreeTicket(seat, price, scheduleItem,
					customerName);
			freeTicket.compute();
			newTicket = freeTicket;
			break;
		default:
			newTicket = new Ticket(seat, price, scheduleItem);
			newTicket.compute();
			break;
		}
		newTicket.print();
		System.out.println(" €∆±≥…π¶£°");
		return newTicket;
	}
}

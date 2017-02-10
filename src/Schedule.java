import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ScheduleItem> items;

	public List<ScheduleItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<ScheduleItem> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Schedule(ArrayList<ScheduleItem> items) {
		super();
		this.items = items;
	}

	public Schedule() {
		super();
	}


	public void loadItems() throws Exception {
		if (items == null) {
			items = new ArrayList<ScheduleItem>();
		}
		items.clear();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = (Document) db.parse("src/NewFile.xml");
		String movieName = null;
		String playBill = null;
		String director = null;
		String actor = null;
		String movieType = null;
		String price = null;
		NodeList list = doc.getElementsByTagName("Movie");
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeType() == 1) {
				Node tagNameBigNode = list.item(i);
				Element tagNameBigElement = (Element) tagNameBigNode;
				NodeList childList = tagNameBigElement.getChildNodes();
				for (int j = 0; j < childList.getLength(); j++) {
					if (childList.item(j).getNodeType() == 1) {
						Node tagNameSmallNode = childList.item(j);
						String choose = tagNameSmallNode.getNodeName();
						int choice;
						if (choose.equals("Name")) {
							choice = 1;
						} else if (choose.equals("Poster")) {
							choice = 2;
						} else if (choose.equals("Director")) {
							choice = 3;
						} else if (choose.equals("Actor")) {
							choice = 4;
						} else if (choose.equals("Type")) {
							choice = 5;
						} else if (choose.equals("Price")) {
							choice = 6;
						} else {
							choice = 7;
						}
						switch (choice) {
						case 1:
							movieName = tagNameSmallNode.getFirstChild()
									.getNodeValue();
							break;
						case 2:
							playBill = tagNameSmallNode.getFirstChild()
									.getNodeValue();
							break;
						case 3:
							director = tagNameSmallNode.getFirstChild()
									.getNodeValue();
							break;
						case 4:
							actor = tagNameSmallNode.getFirstChild()
									.getNodeValue();
							break;
						case 5:
							movieType = tagNameSmallNode.getFirstChild()
									.getNodeValue();
							break;
						case 6:
							price = tagNameSmallNode.getFirstChild()
									.getNodeValue();
							break;
						case 7:
							Element tagNameSmallElement = (Element) tagNameSmallNode;
							NodeList childListTwo = tagNameSmallElement
									.getChildNodes();
							for (int k = 0; k < childListTwo.getLength(); k++) {
								if (childListTwo.item(k).getNodeType() == 1) {
									Node tagNameSmallTwoNode = childListTwo
											.item(k);
									ScheduleItem item = new ScheduleItem();
									Movie movie = new Movie();
									item.setMovie(movie);
									item.setTime(tagNameSmallTwoNode
											.getFirstChild().getNodeValue());
									item.getMovie().setMovieName(movieName);
									item.getMovie().setPoster(playBill);
									item.getMovie().setDirector(director);
									item.getMovie().setActor(actor);
									item.getMovie().setMovieType(
											Enum.valueOf(MovieType.class,
													movieType));
									item.getMovie().setPrice(
											Integer.parseInt(price));
									items.add(item);
								}
							}
							break;
						}
					}
				}
			}
		}
	}
}

package hust.soict.dsai.test.media;
import java.util.List;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class ToStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Media> mediae = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 69.420f); 
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		Book book = new Book("Sherlock Holmes", "Detective", 420, 5f);
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
	}
}

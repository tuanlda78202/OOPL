package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public int compare(Media m1, Media m2) {
		if (m1.getCost() < m2.getCost()) {
			return 1;
		} else if (m1.getCost() > m2.getCost()) {
			return -1;
		} else {
			return m1.getTitle().compareToIgnoreCase(m2.getTitle());
		}
	}
}
   
package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// Creating the store
		Store myStore = new Store();

		// Creating DVDs
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		// Adding DVDs
		myStore.addDVD(dvd2, 5);
		myStore.addDVD(dvd2, dvd1, dvd3, dvd1, dvd1);
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
		int[] correspondingQuantity = {4,7,2};
		myStore.addDVD(dvdList, correspondingQuantity);
		myStore.print();

		// Removing DVDs
		myStore.removeDVD(dvd1, 2);
		myStore.removeDVD(dvd3,dvd2,dvd1,dvd2);
		DigitalVideoDisc[] dvdList2 = {dvd1, dvd2, dvd3};
		int[] correspondingQuantity2 = {2,3,1};
		myStore.removeDVD(dvdList2, correspondingQuantity2);
		myStore.print();
	}
}
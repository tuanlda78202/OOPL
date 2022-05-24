package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;
public class Store {
	private Object[][] itemsInStore = {null};
	private List<Media> itemsInStoreM = new ArrayList<Media>();

	public void addDVD(DigitalVideoDisc disc, int quantity) {
		if (disc.getID()+1 > itemsInStore.length) {
			itemsInStore = Arrays.copyOf(itemsInStore, disc.getID()+1);
		}
		if (itemsInStore[disc.getID()] == null) {
			Object[] dvds = {disc, quantity};
			itemsInStore[disc.getID()] = dvds;
		} else {
			itemsInStore[disc.getID()][1] = (int) itemsInStore[disc.getID()][1] + quantity;
		}
		System.out.println(Integer.toString(quantity) + " copies of " + disc.getTitle() + " have been added to the store");
	}

	public void addDVD(DigitalVideoDisc... dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			this.addDVD(dvdList[i], 1);
		}
	}

	public void addDVD(DigitalVideoDisc[] dvdList, int[] correspondingQuantity) {
		for (int i=0; i < dvdList.length; i++) {
			this.addDVD(dvdList[i], correspondingQuantity[i]);
		}
	}

	public void removeDVD(DigitalVideoDisc disc, int quantity) {
		if (disc.getID()+1 > itemsInStore.length || itemsInStore[disc.getID()] == null) {
			System.out.println(disc.getTitle() + " is not avaiable in store.");
		} else {
			int remaining = (int) itemsInStore[disc.getID()][1];
			if (quantity > remaining) {
				System.out.println("There are not enough " + disc.getTitle() + " left to remove");
			} else {
				remaining -= quantity;
				if (remaining == 0) {
					itemsInStore[disc.getID()] = null;
				} else {
					itemsInStore[disc.getID()][1] = remaining;
					System.out.println(Integer.toString(quantity) + " copies of " + disc.getTitle() + " have been removed from the store.");
				}
			}
		}
	}

	public void removeDVD(DigitalVideoDisc... dvdList) {
		for (int i=0; i < dvdList.length; i++) {
			this.removeDVD(dvdList[i], 1);
		}
	}

	public void removeDVD(DigitalVideoDisc[] dvdList, int[] correspondingQuantity) {
		for (int i=0; i < dvdList.length; i++) {
			this.removeDVD(dvdList[i], correspondingQuantity[i]);
		}
	}

	public boolean addMedia(Media medium) {
		if (this.itemsInStoreM.contains(medium)) {
			System.out.println(medium.getTitle() + " is already available at the store.");
			return false;
		} else {
			this.itemsInStoreM.add(medium);
			System.out.println(medium.getTitle() + " has been added to the store.");
		}
		return true;
	}
	
	public boolean removeMedia(Media medium) {
		if (this.itemsInStoreM.remove(medium)) {
			System.out.println(medium.getTitle() + " has been removed from the store.");
			return true;
		} else {
			System.out.println(medium.getTitle() + " is not available at the store.");
			return false;
		}
	}
	
	public Media searchMedia(String title) {
		for (Media medium: this.itemsInStoreM) {
			if (medium.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return medium;
			}
		}
		return null;
	}
	public void print() {
		System.out.println("\n");
		System.out.println("*************AVAILABLE DVDs IN STORE***************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsInStore.length; i++) {
			DigitalVideoDisc disc = (DigitalVideoDisc) itemsInStore[i][0];
			int quantity = (int) itemsInStore[i][1];
			Object[] detail = disc.getDetail();
			System.out.println(Integer.toString(quantity) + "x" + "\t" + detail[0]
					+ "\t" + "-" + "\t" + detail[1]
					+ "\t" + "-" + "\t" + detail[2]
					+ "\t" + "-" + "\t" + detail[3]
					+ "\t" + "-" + "\t" + detail[4] + " minutes"
					+ ":" + "\t" + "$" + detail[5]);
		}
		System.out.println("***************************************************");
		System.out.println("\n");
	}

}
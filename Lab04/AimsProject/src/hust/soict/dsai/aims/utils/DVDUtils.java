package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class DVDUtils {

	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {

		String title = dvd1.getTitle();
		String category = dvd1.getCategory();
		String director =dvd1.getDirector();
		int length= dvd1.getLength();
		float cost= dvd1.getCost();
		
		dvd1.setTitle(dvd2.getTitle());
		dvd1.setCategory(dvd2.getCategory());
		dvd1.setDirector(dvd2.getDirector());
		dvd1.setLength(dvd2.getLength());
		dvd1.setCost(dvd2.getCost());
		
		dvd2.setTitle(title);
		dvd2.setCategory(category);
		dvd2.setDirector(director);
		dvd2.setLength(length);
		dvd2.setCost(cost);
	}

	public static String compareByCost(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
	{
		String s;
		if( dvd1.getCost() > dvd2.getCost()) s = "---Cost of " + dvd1.getTitle() + " more than " + dvd2.getTitle();
		else if( dvd1.getCost() == dvd2.getCost()) s = "---Cost of " + dvd1.getTitle() + " equal to " + dvd2.getTitle();
		else s = "---Cost of " + dvd1.getTitle()+" less than " + dvd2.getTitle();
		return s;
	}
	
	public static String compareByTitle(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
	{
		String s;
		if( dvd1.getTitle().compareTo(dvd2.getTitle()) > 0) s= "---Title of " + dvd1.getTitle() + " stand before " + dvd2.getTitle();
		else if( dvd1.getTitle().compareTo(dvd2.getTitle()) == 0) s= "---Title of " + dvd1.getTitle()+" is the same with " + dvd2.getTitle();
		else s = "---Title of " + dvd1.getTitle()+" stand after " + dvd2.getTitle();
		return s;
	}

	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvd) {
	    for (int i = 0; i < dvd.length - 1; i++){
	    	int minIndex = i;
	    	for (int j = i+1; j < dvd.length; j++)
	    		if (dvd[j].getCost() > dvd[minIndex].getCost())
	    			minIndex = j;
	    			swap(dvd[minIndex], dvd[i]);
	    }
	    return dvd;
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvd) {
	    for (int i = 0; i < dvd.length - 1; i++){
	    	int minIndex = i;
	    	for (int j = i+1; j < dvd.length; j++)
	    		if (dvd[j].getTitle().compareTo(dvd[minIndex].getTitle()) < 0)
	    			minIndex = j;
	    			swap(dvd[minIndex], dvd[i]);
	    }
	    return dvd;
	}
}

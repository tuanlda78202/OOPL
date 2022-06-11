package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
//		swap(jungleDVD, cinderellaDVD);
//		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
//		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		DVDWrapper jungleDVDWrapper = new DVDWrapper(jungleDVD);
		DVDWrapper cinderellaDVDWrapper = new DVDWrapper(cinderellaDVD);
		swap(jungleDVDWrapper, cinderellaDVDWrapper);
		System.out.println("jungle dvd title: " + jungleDVDWrapper.disc.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVDWrapper.disc.getTitle());
	}
	
//	public static void swap(Object o1, Object o2) {
//		Object tmp = o1;
//		o1 = o2;
//		o2 = tmp;
//	}
	
//	public static void changeTitle(DigitalVideoDisc dvd, String title) {
//		String oldTitle = dvd.getTitle();
//		dvd.setTitle(title);
//		dvd = new DigitalVideoDisc(oldTitle);
//	}
	
	public static void swap(DVDWrapper ow1, DVDWrapper ow2) {
		DigitalVideoDisc temp = ow1.disc;
		ow1.disc = ow2.disc;
		ow2.disc = temp;
	}
}

class DVDWrapper {
	DigitalVideoDisc disc;
	
	DVDWrapper(DigitalVideoDisc disc) {
		this.disc = disc;
	}
}   
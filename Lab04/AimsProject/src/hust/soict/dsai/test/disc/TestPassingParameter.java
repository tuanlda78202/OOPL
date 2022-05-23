package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter { 

    public static void main(String[] args)  { 
    // Auto-generated method stub 
    DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
    DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

    
    swap(jungleDVD, cinderellaDVD);
    System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

    changeTittle(jungleDVD, cinderellaDVD.getTitle());
    System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
    
    public static void swap(Object o1, Object o2) { 
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTittle(DigitalVideoDisc dvd, String title) { 
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

}


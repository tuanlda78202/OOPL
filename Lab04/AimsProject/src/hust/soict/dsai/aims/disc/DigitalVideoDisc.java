package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getID() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setID(int id) {
		this.id = id;
	}

	public Object[] getDetail() {
		Object[] detail = {this.getID(), this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost()};
		return detail;
	}
	public DigitalVideoDisc(String title) {
		this.title = title;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
	}
	public DigitalVideoDisc(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
	}   
	public boolean isEquals(DigitalVideoDisc disc) {
		return (this.title == disc.getTitle());
	}
	
	public boolean search(String title) {
		return this.title == title;
	}
}

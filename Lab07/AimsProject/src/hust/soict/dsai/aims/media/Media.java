package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media {
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	private int id;
	private static int nbMedia = 1;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public boolean equals(Object medium) {
		if (medium instanceof Media) {
			try {
				Media that = (Media) medium;
				return this.title.toLowerCase().equals(that.getTitle().toLowerCase());
			} catch (NullPointerException e1) {
				return false;
			} catch (ClassCastException e2) {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean search(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}


	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public Media(String title) {
		super();
		this.title = title;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public int getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}


	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public void setDateAdded(LocalDate date) {
		this.dateAdded = date;
	}
	
	public abstract String getType();
	
	public abstract String getDetails();
	
	public String toString() {
		return this.getDetails();
	}

}

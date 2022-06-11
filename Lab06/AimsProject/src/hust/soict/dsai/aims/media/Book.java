package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private int contentLength;
	private List<String> authors = new ArrayList<String>();
	
	public boolean addAuthor(String authorName) {
		for (String name: this.authors) {
			if (name.toLowerCase().equals(authorName.toLowerCase())) {
				System.out.println(name + " is already in the list of authors.");
				return false;
			}
		}
		this.authors.add(authorName);
		System.out.println(authorName + " has been added to the " + this.getTitle() + " list of authors.");
		return true;
	}
	
	
	public boolean removeAuthor(String authorName) {
		for (String name: this.authors) {
			if (name.toLowerCase().equals(authorName.toLowerCase())) {
				this.authors.remove(name);
				System.out.println(name + " has been removed from the " + this.getTitle() + " list of authors.");
				return true;
			}
		}
		System.out.println(authorName + " is not in the list of authors.");
		return false;
	}
	
	public String getType() {
		return "Book";
	}
	
	public String getDetails() {
		StringBuffer authorsList = new StringBuffer();
		if (this.authors.size() >= 1) {
			authorsList.append(this.authors.get(0));
			for (int i = 1; i < this.authors.size(); i++) {
				authorsList.append(", " + this.authors.get(i));
			}
		}
		return ("Product ID: " + String.valueOf(this.getID())
		+ "\n" + "\t" + "Title: " + this.getTitle()
		+ "\n" + "\t" + "Category: " + this.getCategory()
		+ "\n" + "\t" + "Authors: " + authorsList
		+ "\n" + "\t" + "Content Length: " + String.valueOf(this.getContentLength()) + " pages"
		+ "\n" + "\t" + "Price: $" + String.valueOf(this.getCost()));
	}
	
	public Book(String title, String category, int contentLength, float cost) {
		super(title, category, cost);
		this.contentLength = contentLength;
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public int getContentLength() {
		return contentLength;
	}

}
    
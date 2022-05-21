package aims;

public class DigitalVideoDisc { 
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;   

    // Accessors and Mutators for DVD class
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

    // Constructor Method 
    // super() can be used to invoke immediate parent class constructor.
    // "this" is used to refer current-class’s instance as well as static members
    public DigitalVideoDisc(String title) { 
        super();
        this.title = title;
    }
 
    public DigitalVideoDisc(String title, String category, float cost) { 
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) { 
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) { 
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Check boolean equal Title
    public boolean equalTitle(DigitalVideoDisc disc) {
		return (this.title == disc.getTitle());
	}
}
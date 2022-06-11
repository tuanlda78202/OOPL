package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	public boolean equals(Object track) {
		if (track instanceof Track) {
			Track that = (Track) track;
			if ((this.length == that.length) && (this.title.toLowerCase().equals(that.getTitle().toLowerCase()))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("The track " + this.getTitle() + " cannot be played.");
		} else {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public Track(String title) {
		super();
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
}
   
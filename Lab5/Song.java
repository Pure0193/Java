
public class Song {
	private String title;
	private double duration;
	
	public Song(String title, double duration) {
		this.title=title;
		this.duration=duration;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public int getDurationInSec() {
		double x=duration*100;
		int sec=(int)x%100;
		int min=(int)x/100;
		return min*60 + sec;
	}
	
	public String toString() {
		return title+", "+getDuration()+" minutes ("+getDurationInSec()+" seconds)";
	}
}

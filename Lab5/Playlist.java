import java.util.ArrayList;
import java.util.Collections;

// Name:Sorawit Ongsiriporn
// ID:6288030

public class Playlist {

	private String name;
	private int duration;
	private ArrayList<Song> songs=new ArrayList<Song>();
	
	public Playlist(String name) {
		this.name=name;
	}
	
	public void addSong(Song aSong) {
		songs.add(aSong);
	}
	
	public void addSongAtIndex(Song aSong, int index) {
		if(index<songs.size()) {
			songs.add(index,aSong);
		}
		else {
			System.out.printf("Error: Couldn't add song at index %d\n",index);
		}
	}
	
	public boolean removeSongByIndex(int index) {
		if(index<songs.size()) {
			songs.remove(index);
			return true;
		}
		else {
			System.out.printf("Error: The index is invalid\n");
			return false;
		}
	}	
	
	public boolean removeSongByTitle(String title) {
		for(int i=0;i<songs.size();i++) {
			if(songs.get(i).getTitle().compareTo(title)==0) {
				songs.remove(i);
				return true;
			}
		}
		System.out.println("Error: The title is not found");
		return false;
	}
	
	public void moveUp(int current) {
		Collections.swap(songs, current, current-1);
	}
	
	public void moveDown(int current) {
		Collections.swap(songs, current, current+1);
	}
	
	public int getPlaylistDuration() {
		this.duration=0;
		for(int i=0;i<songs.size();i++) {
			this.duration+=songs.get(i).getDurationInSec();
		}
		return this.duration;
	}	
	
	public void showPlaylist() {
		System.out.println(name);
		for(int i=0;i<songs.size();i++) {
			System.out.println("["+i+"] "+songs.get(i));
		}
		System.out.printf("Total Duration is %d.%d minutes\n",getPlaylistDuration()/60,getPlaylistDuration()%60);
	}
}
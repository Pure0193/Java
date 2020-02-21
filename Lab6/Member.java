import java.util.ArrayList;

public class Member {
	public ArrayList<Video> vdoList=new ArrayList<Video>();
	public String email,password;
	
	public Member(String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	public boolean addVideo(Video vdo) {
		if(vdo != null) {
			vdoList.add(vdo);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeVideo(Video vdo) {
		for(int i=0;i<vdoList.size();i++) {
			if(vdo.isEqual(vdoList.get(i))) {
				System.out.println(vdoList.get(i));
				System.out.println("is successfully removed.");
				vdoList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void printMemberInfo() {
		System.out.println("Email: "+email+" (pwd: "+password+")");
		System.out.println("List of Videos");
		for(int i=0;i<vdoList.size();i++) {
			System.out.println("["+(i+1)+"]"+vdoList.get(i));
		}
		System.out.println("---------------------");
	}
	
}

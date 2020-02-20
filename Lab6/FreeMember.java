
public class FreeMember extends Member {
	public int FREE_LIMITED_VDOs=3;
	public int numDownloadedVDO;
	
	public FreeMember(String email, String password) {
		super(email, password);
	}
	
	public boolean addVideo(Video vdo) {
		if(getNumVideo()<FREE_LIMITED_VDOs) {
			super.addVideo(vdo);
			return true;
		}else {
			System.out.println(vdo.toString());
			System.out.println("cannot be downloaded because the number of video is reaching the limit.");
		}
		return false;
	}
	
	public boolean removeVideo(Video vdo) {
		super.removeVideo(vdo);
		return true;
	}
	
	public void printMemberInfo() {
		System.out.println("---- FREE MEMBER ----");
		super.printMemberInfo();
	}
	
	int getNumVideo() {
		return vdoList.size();
	}
	
}

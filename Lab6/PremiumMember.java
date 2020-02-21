import java.util.ArrayList;

public class PremiumMember extends Member{
	public double fee;
	public double Family_FEE=80.00;
	ArrayList<String> family=new ArrayList<String>();

	public PremiumMember(String email, String password,double fee) {
		super(email, password);
		this.fee=fee;
	}

	public void printMemberInfo() {
		System.out.println("---- PREMIUM MEMBER ----");
		System.out.println("Member Fee: "+fee);
		super.printMemberInfo();

		// For family override
		if(family.size()>0) {
			System.out.println("List of Family");
			for(int i=0;i<family.size();i++) {
				System.out.printf("%s, ",family.get(i));
			}
			System.out.println();
		}

	}

	public boolean addFamily(String username) {
		if(username != null && family.size()<2) {
			family.add(username);
			System.out.println(username+" is added successfully.");
			return true;
		}else {
			System.out.println("user: "+username+" cannot be added, the Family user is reached the limit");
			return false;
		}
	}

	public boolean removeFamily(String username) {
		for(int i=0;i<family.size();i++) {
			if(username.compareTo(family.get(i))==0){
				family.remove(i);
				System.out.println(username+" is removed successfully.");
				return true;
			}
		}
		System.out.println("user: "+username+" does not exits and cannot be removed.");
		return false;
	}

	public double getMonthlyBill() {
		return fee+Family_FEE;
	}

}

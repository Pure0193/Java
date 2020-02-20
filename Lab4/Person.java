
public class Person {
	public String firstname,lastname;
	public MyDate birthday;
	
	public Person(String aFirstname, String aLastname) {
		this.firstname = aFirstname;
		this.lastname = aLastname;
		this.birthday = new MyDate();
	}
	
	public Person(String aFirstname, String aLastname, int aYear, int aMonth, int aDay) {
		this.firstname = aFirstname;
		this.lastname = aLastname;
		this.birthday = new MyDate(aYear,aMonth,aDay);
	}
	
	public int getAge(MyDate aDate) {
		return birthday.yearDiff(birthday,aDate);
	}
	
	public boolean isEligible(MyDate elecDate) {
		if(getAge(elecDate)>=18) {
			return true;
		}else {
			return false;
		}
	}
	
	public void printPersonInfo() {
		System.out.printf("Person: %s %s\n",firstname,lastname);
		System.out.printf("Birthday: %s\n",birthday.toString());
	}
}

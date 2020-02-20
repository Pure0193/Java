import java.util.Scanner;

public class ElectionTester {
	public static void main(String[] args) {
		MyDate election = new MyDate(2019, 3, 24);
		
		Person a = new Person("Lalisa", "Manoban", 1997, 3, 27);
		printPersonElectionInfo(a, election);
		
		Person b = new Person("Nuda", "Inter", 2012, 1, 16);
		printPersonElectionInfo(b, election);
		
		// Create another Person object with your information
		// Print your information, age, and election eligibility.
		
		/*
		 * YOUR CODE GOES HERE
		 */
		
		Person c = new Person("Sorawit", "Ongsiriporn", 2001, 1, 18);
		printPersonElectionInfo(c, election);
		
		// Write a program to take 3 persons information from the user
		// (Hint: Use scanner and for loop to get input)
		
		/*
		 * YOUR CODE GOES HERE
		 */
		Person [] human=new Person[1000];
		for(int i=0;i<3;i++) {
			human[i]=new Person(null, null, 0, 0, 0);
			Scanner in = new Scanner(System.in);
			System.out.print("Enter firstname: ");
			human[i].firstname=in.nextLine();
			System.out.print("Enter lastname: ");
			human[i].lastname=in.nextLine();
			System.out.print("Enter year of birthday: ");
			human[i].birthday.year=in.nextInt();
			System.out.print("Enter month of birthday: ");
			human[i].birthday.month=in.nextInt();
			System.out.print("Enter day of birthday: ");
			human[i].birthday.day=in.nextInt();
			printPersonElectionInfo(human[i], election);
		}
		
		// Challenge Bonus
		// Instead of taking 3 persons' information, write a program to continuously take input from the user
		// until the user types 'q' to quite the program.
		
		/*
		 * YOUR CODE GOES HERE
		 */
		int k=3;
		do {
			human[k]=new Person(null, null, 0, 0, 0);
			Scanner in = new Scanner(System.in);
			System.out.print("Enter firstname or type 'q' to exit: ");
			human[k].firstname=in.nextLine();
			if(human[k].firstname.compareTo("q")==0) {
				System.out.println("Exit the program. Thank you.");
				break;
			}
			System.out.print("Enter lastname: ");
			human[k].lastname=in.nextLine();
			System.out.print("Enter year of birthday: ");
			human[k].birthday.year=in.nextInt();
			System.out.print("Enter month of birthday: ");
			human[k].birthday.month=in.nextInt();
			System.out.print("Enter day of birthday: ");
			human[k].birthday.day=in.nextInt();
			printPersonElectionInfo(human[k], election);
			k++;
		} while(true);
		
		
	}
	
	public static void printPersonElectionInfo(Person p, MyDate election) {
		p.printPersonInfo();
		System.out.println("Age: " + p.getAge(election));
		if(p.isEligible(election))
			System.out.println("This person is eligible to vote.");
		else
			System.out.println("This person is NOT eligible to vote");
		
		System.out.println("-----------------------------------");
	}
}

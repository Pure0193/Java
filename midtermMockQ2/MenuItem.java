//Name:Sorawit Ongsiriporn
//ID:6288030
//Section:3

public class MenuItem {
	private String name;
	private double price;
	private int calorie;

	public MenuItem(String _name, double _price, int _calorie) {
		this(_name,_price);
		this.calorie = _calorie;
	}

	public MenuItem(String _name, double _price) {
		this.name = _name;
		this.price = _price;
		this.calorie = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getCalorie() {
		return calorie;
	}
	
	public double increasePrice(int percent) {
		return price+(price*percent/100);
	}
}


public class Circle extends Shape {
	//attributes
	private final double pie=3.14;
	private double radius;

	// Constructors
	public Circle()
	{
		//add your code here
		radius=0;
	}
	public Circle(String color, double radius) {
		//add your code here
		super(color);
		this.radius=radius;
	}

	@Override
	public String toString() {
		//add your code here
		return "Circle[radius="+radius+","+super.toString();
	}

	// Override the inherited getArea() to provide the proper implementation
	@Override
	public double getArea() {
		//add your code here
		return pie*radius*radius;
	}

	public double getArea(double radius) {
		//add your code here
		this.radius=radius;
		return pie*radius*radius;
	}
}

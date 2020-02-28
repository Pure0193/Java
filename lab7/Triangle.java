

/*  The structure of Triangle class is similar to Rectangle */
public class Triangle extends Shape {


	//add your code here
	private double base,height;

	// Constructors
	public Triangle()
	{
		//add your code here
		base=0;
		height=0;
	}
	public Triangle(String color, double base, double height) {
		//add your code here
		super(color);
		this.base=base;
		this.height=height;
	}

	@Override
	public String toString() {
		//add your code here
		return "Triangle[base="+base+",height="+height+","+super.toString();
	}

	// Override the inherited getArea() to provide the proper implementation
	@Override
	public double getArea() {
		//add your code here
		return 0.5*base*height;
	}

	public double getArea(double base, double height) {
		//add your code here
		this.base=base;
		this.height=height;
		return 0.5*base*height;
	}
}

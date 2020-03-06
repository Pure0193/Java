//Name:Sorawit Ongsiriporn
//ID:6288030
//Section:3
public class BottleOfMilk extends Item{

	private double originalVolume = 0;		//ml
	private double currentVolume = 0;
	
	public BottleOfMilk(double _purchasePrice, double _age, double weight, double _volume) {
		super(_purchasePrice, _age, weight);
		originalVolume = _volume;
		currentVolume =originalVolume;
	}

	@Override
	public double getCurrentValue() {
		return getPurchasePrice()*currentVolume/originalVolume;
	}
	
	@Override
	public String toString()
	{
		return "[Milk"+": Value = "+String.format( "%.2f", this.getCurrentValue())+" Baht, Milk left = "+getVolume()+" ml]";
	}
	
	public void drink(double vol)
	{
		System.out.println("Drinking "+vol+" ml of milk");
		currentVolume -= vol;
		if(currentVolume < 0) currentVolume = 0;
	}
	
	@Override
	public double getWeight()
	{
		return super.getWeight()*(currentVolume/originalVolume);
	}
	
	public double getVolume()
	{
		return currentVolume;
	}
	
	public BottleOfMilk clone()
	{
		BottleOfMilk temp = new BottleOfMilk(getPurchasePrice(), getAge(), getWeight(), getVolume());
		return temp;
	}
}

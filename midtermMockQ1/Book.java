//Name:Sorawit Ongsiriporn
//ID:6288030
//Section:3

public class Book extends Item{
	
	private StringBuilder note = null;
	
	public Book(double _purchasePrice, double _age, double weight) {
		super(_purchasePrice, _age, weight);
		note = new StringBuilder();

	}

	@Override
	public double getCurrentValue() {
		return getPurchasePrice()*Math.pow(0.9, getAge());
	}

	@Override
	public String toString()
	{
		return "[Book: value = "+String.format( "%.2f", this.getCurrentValue())+" Baht, Note = \""+getNote()+"\"]";
	}
	
	public void takeNote(String _note)
	{
		System.out.println("Taking note: \""+_note+"\"");
		note.append(_note);
	}
	
	public String getNote()
	{
		return note.toString();
	}
	
	public Book clone()
	{
		Book temp = new Book(getPurchasePrice(),getAge(),getWeight());
		temp.note.append(getNote());
		return temp;
	}
}

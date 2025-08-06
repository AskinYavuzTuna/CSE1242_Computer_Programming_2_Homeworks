//This class represents any Dairy which is Food.
public class Dairy extends Food {

	Dairy(){
		super.setBasePrice(8.0);
	}
	
	Dairy(double basePrice){
		super.setBasePrice(basePrice);
	}
	
	public double calculatePrice() {
		return (int)( super.getBasePrice() * 1.3 * (1+super.getVat()) *100 )/100.0;
	}
	
}

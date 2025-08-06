//This class represents any Clothing which is sold and Washable.
public class Underware extends Clothing implements Washable{
	
	Underware(){
		super.setBasePrice(30.0);
	}
	Underware(double basePrice){
		super.setBasePrice(basePrice);
	}
	
	public double calculatePrice(){
		return (int)( super.getBasePrice() * 1.45 * (1+super.getVat()) *100 )/100.0;
	}
	public void howToWash() {
		System.out.println("Wash Underware at 60 degrees.");
	}
	

}

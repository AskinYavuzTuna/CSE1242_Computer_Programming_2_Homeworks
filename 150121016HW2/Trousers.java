//This class represents any Clothing which is sold and Washable.
public class Trousers extends Clothing implements Washable{
	
	Trousers(){
		super.setBasePrice(40.0);
	}
	Trousers(double basePrice){
		super.setBasePrice(basePrice);
	}
	
	public double calculatePrice(){
		return (int)( super.getBasePrice() * 1.2 * (1+super.getVat()) *100 )/100.0;
	}
	public void howToWash() {
		System.out.println("Wash Trousers at 30 degrees.");
	}
	

}

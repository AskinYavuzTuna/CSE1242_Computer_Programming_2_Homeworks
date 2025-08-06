//This class represents any Clothing which is sold and Washable.
public class Top extends Clothing implements Washable{
	
	Top(){
		super.setBasePrice(20.0);
	}
	Top(double basePrice){
		super.setBasePrice(basePrice);
	}
	
	public double calculatePrice(){
		return (int)( super.getBasePrice() * 1.2 * (1+super.getVat()) *100 )/100.0;
	}
	public void howToWash() {
		System.out.println("Wash Top at 40 degrees.");
	}
	

}

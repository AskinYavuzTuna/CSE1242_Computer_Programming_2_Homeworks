//This class represents any Clothing which is sold, Washable and Vegan.
public class Vegetable extends Food implements Vegan , Washable {
	
	Vegetable(){
		super.setBasePrice(10.0);
	}
	
	Vegetable(double basePrice){
		super.setBasePrice(basePrice);
	}
	
	public double calculatePrice() {
		return (int)( super.getBasePrice() * 1.25 * (1+super.getVat()) *100 )/100.0;
	}
	
	public void howToWash() {
		System.out.println("Wash Vegetable with warm water.");
	}
	public void madeOf() {
		System.out.println("It is made only of vegetables.");
	}
	
	

}

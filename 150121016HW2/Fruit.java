//This class represents any Clothing which is sold, Washable and Vegan.
public class Fruit extends Food implements Vegan , Washable {
	
	Fruit(){
		super.setBasePrice(6.0);
	}
	
	Fruit(double basePrice){
		super.setBasePrice(basePrice);
	}
	
	public double calculatePrice() {
		return (int)( super.getBasePrice() * 1.2 * (1+super.getVat()) *100 )/100.0;
	}
	
	public void howToWash() {
		System.out.println("Wash Fruit with cold water.");
	}
	public void madeOf() {
		System.out.println("It is made only of fruits.");
	}
	
}

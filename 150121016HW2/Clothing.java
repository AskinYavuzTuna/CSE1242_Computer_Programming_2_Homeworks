//This class represents any Clothing which is sold and Washable.
public abstract class Clothing extends Item implements Washable {
	
	Clothing() {
		super.setVat(0.18);
	}
	
}

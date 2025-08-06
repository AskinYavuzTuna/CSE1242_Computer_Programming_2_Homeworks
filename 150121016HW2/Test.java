//Aşkın Yavaz Tuna 150121016.
public class Test {

	public static void main(String[] args) {
		
		ShoppingMall currentShoppingMall=new ShoppingMall();
		currentShoppingMall.addDairy();
		currentShoppingMall.addFruit();
		currentShoppingMall.addTop();
		currentShoppingMall.addTrousers();
		currentShoppingMall.addUnderware();
		currentShoppingMall.addVegetable();
		currentShoppingMall.addArbitrary(new Top(100));
		
		printContent(currentShoppingMall);
		printWashingInstructions(currentShoppingMall);
		System.out.println(((int)(currentShoppingMall.bill() * 100)) / 100.0 + "$");
	}
	//This method controls the items which are sold in Shopping Mall and prints what they are made of if these class implements madeOf methods.
	public static void printContent(ShoppingMall current) {
		for(int a=0;a<current.items.size();a++) {
			if(current.getItems().get(a) instanceof Vegan)
				((Vegan)(current.getItems().get(a))).madeOf();
		}
	}
	//This method controls the items which are sold in Shopping Mall and prints how they should be washed if they are washable. 
	public static void printWashingInstructions(ShoppingMall current) {
		for(int a=0;a<current.items.size();a++) {
			if(current.getItems().get(a) instanceof Washable)
				((Washable)(current.getItems().get(a))).howToWash();
		}
	}

}

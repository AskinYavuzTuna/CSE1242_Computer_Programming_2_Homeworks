import java.util.ArrayList;
//This class represents any ShoppingMall where items are.
public class ShoppingMall {

	ArrayList<Item> items = new ArrayList<Item>();
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public void addDairy() {
		items.add(new Dairy());
	}
	public void addFruit() {
		items.add(new Fruit());
	}
	public void addTop() {
		items.add(new Top());
	}
	public void addTrousers() {
		items.add(new Trousers());
	}
	public void addUnderware() {
		items.add(new Underware());
	}
	public void addVegetable() {
		items.add(new Vegetable());
	}
	
	public void addArbitrary(Item item) {
		items.add(item);
	}
	public double bill() {
		double total=0;
		for(int a=0;a<items.size();a++) {
			total+=items.get(a).calculatePrice();
		}
		return total;
	}
	
}

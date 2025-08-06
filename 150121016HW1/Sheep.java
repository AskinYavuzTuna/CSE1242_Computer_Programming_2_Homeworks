//This class represents sheep object which is also mammal.
class Sheep extends Mammal{
	private static int count;
	public Sheep(String name, int age) {
		super(name,age);
		setLegNumber(4);
		setNumberOfOffsprings(1);
		setPregnancyPerYear(1);
	}
	public void sayGreeting() {
		System.out.println("Four legs good, two legs better!");
	}
	public static int getCount(){
		return count;
	}
	public static void decrementCount() {
		count--;
	}
	
}
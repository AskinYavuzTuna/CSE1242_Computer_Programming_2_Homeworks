//This class represents donkey object which is also mammal.
class Donkey extends Mammal{
	private static int count;
	public Donkey(String name, int age) {
		super(name,age);
		setLegNumber(4);
		setNumberOfOffsprings(1);
		setPregnancyPerYear(1);
	}
	public void sayGreeting() {
		System.out.println("Life will go on as it has always gone –that is, badly!");
	}
	public static int getCount(){
		return count;
	}
	public static void decrementCount() {
		count--;
	}
	
}
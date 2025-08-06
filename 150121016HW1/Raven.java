//This class represents raven object which is also bird.
class Raven extends Bird{
	private static int count;
	public Raven(String name,int age) {
		super(name,age);
		setLegNumber(2);
		setNumberOfOffsprings(5);
		setPregnancyPerYear(1);
	}
	public void sayGreeting() {
		System.out.println("A happy country where we poor animals shall rest forever!");
	}
	public static int getCount(){
		return count;
	}
	public static void decrementCount() {
		count--;
	}
	
}
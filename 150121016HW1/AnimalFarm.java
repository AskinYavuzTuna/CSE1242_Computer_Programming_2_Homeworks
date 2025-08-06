//This class represents animal farm where animals live.
import java.util.ArrayList;
class AnimalFarm{
	private ArrayList<Animal> animalList = new ArrayList<>();
	private ArrayList<String> animalNames = new ArrayList<>();
	private int CAPACITY;
	private static int numberOfAnimals=0;
	public AnimalFarm(int capacity) {
		this.CAPACITY=capacity;
	}
	public ArrayList<Animal> getAnimalList() {
		return animalList;
	}
	public void setAnimalList(ArrayList<Animal> animalList) {
		this.animalList = animalList;
	}
	public ArrayList<String> getAnimalNames() {
		return animalNames;
	}
	public void setAnimalNames(ArrayList<String> animalNames) {
		this.animalNames = animalNames;
	}
	public int getCAPACITY() {
		return CAPACITY;
	}
	public void setCAPACITY(int cAPACITY) {
		CAPACITY = cAPACITY;
	}
	public static void setNumberOfAnimals(int numberOfAnimals) {
		AnimalFarm.numberOfAnimals = numberOfAnimals;
	}
	public int getNumberOfAnimals(){
		return numberOfAnimals;
	}
	//this method adds animal to animal farm and returns true if it can, false if it can't.
	public boolean addAnimal(Animal animal) {
		if(animalNames.contains(animal.getName())) {
			new IllegalNameException("Animal couldn't add because there is animal which has this name in this farm.");
			return false;
		}
			
		if(animalNames==null) {
			animalList.add(animal);
			animalNames.add(animal.getName());
			numberOfAnimals++;
			return true;
		}
		else {
			if(!animalNames.contains(animal.getName())&&animalNames.size()<this.CAPACITY) {
				animalList.add(animal);
				animalNames.add(animal.getName());
				numberOfAnimals++;
				return true;
			}
			else
				return false;
			
		}
		
	}
	//this method removes animal from animal farm and returns true if it can, false if it can't.
	public boolean removeAnimal(String name) {
		if(animalNames.contains(name)) {
			int index = animalNames.indexOf(name);
			if(animalList.get(index) instanceof Chicken)
				Chicken.decrementCount();
			else if(animalList.get(index) instanceof Donkey)
				Donkey.decrementCount();
			else if(animalList.get(index) instanceof Horse)
				Horse.decrementCount();
			else if(animalList.get(index) instanceof Pig)
				Pig.decrementCount();
			else if(animalList.get(index) instanceof Raven)
				Raven.decrementCount();
			else if(animalList.get(index) instanceof Sheep)
				Sheep.decrementCount();
			animalList.remove(index);
			animalNames.remove(index);
			numberOfAnimals--;
			return true;
		}
		else
			return false;
		
	}
	//this method prints messages of all animals.
	public void printAllAnimalGreetings() {
		if (!(animalList.size()==0))
		for(int a=0;a<animalList.size();a++) {
			animalList.get(a).sayGreeting();
		}
		
	}
	//this method prints messages of just one animals which is entered.
	public void printOneAnimalGreeting(Animal animal) {
		animal.sayGreeting();
	}
	//this method prints names of all animals.
	public void printAllAnimalNames() {
		if (!(animalList.size()==0))
			for(int a=0;a<animalList.size();a++) {
				System.out.println(animalList.get(a).getName());
			}
	}
	//this method prints names of animal which is wanted.
	public void printOneAnimalName(Animal animal) {
		System.out.println(animal.getName());
	}
	//this method prints calls toString method of each animal.
	public void printAllAnimals() {
		if (!(animalList.size()==0))
			for(int a=0;a<animalList.size();a++) {
				System.out.println(animalList.get(a).toString());
			}
	}
	//this method returns how many animal will be in the farm next year.
	public int nextYearPopulationForecast() {
		int total=0;
		if (!(animalList.size()==0))
			for(int a=0;a<animalList.size();a++) {
				total+=animalList.get(a).getNumberOfOffsprings()*animalList.get(a).getPregnancyPerYear()+1;
			}
		return total;
	}
	//this method prints message about movements of animals.
	public void animalMovements() {
		if (!(animalList.size()==0))
			for(int a=0;a<animalList.size();a++) {
				if(animalList.get(a) instanceof Bird) {
					System.out.print("My name is " + animalNames.get(a) + " and ");
					((Bird)animalList.get(a)).fly();
				}
				else {
					System.out.print("My name is " + animalNames.get(a) + " and ");
					((Mammal)animalList.get(a)).walk();
				}
					
			}
	}
	//this method prints message about eating habits of animals.
	public void eatingHabits() {
		if (!(animalList.size()==0))
			for(int a=0;a<animalList.size();a++) {
				if(animalList.get(a) instanceof Bird) {
					System.out.print("My name is " + animalNames.get(a) + " and ");
					((Bird)animalList.get(a)).omnivore();
				}
				else {
					System.out.print("My name is " + animalNames.get(a) + " and ");
					((Mammal)animalList.get(a)).herbivore();
				}
					
			}
	}
	//this method prints names of animals according to alphabetic order.
	public void sortAlphabetically() {
		String[] sortList=new String[animalNames.size()];
		for(int a=0;a<animalNames.size();a++) {
			sortList[a]=animalNames.get(a);
		}
		java.util.Arrays.sort(sortList);
		for(int a=0;a<sortList.length;a++) {
			System.out.println(sortList[a] + ".");
		}
		
	}
	//this method prints names and informations of animals according to leg number.
	public void sortBasedOnLegNumber(){
		for(int a=0;a<animalList.size();a++) {
			if((animalList.get(a)).getLegNumber()==2)
				System.out.println(animalList.get(a).getName() + " has 2 legs.");
		}
		for(int a=0;a<animalList.size();a++) {
			if((animalList.get(a)).getLegNumber()==4)
				System.out.println(animalList.get(a).getName() + " has 4 legs.");
		}
		
	}
	//this method prints names and informations of animals according to age of them.
	public void sortBasedOnAge() {
		for(int a=0,b=0;b<animalList.size();a++) {
			for(int x=0;x<animalList.size();x++) {
				if((animalList.get(x).getAge())==a) {
					System.out.println(animalList.get(x).getName() +" is " + animalList.get(x).getAge() + " years old.");
					b++;
				}
				
			}
			
		}
		
	}
	//this method searches the animal with given name and prints its message.
	public void searchBasedOnName(String name) {
		int a=animalNames.indexOf(name);
		System.out.println("My name is " + animalList.get(a).getName() + "!");
		System.out.println("I am " + animalList.get(a).getAge() + " years old!");
		System.out.println("I have " + animalList.get(a).getLegNumber() + " legs!");
	}
	//this method searches the animal with given age and prints its message.
	public void searchBasedOnAge(int age){
		for(int a=0;a<animalList.size();a++) {
			if(animalList.get(a).getAge()==age) {
				System.out.println("My name is " + animalList.get(a).getName() + "!");
				System.out.println("I am " + animalList.get(a).getAge() + " years old!");
				System.out.println("I have " + animalList.get(a).getLegNumber() + " legs!");
			}
		}
			
	}
	//this method creates file with given name and prints detail information about farm to file.
	public void printReport(String filename) throws Exception {
		java.io.File file = new java.io.File(filename);
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
			
		}
		//next 20 codes calculates the number of every animal.
		int chickenNumbers = 0;
		int ravenNumbers = 0;
		int pigNumbers = 0;
		int horseNumbers = 0;
		int donkeyNumbers = 0;
		int sheepNumbers = 0;
		for(int a=0;a<animalList.size();a++) {
			if(animalList.get(a) instanceof Chicken)
				chickenNumbers++;
			else if(animalList.get(a) instanceof Donkey)
				donkeyNumbers++;
			else if(animalList.get(a) instanceof Horse)
				horseNumbers++;
			else if(animalList.get(a) instanceof Pig)
				pigNumbers++;
			else if(animalList.get(a) instanceof Raven)
				ravenNumbers++;
			else if(animalList.get(a) instanceof Sheep)
				sheepNumbers++;
		}
		//these codes prints data to file.
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
		output.println("We have a total of " + animalList.size() +  "animals in the farm.");
		output.println("");
		if(chickenNumbers>0) {
			output.println("    *" + chickenNumbers + " of them are Chicken. Those are:");
			output.println("        Name           Age      Leg Number");
		}
		for(int a=0;a<animalList.size();a++) {
			if(animalList.get(a) instanceof Chicken) {
				output.printf("%-8s%-15s%-9d%-10d","",animalList.get(a).getName(),animalList.get(a).getAge(),2);
				output.println();
			}
		}
		if(donkeyNumbers>0) {
			output.println("    *" + donkeyNumbers + " of them are Donkey. Those are:");
			output.println("        Name           Age      Leg Number");
		}
		for(int a=0;a<animalList.size();a++) {
			if(animalList.get(a) instanceof Donkey) {
				output.printf("%-8s%-15s%-9d%-10d","",animalList.get(a).getName(),animalList.get(a).getAge(),4);
				output.println();
			}
		}
		if(horseNumbers>0) {
			output.println("    *" + horseNumbers + " of them are Horse. Those are:");
			output.println("        Name           Age      Leg Number");
		}
		for(int a=0;a<animalList.size();a++) {
			if(animalList.get(a) instanceof Horse) {
				output.printf("%-8s%-15s%-9d%-10d","",animalList.get(a).getName(),animalList.get(a).getAge(),4);
				output.println();
			}
		}
		if(pigNumbers>0) {
			output.println("    *" + pigNumbers + " of them are Pig. Those are:");
			output.println("        Name           Age      Leg Number");
		}
		for(int a=0;a<animalList.size();a++) {
			if(animalList.get(a) instanceof Pig) {
				output.printf("%-8s%-15s%-9d%-10d","",animalList.get(a).getName(),animalList.get(a).getAge(),4);
				output.println();
			}
		}
		if(ravenNumbers>0) {
			output.println("    *" + ravenNumbers + " of them are Raven. Those are:");
			output.println("        Name           Age      Leg Number");
		}
		for(int a=0;a<animalList.size();a++) {
			if(animalList.get(a) instanceof Raven) {
				output.printf("%-8s%-15s%-9d%-10d","",animalList.get(a).getName(),animalList.get(a).getAge(),2);
				output.println();
			}
		}
		if(sheepNumbers>0) {
			output.println("    *" + sheepNumbers + " of them are Sheep. Those are:");
			output.println("        Name           Age      Leg Number");
		}
		for(int a=0;a<animalList.size();a++) {
			if(animalList.get(a) instanceof Sheep) {
				output.printf("%-8s%-15s%-9d%-10d","",animalList.get(a).getName(),animalList.get(a).getAge(),4);
				output.println();
			}
		}
		output.close();
	}
	
}
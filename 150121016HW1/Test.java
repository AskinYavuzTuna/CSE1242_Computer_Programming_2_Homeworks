//Aşkın Yavuz Tuna 150121016

public class Test {
	public static void main(String[] args) throws Exception {
		java.util.Scanner input = new java.util.Scanner(System.in);
		int entered;
		System.out.println("Welcome to Animal Farm simulation program!");
		System.out.print("Please enter the capacity of the animal farm: ");
		entered = input.nextInt();
		AnimalFarm currentFarm = new AnimalFarm(entered);
		//thanks to this while loop this codes works again and again.
		while(true) {
			System.out.println("0 - Exit the program");
			System.out.println("1 - Add animal");
			System.out.println("2 - Remove animal");
			System.out.println("3 - Search animal");
			System.out.println("4 - Sort animal");
			System.out.println("5 - Calculate next year's population estimate");
			System.out.println("6 - Print all animal's movements");
			System.out.println("7 - Print all animal's eating habits");
			System.out.println("8 - Print report");
			System.out.print("Please enter your choice: ");
			entered = input.nextInt();
			switch(entered) {
			//if user enters 0 code will terminate.
			case(0):
				
				System.exit(0);
				break;
				//if user enters 1 this code adds animal with given information to farm.
			case(1):
				int o=currentFarm.getCAPACITY();
				int p=currentFarm.getNumberOfAnimals();
				if(o==p) {
					System.out.println("The farm is full.");
				}
				else {
					System.out.println("1 - Chicken");
					System.out.println("2 - Donkey");
					System.out.println("3 - Horse");
					System.out.println("4 - Pig");
					System.out.println("5 - Raven");
					System.out.println("6 - Sheep");
					System.out.print("Select animal type:");
					int enteredType = input.nextInt();
					System.out.print("Enter the name:");
					String enteredName = input.next();
					System.out.print("Enter the age:");
					int enteredAge = input.nextInt();
					switch(enteredType) {
					case(1):
						currentFarm.addAnimal(new Chicken(enteredName,enteredAge));
					break;
					case(2):
						currentFarm.addAnimal(new Donkey(enteredName,enteredAge));
					break;
					case(3):currentFarm.addAnimal(new Horse(enteredName,enteredAge));
					break;
					case(4):currentFarm.addAnimal(new Pig(enteredName,enteredAge));
					break;
					case(5):currentFarm.addAnimal(new Raven(enteredName,enteredAge));
					break;
					case(6):currentFarm.addAnimal(new Sheep(enteredName,enteredAge));
					
					}
				}
				
				break;
				//if user enters 2 this code removes the animal which has entered name to farm.
			case(2):
				System.out.print("Enter the name: ");
				String enteredName = input.next();
				currentFarm.removeAnimal(enteredName);
				break;
				//if user enters 3 this code searches animal according to entered information.
			case(3):
				System.out.println("1 - based on name: ");
				System.out.println("2 - based on age: ");
				int x = input.nextInt();
				if(x==1) {
					System.out.print("Enter name:");
					String name=input.next();
					currentFarm.searchBasedOnName(name);
					
				}
				else if(x==2) {
					System.out.print("Enter age:");
					int age=input.nextInt();
					currentFarm.searchBasedOnAge(age);
				}
				
			break;
			//if user enters 4 this code sorts animal according to entered information.
			case(4):
				System.out.println("1 - Sort based on name");
			System.out.println("2 - based on leg number");
			System.out.println("3 - based on age");
			System.out.println("4 - based on addition date");
			int y = input.nextInt();
			if(y==1) {
				currentFarm.sortAlphabetically();
			}
			else if(y==2) {
				currentFarm.sortBasedOnLegNumber();
			}
			else if(y==3) {
				currentFarm.sortBasedOnAge();
			}
			else if(y==4) {
				currentFarm.printAllAnimalNames();
			}
			
			break;
			//if user enters 5 this code prints how many animal this farm will has.
			case(5):
				System.out.println(currentFarm.nextYearPopulationForecast());
			break;
			//if user enters 6 this code prints movements and names of animals which are in the farm.
			case(6):
				currentFarm.animalMovements();
			break;
			//if user enters 7 this code prints eating habits and names of animals which are in the farm.
			case(7):
				currentFarm.eatingHabits();
			break;
			//if user enters 8 this code creates a file and prints detail information to the file .
			case(8):
				System.out.print("Enter filename:");
			String enteredFileName=input.next();
				currentFarm.printReport(enteredFileName);
			}
				
		}
		
	}
	
}
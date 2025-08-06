//these class is used to control exception and print massage if there is.
class IllegalNameException extends Exception {
	
	public IllegalNameException() {
		
	}
	public IllegalNameException(String massage) {
		System.out.println(massage);
	}
}
package guessing;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

	public static void main(String[] args) {
		
		System.out.println("Ready to start the Number guessing game?");
		System.out.println("Please type ready when you are");
		Scanner in = new Scanner(System.in);
		do{
			String input = in.nextLine();
			if(input.equalsIgnoreCase("ready")){
				guessTheNumber();
				return;
			}else{
				System.out.println("Invalid input!");
				System.out.println("Please type ready when you are");
			}			
		}while(true);
	}

	public static void guessTheNumber(){
		int guess = 0; 
		int low = 0;  
		int high = 0;  
		boolean l = false; // false means No initial valid value in low
		boolean h = false; // false means No initial valid value in high
		String playerInput;
		Scanner in = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Number guessing game!");
		System.out.println("");
		System.out.println("Get a number in your mind and I will guess it");
		System.out.println("Is the number " + guess + " ?");
		System.out.println("Please input one of these words: higher, lower, or yes");
		while(l == false || h == false){
			playerInput = in.nextLine();

			if(playerInput.equalsIgnoreCase("higher") && h == false){
				low = guess;
				l = true;
				guess = Math.abs(random.nextInt());
			}else if(playerInput.equalsIgnoreCase("higher") && h == true){
				low = guess;
				l = true;
				guess = (low + high)/2;
			}else if(playerInput.equalsIgnoreCase("lower") && l == true){
				high = guess;
				h = true;
				guess = (low + high)/2;
			}else if(playerInput.equalsIgnoreCase("lower") && l == false){
				high = guess;
				h = true;
				guess = 0 - Math.abs(random.nextInt());
			}else if(playerInput.equalsIgnoreCase("yes")){
				System.out.println("WOW, I am good! Game ends!");
				return;
			}else{
				System.out.println("Invalid unput.");
				System.out.println("Please input one of these words: higher, lower, or yes");
			}
			System.out.println("Is the number " + guess + " ?");
		}
		
		while(l == true && h == true){
			playerInput = in.nextLine();
			if(playerInput.equalsIgnoreCase("higher")){
				low = guess;
			}else if(playerInput.equalsIgnoreCase("lower")){
				high = guess;
			}else if(playerInput.equalsIgnoreCase("yes")){
				System.out.println("WOW, I am good! Game ends!");
				return;
			}else{
				System.out.println("Invalid unput.");
				System.out.println("Please input one of these words: higher, lower, or yes");
			}
			guess = (low + high)/2;
			System.out.println("Is the number " + guess + " ?");
		}
	}
}


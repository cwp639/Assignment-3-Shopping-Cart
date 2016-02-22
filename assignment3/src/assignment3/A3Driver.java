package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class A3Driver {
	// global variable shoppingCart
	public static ArrayList<Item> shoppingCart = new ArrayList<Item>();

	public static void main(String[] args) throws FileNotFoundException 
	{		
		//Open file; file name specified in args (command line)
		if (args.length != 1) {
			// if not file or more than 1 file, throw the exception
			throw new FileNotFoundException("Not Input File Found.");
		}

		try {
			FileReader freader = new FileReader(args[0]);
			BufferedReader reader = new BufferedReader(freader);

			//Parse input, take appropriate actions.
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				parseInput(s);
			}
		}
		catch (IOException e) {
			System.err.println("Error: IO exception. Exiting...");
			System.exit(-1);
		}


		//		Iterator<Item> i = shoppingCart.iterator();
		//		while (i.hasNext()) 
		//		{
		//			Item temp = i.next();
		//			temp.printItemAttributes();
		//			//This (above) works because of polymorphism: a determination is made at runtime, 
		//			//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
		//			// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
		//		}		
	}
	/**
	 * parse the input string and branch to the specific operation
	 * @param inputLine
	 */
	public static void parseInput(String inputLine) {
		// split input String into individual commands
		String[] inputCommands = inputLine.split("[\\s+]");
		try {
			switch(inputCommands[0]) {
			case "insert": 
				insert(inputCommands);
				break;
			case "search":
				search(inputCommands);
				break;
			case "delete":
				delete(inputCommands);
				break;
			case "update":
				update(inputCommands);
				break;
			case "print":
				print(inputCommands);
				break;
			default :
				System.err.println("Invalid Input: Illegal Operation");
				return;
			}
		}
		// if there is no element in this array
		catch(IndexOutOfBoundsException e) {
			System.err.println("Invalid Input: Illegal Format");
			return; //return to the main method, process next line
		}
	}

	/*
	 * methods to fill out
	 */
	public static void insert(String[] inputCommands){
		try {
			String name;
			double salePrice;
			int quantity;
			int weight;
			String classification;
			String state;

			switch(inputCommands[1]) {
			case "clothing":
				if (inputCommands.length != 6) {
					System.err.println("Invalid Input: Illegal format");
					return;
				}
				name = inputCommands[2];

				// inspect salePrice
				try {
					salePrice = Double.parseDouble(inputCommands[3]);
					if (salePrice < 0) {
						System.err.println("Invalid Input: Sale price must be positive");
						return;
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Invalid Input: Sale price must be a number");
					return;
				}

				// inspect quantity
				try {
					quantity = Integer.parseInt(inputCommands[4]);
					if (quantity < 0) {
						System.err.println("Invalid Input: Quantity must be a non-negative number");
						return;
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Invalid Input: Quantity must be a whole number");
					return;
				}

				// inspect weight
				try {
					weight = Integer.parseInt(inputCommands[5]);
					if (quantity < 0) {
						System.err.println("Invalid Input: Weight must be a non-negative number");
						return;
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Invalid Input: Weight must be a whole number");
					return;
				}

				shoppingCart.add(new Clothing(name, salePrice, quantity, weight));
				break;

			case "electronics":
				if (inputCommands.length != 8) {
					System.err.println("Invalid Input: Illegal Format");
					return;
				}
				name = inputCommands[2];

				// inspect salePrice
				try {
					salePrice = Double.parseDouble(inputCommands[3]);
					if (salePrice < 0) {
						System.err.println("Invalid Input: Sale price must be positive");
						return;
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Invalid Input: Sale price must be a number");
					return;
				}

				// inspect quantity
				try {
					quantity = Integer.parseInt(inputCommands[4]);
					if (quantity < 0) {
						System.err.println("Invalid Input: Quantity must be a non-negative number");
						return;
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Invalid Input: Quantity must be a whole number");
					return;
				}

				// inspect weight
				try {
					weight = Integer.parseInt(inputCommands[5]);
					if (quantity < 0) {
						System.err.println("Invalid Input: Weight must be a non-negative number");
						return;
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Invalid Input: Weight must be a whole number");
					return;
				}

				// inspect classification
				classification = inputCommands[6];
				if (!classification.equals("F") && !classification.equals("NF")) {
					System.err.println("Invalid Input: Illegal classification");
					return;
				}

				// inspect state
				state = inputCommands[7];
				if (state.length() != 2) {
					System.err.println("Invalid Input: State code must be 2-letter long");
				}
				shoppingCart.add(new Electronics(name, salePrice, quantity, weight, classification, state));
				break;

			case "groceries":
				if (inputCommands.length != 7) {
					System.err.println("Invalid Input: Illegal Format");
					return;
				}
				name = inputCommands[2];

				// inspect salePrice
				try {
					salePrice = Double.parseDouble(inputCommands[3]);
					if (salePrice < 0) {
						System.err.println("Invalid Input: Sale price must be positive");
						return;
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Invalid Input: Sale price must be a number");
					return;
				}

				// inspect quantity
				try {
					quantity = Integer.parseInt(inputCommands[4]);
					if (quantity < 0) {
						System.err.println("Invalid Input: Quantity must be a non-negative number");
						return;
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Invalid Input: Quantity must be a whole number");
					return;
				}

				// inspect weight
				try {
					weight = Integer.parseInt(inputCommands[5]);
					if (quantity < 0) {
						System.err.println("Invalid Input: Weight must be a non-negative number");
						return;
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Invalid Input: Weight must be a whole number");
					return;
				}

				// inspect classification
				classification = inputCommands[6];
				if (!classification.equals("P") && !classification.equals("NP")) {
					System.err.println("Invalid Input: Illegal classification");
					return;
				}

				shoppingCart.add(new Grocery(name, salePrice, quantity, weight, classification));
				break;
			default:
				// keyword does not exist
				System.err.println("Invalid Input: Illegal Category");
				return;
			}
		}
		catch (IndexOutOfBoundsException e) {
			System.err.println("Invalid Input: Illegal Format");
			return;
		}
	}

	public static void search(String[] inputCommands){
		if(inputCommands.length != 2){
			System.err.println("Invalid Input: Illegal Format");
			return;
		}
		int size = shoppingCart.size();
		int count = 0;
		for(int i = 0; i < size; i++){
			if(shoppingCart.get(i).equals(inputCommands[1])){
				count++;
			}
		}
		System.out.println("Your search yielded " + count + " instances of item " + inputCommands[1] + ".");
	}

	public static void delete(String[] inputCommands){
		if(inputCommands.length != 2){
			System.err.println("Invalid Input: Illegal Format");
			return;
		}
		int size = shoppingCart.size();
		int count = 0;
		for(int i = 0; i < size; i++){
			if(shoppingCart.get(i).equals(inputCommands[1])){
				shoppingCart.remove(i);
				size--;
				count++;
			}
		}
		System.out.println(count + " instances of item " + inputCommands[1] + " was deleted.");
	}

	public static void update(String[] inputCommands){
		if(inputCommands.length != 3){
			System.err.println("Invalid Input: Illegal Format");
			return;
		}
		if(inputCommands[2].matches("\\d+")){
			int size = shoppingCart.size();
			for(int i = 0; i < size; i++){
				if(shoppingCart.get(i).equals(inputCommands)){
					shoppingCart.get(i).quantity = Integer.parseInt(inputCommands[2]);
					System.out.println("The quantity of item " + inputCommands[1] + " was updated to " + inputCommands[2] + ".");
					return;
				}
			}
			System.err.println("No instance of that item was found in the shopping cart.");
		}
		else return;
	}

	public static void print(String[] inputCommands){
		
	}

}

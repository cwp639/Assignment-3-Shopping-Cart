package Assignment3;

/**
 * Name: Xinyuan (Allen) Pan
 * EID : xp572
 *  Name: Chang Park
 * EID: cwp639
 * 
 * Driver - holds the main class for input/output handling
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class A3Driver {
	// global variable shoppingCart
	public static ArrayList<Item> shoppingCart = new ArrayList<Item>();
	// used to see if the state input for electronics is valid 
	public static String[] states = new String[] { "AL", "AK", "AS", "AZ",
			"AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "GU", "HI", "ID",
			"IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MH", "MA", "MI",
			"FM", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY",
			"NC", "ND", "MP", "OH", "OK", "OR", "PW", "PA", "PR", "RI", "SC",
			"SD", "TN", "TX", "UT", "VT", "VA", "VI", "WA", "WV", "WI", "WY" };
	public static void main(String[] args) throws FileNotFoundException 
	{		
		//Open file; file name specified in args (command line)
		if (args.length != 1) {
			// if not file or more than 1 file, throw the exception
			throw new FileNotFoundException("No input file found.");
		}

		try {
			FileReader freader = new FileReader(args[0]);
			BufferedReader reader = new BufferedReader(freader);

			//Parse input, take appropriate actions.
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				parseInput(s);				
			}
			reader.close();
			freader.close();
		}
		catch (IOException e) {
			System.err.println("Error: IO exception. Exiting...");
			System.exit(-1);
		}

	}
	
	/**
	 * parse the input string and branch to the specific operation
	 * @param inputLine
	 */
	public static void parseInput(String inputLine) {
		// split input String into individual commands
		String[] inputCommands = inputLine.split("\\s+");
//		System.out.println(Arrays.asList(inputCommands).toString());
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
				System.err.println("Invalid Input: Illegal operation");
				return;
			}
		}
		// if there is no element in this array
		catch(IndexOutOfBoundsException e) {
			System.err.println("Invalid Input: Illegal format");
			return; //return to the main method, process next line
		}
	}

	/*
	 * methods to fill out
	 */
	public static void insert(String[] inputCommands){
		try{
			String test = inputCommands[1];
		}
		catch (IndexOutOfBoundsException e) {
			System.err.println("Invalid Input: Illegal format");
			return;
		}
		
		String name;
		double salePrice;
		int quantity;
		int weight;
		String classification;
		String state;

		// split into three cases with different formatting rules
		// this will be tedious
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
			if (!Arrays.asList(states).contains(state)) {
				System.err.println("Invalid Input: Not a valid state");
				return;
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

	public static void search(String[] inputCommands){
		if(inputCommands.length != 2){
			System.err.println("Invalid Input: Illegal Format");
			return;
		}
		
		int size = shoppingCart.size();
		int count = 0;
		for(int i = 0; i < size; i++){
			if(shoppingCart.get(i).name.equals(inputCommands[1])){
				count += shoppingCart.get(i).quantity;
			}
		}
		System.out.println("Your search yielded " + count + " " + inputCommands[1] + "(s).");
	}

	public static void delete(String[] inputCommands){
		// check the length of input string
		if(inputCommands.length != 2){
			System.err.println("Invalid Input: Illegal format");
			return;
		}
		
		/*
		 * the following code does not work since "size" in the condition does not change dynamically
		int size = shoppingCart.size();
		int count = 0;
		for(int i = 0; i < size; i++){
			if(shoppingCart.get(i).name.equals(inputCommands[1])) {
				shoppingCart.remove(i);
				i--;
				size--;
				count += shoppingCart.get(i).quantity;
			}
		}
		*/
		int count = 0;
		ArrayList<Item> copy = (ArrayList<Item>) shoppingCart.clone();
		for (Item ele: copy) {
			if (ele.name.equals(inputCommands[1])) {
				shoppingCart.remove(ele);	// .remove(obj) removes the object not according to the index
				count += ele.quantity;
			}
		}
		System.out.println(count + " " + inputCommands[1] + "(s) was deleted.");
		
	}

	public static void update(String[] inputCommands){
		// check the length of the input string
		if(inputCommands.length != 3){
			System.err.println("Invalid Input: Illegal Format");
			return;
		}
		
		int quantity;
		try {
			quantity = Integer.parseInt(inputCommands[2]);
			if (quantity < 0) {
				System.err.println("Invalid Input: Quantity must be non-negative");
				return;
			}
		}
		catch (NumberFormatException e) {
			System.err.println("Invalid Input: Quantity must be a whole number");
			return;
		}
		
		int size = shoppingCart.size();
		for (int i = 0; i < size; i++){
			if(shoppingCart.get(i).name.equals(inputCommands[1])){
				shoppingCart.get(i).updateQuantity(quantity);
				System.out.println("The quantity of item " + inputCommands[1] + " was updated to " + quantity + ".");
				return;
			}
		}
		System.err.println("No instance of that item was found in the shopping cart.");
	}

	public static void print(String[] inputCommands){
		if (inputCommands.length != 1) {
			System.err.println("Invalid Input: Illegal format");
			return;
		}
		double total = 0;
		// don't want to sort the original ArrayList because the update() method only modifies the first occurrence 
		ArrayList<Item> copy = (ArrayList<Item>) shoppingCart.clone();
		int size = copy.size();
		Collections.sort(copy);	// uses compareTo() to sort. Specified in the Item class
		for(int i = 0; i < size; i++){
			System.out.println("Item: " + copy.get(i).name );
			System.out.println("Sale Price: " + copy.get(i).salePrice);
			System.out.println("Weight: " + copy.get(i).weight);
			System.out.println("Quantity: " + copy.get(i).quantity );
			System.out.println("Price with tax: " + String.format("%.2f",copy.get(i).priceAfterTax));
			System.out.println("Shipping Fee: " + String.format("%.2f",copy.get(i).shippingFee));
			System.out.println("Total cost for this purchase: " + String.format("%.2f", copy.get(i).calculatePrice()));
			System.out.println("");
			total += copy.get(i).calculatePrice();
		}
		System.out.println("Total Cost: " + String.format("%.2f", total));
	}

}

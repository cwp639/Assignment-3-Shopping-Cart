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

	}

	public static void search(String[] inputCommands){

	}

	public static void delete(String[] inputCommands){

	}

	public static void update(String[] inputCommands){

	}

	public static void print(String[] inputCommands){

	}

}

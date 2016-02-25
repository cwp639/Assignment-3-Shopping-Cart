package Assignment3;

/**
 * Name: Xinyuan (Allen) Pan
 * EID : xp572
 *  Name: Chang Park
 * EID: cwp639
 * A general class Item that will not directly reference to.
 * Better off if this is made an abstract class
 * implements Comparable interface to access and override compareTo() method
 *
 */
public class Item implements Comparable<Object>
{
	protected String name;
	protected double salePrice;	// the sale price read from the input
	protected int weight;
	protected int quantity;
	protected double priceAfterTax;
	protected double shippingFee;
	
	// constructor
	public Item(String name, double salePrice, int quantity, int weight) {
		this.name = name;
		this.salePrice = salePrice;
		this.quantity = quantity;
		this.weight = weight;
	}
	
	public void updateQuantity(int quantity) {
		this.quantity = quantity;
		calcShippingFee();	// this will invoke the method in the subclass to which the variable refers
		// so the shippingFee and priceAfterTax will be recalculated immediately
		calcPriceAfterTax();
	}
	
	public double calculatePrice() {
		double finalPrice = priceAfterTax + shippingFee;
		return finalPrice;
	}
	
	
	@Override
	public int compareTo(Object other) {
		Item temp = (Item) other;
		// if we compare the field name directly, then all upper case letters are considered "smaller" then lower case letters
		// so we convert all names into lower case then compare
		String name1 = this.name.toLowerCase();
		String name2 = temp.name.toLowerCase();
		if (name1.compareTo(name2) == 0) {
			// if only possible difference is case, then compare the original name
			return this.name.compareTo(temp.name);
		}
		else 
			return name1.compareTo(name2);
	}
	
	// methods that will be defined in subclasses
	// has to be protected because private methods cannot be overridden
	// it's better to make Item an abstract class but not familiar enough
	protected void calcPriceAfterTax() {}
	protected void calcShippingFee() {}
	

}

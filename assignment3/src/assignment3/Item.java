package Assignment3;

public class Item implements Comparable
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
		// so the shippingFee will be recalculated immediately
		calcPriceAfterTax();
	}
	
	@Override
	public int compareTo(Object other) {
		Item temp = (Item) other;
		return this.name.compareTo(temp.name);
	}
	
	// methods that will be defined in subclasses
	// has to be protected because private methods cannot be overridden
	// it's better to make Item an abstract class but not familiar enough
	protected void calcPriceAfterTax() {}
	protected void calcShippingFee() {}
	

}

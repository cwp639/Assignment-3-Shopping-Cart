package Assignment3;

/**
 * A subclass of Item
 *
 */
public class Grocery extends Item {
	private String classification;
	
	public Grocery(String name, double salePrice, int quantity, int weight, String classification) {
		super(name, salePrice,quantity, weight);
		this.classification = classification;
		calcShippingFee();
		calcPriceAfterTax();
	}
	
	@Override
	protected void calcShippingFee() {
		shippingFee = 20*weight*quantity;
		if (classification.equals("P")) 
			shippingFee *= 1.2;
	}
	
	@Override
	protected void calcPriceAfterTax() {
		// grocery has no tax
		priceAfterTax = salePrice * quantity;
	}
	
	// Only re-implement stuff you cannot get from the superclass (Item)
	
}

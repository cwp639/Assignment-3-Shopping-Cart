package Assignment3;

public class Clothing extends Item 
{	
	//constructor
	public Clothing(String name, double salePrice, int quantity, int weight) {
		super(name, salePrice,quantity, weight);
		calcShippingFee();
		calcPriceAfterTax();
	}
	
	@Override
	protected void calcShippingFee() {
		shippingFee = 20*weight*quantity;
	}
	
	@Override
	protected void calcPriceAfterTax() {
		priceAfterTax = salePrice * 1.1 * quantity;
	}
	
	
	
}

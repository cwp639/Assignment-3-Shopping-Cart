package Assignment3;

public class Electronics extends Item 
{
	private String classification;
	private String state;
	
	
	public Electronics(String name, double salePrice,int quantity, int weight, String classification, String state) {
		super(name, salePrice, quantity, weight);
		this.classification = classification;
		this.state = state;
		
		calcPriceAfterTax();
		calcShippingFee();
	}
	
	@Override
	protected void calcPriceAfterTax() {
		double tax;
		switch(state) {
		case "TX":
		case "NM":
		case "VA":
		case "AZ":
		case "AK":
			tax = 0;
			break;
		default: 
			tax = 0.1;
			break;
		}
		
		priceAfterTax = salePrice * (1 + tax) * quantity;
	}
	
	@Override
	protected void calcShippingFee() {
		shippingFee = 20*weight*quantity;
		if (classification.equals("F")) 
			shippingFee *= 1.2;
	}
	
	
}

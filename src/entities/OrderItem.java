package entities;

public class OrderItem {

	// Attributes
	private Integer quantity;
	private Double price;

	// Associations
	private Product product;

	// Builders
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	// Accessor Methods
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}

	// Methods
	public Double subTotal() {
		return quantity * price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getProduct().getName() + ", $");
		sb.append(String.format("%.2f", getPrice()) + ", ");
		sb.append("Quantity: " + getQuantity() + ", ");
		sb.append("Subtotal: $" + String.format("%.2f", subTotal()));
		
		return sb.toString();
	}

}

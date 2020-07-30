package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

	// Attributes
	private Date moment;
	private OrderStatus status;

	// Associations
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	// Builders
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	// Accessor Methods
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	// Methods
	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double total() {
		double total = 0.0;
		for (OrderItem item : items) {
			total += item.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String quebraLinha = System.getProperty("line.separator");
		
		sb.append("Order moment: " + sdf.format(moment) + quebraLinha);
		sb.append("Order status: " + status + quebraLinha);
		sb.append("Client: " + client.getName());
		sb.append(" (" + sdf2.format(client.getBirthDate()) + ") - ");
		sb.append(client.getEmail() + quebraLinha);
		sb.append("Order items: " + quebraLinha);
		for (OrderItem item : items) {
			sb.append(item.getProduct().getName() + ", $");
			sb.append(String.format("%.2f", item.getPrice()) + ", ");
			sb.append("Quantity: " + item.getQuantity() + ", ");
			sb.append("Subtotal: $" + String.format("%.2f", item.subTotal()) + quebraLinha);
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		
		return sb.toString();
	}

}

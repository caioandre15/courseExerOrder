package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String quebraLinha = System.getProperty("line.separator");
		
		sb.append("Order moment: " + sdf.format(moment) + quebraLinha);
		sb.append("Order status: " + status + quebraLinha);
		sb.append("Client: " + client + quebraLinha);
		sb.append("Order items: " + quebraLinha);
		for (OrderItem item : items) {
			sb.append(item + quebraLinha);
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		
		return sb.toString();
	}

}

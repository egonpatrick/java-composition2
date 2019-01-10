package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrders() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double sum = 0;
		for (OrderItem i : items) {
			sum += i.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		double sum = 0;
		/*
		 * Order moment: 20/04/2018 11:25:09 Order status: PROCESSING Client: Alex Green
		 * (15/03/1985) - alex@gmail.com Order items: TV, $1000.00, Quantity: 1,
		 * Subtotal: $1000.00 Mouse, $40.00, Quantity: 2, Subtotal: $80.00 Total price:
		 * $1080.00
		 */
		
		sb.append("Order moment: " + sdf.format(getMoment()) + "\n");
		sb.append("Order status: " + getStatus() + "\n");
		sb.append("Client: " + getClient() + "\n");
		sb.append("Order items: \n");
		for(OrderItem orderItems : items) {
			sb.append(orderItems.getProduct());
			sb.append(", ");
			sb.append(orderItems+"\n");			
		}
		sb.append("\nTotal price: $" + total());
		return sb.toString();
	}
}

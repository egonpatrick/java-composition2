package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birth = sdf.parse(sc.next());		
		Client client = new Client(name, email, birth);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();				
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			System.out.printf("Enter #%d item data: %n", i);
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem product = new OrderItem(quantity, price, new Product(productName, price));
			order.addItem(product);
		}
		System.out.println();
		System.out.println("ORDER SUMMARY");
		System.out.println(order);
		
		sc.close();
	}

}

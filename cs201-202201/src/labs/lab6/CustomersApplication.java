package labs.lab6;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/03/19
 * 
 * Lab6
 */
public class CustomersApplication {
    public static void main(String[] args) {
        boolean done = false;
        Scanner input = new Scanner(System.in);
        String choice = "";
        ArrayList<String> customers  = new ArrayList<String>();

        do{
            System.out.println("1. Add customer to queue");
            System.out.println("2. Help customer");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
     
            choice = input.nextLine();	
			switch (choice) {
				case "1": 
                    System.out.println("The customers position in the queue: " + addCustomers(customers,input));
					break;
				case "2": 
                    System.out.println("The customers name : " + helpCustomer(customers));
					break;
				case "3": 
					done = true;
					break;
				default:
					System.out.println("I'm sorry, but I didn't understand that.");
			}
		} while (!done);
        input.close();
    }

    public static int addCustomers(ArrayList<String> customers, Scanner input) {
        
        System.out.println("Input the customer name: ");
        String name = input.nextLine();
        customers.add(name);
        return customers.size() - 1;
    }

    public static String helpCustomer(ArrayList<String> customers) {
        try{
            String c = customers.remove(0);
            return c;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
        
    }
}

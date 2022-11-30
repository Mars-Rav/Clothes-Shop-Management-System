package View;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import Controllers.CashierController;
import Controllers.GarmentController;
import Controllers.InvoiceController;
import Models.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import static Controllers.InvoiceController.removeInvoice;

public class CashierView {
	
	private static Scanner input = new Scanner(System.in);
       
        
	public static void optionSelection(User cashier) throws IOException, ParseException ,UnknownHostException, ClassNotFoundException, InterruptedException {
		
                   
                switch(displayCashierOptions()) {
                    
		case 1:
			CashierController.addGarmentToInvoice(cashier);
			InvoiceController.printInvoice();
			break;
		case 2:

                    
                    GarmentController.printGarments();
                   
			break;
		case 3:

			InvoiceController.printInvoices();
			break;
		case 4:
			System.out.println("Enter the ID of the Invoice you want to search for:");
			int id = Integer.parseInt(input.nextLine());
			InvoiceController.searchInvoiceById(id);
			break;
		case 5:

			System.exit(0);
			break;
			default:
				System.out.println("Please enter valid input.");
		}
                
	}
	
	private static int displayCashierOptions() throws IOException, ClassNotFoundException, UnknownHostException {
		System.out.println("Enter the number of the function you want:");
		System.out.println("1. Create a new invoice.");
		System.out.println("2. Display garments");
		System.out.println("3. Show history.");
		System.out.println("4. search Invoice ById");
		System.out.println("5. Exit.");
//		 CashierController.cashierServer();
////                  CashierClient( );
//                    InetAddress host = InetAddress.getLocalHost();
//                    Socket socket = null;
//                    ObjectOutputStream oos = null;
//                    ObjectInputStream ois = null;
//                    socket = new Socket(host.getHostName(), 8888);
		return Integer.parseInt(input.nextLine());
	}

}

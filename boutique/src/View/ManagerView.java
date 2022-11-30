package View;

import java.io.EOFException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Controllers.CashierController;
import Controllers.GarmentController;
import Controllers.InvoiceController;
import Controllers.Manager;

import static Controllers.InvoiceController.removeInvoice;

public class ManagerView {

	private static Scanner input = new Scanner(System.in);

	public static void optionSelection() throws IOException, ParseException {
		switch(displayManagerOptions()) {
		case 1:
			try {
				GarmentController.addToInventory();
			}catch (EOFException e) {
				// ... this is fine
			}break;
		case 2:
			GarmentController.printGarments();
			break;
		case 3:
			System.out.println("Search by:");
			System.out.println("1. Name");
			System.out.println("2. ID");
			int opt = Integer.parseInt(input.nextLine());

			switch(opt){
			case 1:
				System.out.println("Enter the name of the garment you want to search for:");
				String name = input.nextLine();
				Manager.searchGarment(name);
				break;
			case 2:
				System.out.println("Enter the ID of the garment you want to search for:");
				int id = Integer.parseInt(input.nextLine());

				Manager.searchGarment(id);
				break;
				default:
					System.out.println("Please enter valid input.");
			}

			break;
		case 4:
			CashierController.addToStaff();
			break;
		case 5:
			CashierController.printStaff();
			break;
		case 6:
			System.out.println("Search by:");
			System.out.println("1. Name");
			System.out.println("2. ID");
			int staffOpt = Integer.parseInt(input.nextLine());

			switch(staffOpt){
			case 1:
				System.out.println("Enter the name of the cashier you want to search for:");
				String name = input.nextLine();

				Manager.searchStaff(name);
				break;
			case 2:
				System.out.println("Enter the ID of the cashier you want to search for:");
				int id = Integer.parseInt(input.nextLine());


				Manager.searchStaff(id);
				break;
				default:
					System.out.println("Please enter valid input.");
			}
		break;
		case 7:

		InvoiceController.printInvoices();
		break;
		case 8:
		System.out.println("Enter the ID of the Invoice you want to search for:");
				int id = Integer.parseInt(input.nextLine());
				InvoiceController.searchInvoiceById(id);
		break;
			case 9:
				System.out.println("Enter the ID of the invoice you want to  remove :");
				int idremove = Integer.parseInt(input.nextLine());
				removeInvoice(idremove);
				break;
			case 10:
				System.out.println("remove by:");
				System.out.println("1. Name");
				System.out.println("2. ID");
				int removeGarment = Integer.parseInt(input.nextLine());

				switch(removeGarment){
					case 1:
						System.out.println("Enter the name of the garment you want to remove:");
						String removeGarmentname = input.nextLine();
						GarmentController.removeGarment(removeGarmentname);
						break;
					case 2:
						System.out.println("Enter the ID of the garment you want to remove:");
						int removeGarmentid = Integer.parseInt(input.nextLine());
						GarmentController.removeGarment(removeGarmentid);
						break;
				}
				break;
			case 11:
				System.out.println("remove by:");
				System.out.println("1. Name");
				System.out.println("2. ID");
				int remove = Integer.parseInt(input.nextLine());

				switch(remove){
					case 1:
						System.out.println("Enter the name of the cashier you want to remove:");
						String removeCashiername = input.nextLine();
						CashierController.removeCashier(removeCashiername);
						break;
					case 2:
						System.out.println("Enter the ID of the cashier you want to remove:");
						int removeCashierid = Integer.parseInt(input.nextLine());
						CashierController.removeCashier(removeCashierid);
						break;
				}
				break;
		case 12:
			System.exit(0);
			break;
		}
	}

	private static int displayManagerOptions() {
		System.out.println("Enter the number of the function you want:");
		System.out.println("1. Add a new garment.");
		System.out.println("2. Display garments.");
		System.out.println("3. Search a garment.");
		System.out.println("4. Add a new cashier.");
		System.out.println("5. Display cashiers.");
		System.out.println("6. Search a cashier.");
		System.out.println("7. show invoice.");
		System.out.println("8. search invoice by Id.");
		System.out.println("9. remove Invoice.");
		System.out.println("10. remove garment.");
		System.out.println("11. remove cashier.");
		System.out.println("12. Exit.");
		return Integer.parseInt(input.nextLine());
	}

}

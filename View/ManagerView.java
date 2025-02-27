package View;

import java.io.EOFException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Controllers.CashierController;
import Controllers.GarmentController;
import Controllers.Manager;

import static Controllers.InvoiceController.removeInvoice;

public class ManagerView {

	private static Scanner input = new Scanner(System.in);

	public static void optionSelection() throws IOException, ParseException {
		boolean state = true;
		while(state){
			try{
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
						System.out.println("Enter the ID of the invoice you want to  remove :");
						int idremove = Integer.parseInt(input.nextLine());
						removeInvoice(idremove);
						break;
					case 8:
						System.out.println("remove by:");
						System.out.println("1. Name");
						System.out.println("2. ID");
						int removeGarment = Integer.parseInt(input.nextLine());

						switch(removeGarment){
							case 1:
								System.out.println("Enter the name of the garment you want to remove:");
								String name = input.nextLine();
								GarmentController.removeGarment(name);
								break;
							case 2:
								System.out.println("Enter the ID of the garment you want to remove:");
								int id = Integer.parseInt(input.nextLine());
								GarmentController.removeGarment(id);
								break;
						}
						break;
					case 9:
						System.out.println("remove by:");
						System.out.println("1. Name");
						System.out.println("2. ID");
						int remove = Integer.parseInt(input.nextLine());

						switch(remove){
							case 1:
								System.out.println("Enter the name of the cashier you want to remove:");
								String name = input.nextLine();
								CashierController.removeCashier(name);
								break;
							case 2:
								System.out.println("Enter the ID of the cashier you want to remove:");
								int id = Integer.parseInt(input.nextLine());
								CashierController.removeCashier(id);
								break;
						}
						break;
					case 10:
						boolean searchingStaffState = true;
						while(searchingStaffState){
							System.out.println("Search By:");
							System.out.println("1. ID");
							System.out.println("2. Name");
							String replyString = input.nextLine();
							int reply = Integer.parseInt(replyString);
							switch (reply){
								case 1:
									System.out.println("Enter the ID:");
									String enteredIDString = input.nextLine();
									int enteredID = Integer.parseInt(enteredIDString);
									Manager.editStaff(enteredID);
									searchingStaffState = false;
									break;
								case 2:
									System.out.println("Enter the name:");
									String enteredName = input.nextLine();
									Manager.editStaff(enteredName);
									searchingStaffState = false;
									break;
								default:
									System.out.println("Please Enter valid input:");
							}
						}
						break;
					case 11:
						boolean searchingGarmentState = true;
						while(searchingGarmentState){
							System.out.println("Search By:");
							System.out.println("1. ID");
							System.out.println("2. Name");
							String replyString = input.nextLine();
							int reply = Integer.parseInt(replyString);
							switch (reply){
								case 1:
									System.out.println("Enter the ID:");
									String enteredIDString = input.nextLine();
									int enteredID = Integer.parseInt(enteredIDString);
									Manager.editGarment(enteredID);
									searchingGarmentState = false;
									break;
								case 2:
									System.out.println("Enter the name:");
									String enteredName = input.nextLine();
									Manager.editGarment(enteredName);
									searchingGarmentState = false;
									break;
								default:
									System.out.println("Please Enter valid input:");
							}
						}
						break;
					case 12:
						System.exit(0);
						break;
				}
				state = false;
			} catch (Exception e){
				System.out.println("Please make sure to enter valid input.");
			}
		}
	}

	private static int displayManagerOptions() {
		System.out.println("Enter the number of the function you want:");
		System.out.println("1. Add a new garment.");
		System.out.println("2. Display garments.");
		System.out.println("3. Search a garment.");
		System.out.println("4. Add a new cashier.");
		System.out.println("5. Display cashiers");
		System.out.println("6. Search a cashier.");
		System.out.println("7. Remove Invoice");
		System.out.println("8. Remove garment");
		System.out.println("9. Remove cashier");
		System.out.println("10. Edit cashier");
		System.out.println("11. Edit Garment");
		System.out.println("12. Exit.");
		return Integer.parseInt(input.nextLine());
	}

}

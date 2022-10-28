package Controller;

import Models.*;

public abstract class Manager{

	public void addNewGarment(int id, String name, String barcode, String brand, String size, String color, String dateAdded, String model, double price, int quantity, String category, double discount, String description) {
		GarmentController.addToInventory(new GarmentModel(id, name, barcode, brand, size, color, dateAdded, model, price, quantity, category, discount, description));
	}
	
	public void removeGarment(String name) {
		GarmentController.removeGarment(name);
	}
	
	public void removeGarment(int id) {
		GarmentController.removeGarment(id);
	}
	
	public void addNewCashier(int id, String name, String gender, String position, String dob, String phoneNumber, String email, double salary, String address, String password, String role) {
		CashierController.addNewCashier(new User(id, name, gender, dob, phoneNumber, email, salary, address, password, role));
	}
	
	public void removeCashier(String name) {
		CashierController.removeCashier(name);
	}
	
	public void removeCashier(int id) {
		CashierController.removeCashier(id);
	}

}


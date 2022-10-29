package Controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Models.*;

public abstract class Manager{
	
	public static void main(String args[])throws IOException, ParseException {
		File managerInfo = new File("C:/Users/High Tech/eclipse-workspace/ACP System/src/Controllers/ManagerInfo");
		
		if(!managerInfo.exists()) {
			managerInfo.createNewFile();
		}
		
		User manager = new User(101, "Mars", "Female", new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2011"), "00000000000", "purpleempra@gmail.com", 23000.0, "Main Street", "123abc", "Manager");
		
		FileOutputStream fos = new FileOutputStream(managerInfo);
		fos.write(manager.toString().getBytes());
		
		fos.flush();
		fos.close();
	}

	public void addNewGarment(int id, String name, String barcode, String brand, String size, String color, Date dateAdded, String model, double price, int quantity, String category, double discount, String description)throws IOException, ParseException {
		GarmentController.addToInventory(new GarmentModel(id, name, barcode, brand, size, color, dateAdded, model, price, quantity, category, discount, description));
	}
	
	public void removeGarment(String name) {
		GarmentController.removeGarment(name);
	}
	
	public void removeGarment(int id) {
		GarmentController.removeGarment(id);
	}
	
	public void addNewCashier(int id, String name, String gender, String position, Date dob, String phoneNumber, String email, double salary, String address, String password, String role) {
		CashierController.addNewCashier(new User(id, name, gender, dob, phoneNumber, email, salary, address, password, role));
	}
	
	public void removeCashier(String name) {
		CashierController.removeCashier(name);
	}
	
	public void removeCashier(int id) {
		CashierController.removeCashier(id);
	}
	
	public static void getInfo() throws IOException {
		
		List<String[]> info = Files.lines(Paths.get("C:/Users/High Tech/eclipse-workspace/ACP System/src/Controllers/ManagerInfo")).map(x -> x.split("-")).collect(Collectors.toList());
		
	}

}


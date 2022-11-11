package Controllers;

import java.util.ArrayList;
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
	
//	Manager(String args[])throws IOException, ParseException {
//		File managerInfo = new File("C:/Users/High Tech/eclipse-workspace/ACP System/src/Controllers/ManagerInfo");
//		
//		if(!managerInfo.exists()) {
//			managerInfo.createNewFile();
//		}
//		
//		User manager = new User(101, "Mars", "Female", new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2011"), "00000000000", "purpleempra@gmail.com", 23000.0, "Main Street", "123abc", "Manager");
//		
//		FileOutputStream fos = new FileOutputStream(managerInfo);
//		fos.write(manager.toString().getBytes());
//		
//		fos.flush();
//		fos.close();
//	}
	
//	public static void main(String args[])throws IOException {
//		
//	}
	
	static List<String[]> info;

	public static void addNewGarment()throws IOException, ParseException {
		GarmentController.addToInventory();
	}
	
	public static void removeGarment(String name) {
		GarmentController.removeGarment(name);
	}
	
	public static void removeGarment(int id) {
		GarmentController.removeGarment(id);
	}
	
	public static void showGarments(){
		GarmentController.printGarments();
	}
	
	public static String searchGarment(String name) throws IOException{
		ArrayList<GarmentModel> list = GarmentController.getGarments();
		for(int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i).getName()))
				return list.get(i).toString();
		}
		
		return "No such garment.";
	}
	
	public static String searchGarment(int id) throws IOException{
		ArrayList<GarmentModel> list = GarmentController.getGarments();
		for(int i = 0; i < list.size(); i++) {
			if(id == list.get(i).getID())
				return list.get(i).toString();
		}

		return "No such garment.";
	}
	
	public static String searchStaff(String name) throws IOException{
		ArrayList<User> list = CashierController.getStaff();
		for(int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i).getName()))
				return list.get(i).toString();
		}
		
		return "Staff doesn't exist.";
	}
	
	public static String searchStaff(int id) throws IOException{
		ArrayList<User> list = CashierController.getStaff();
		for(int i = 0; i < list.size(); i++) {
			if(id == list.get(i).getID())
				return list.get(i).toString();
		}

		return "Staff doesn't exist.";
	}
	
	public static void addNewCashier() throws IOException, ParseException {
		CashierController.addToStaff();
	}
	
	public static void removeCashier(String name) {
		CashierController.removeCashier(name);
	}
	
	public static void removeCashier(int id) {
		CashierController.removeCashier(id);
	}
	
	public static List<String[]> readManagerInfo() throws IOException {
		info = Files.lines(Paths.get("C:/Users/High Tech/eclipse-workspace/ACP System/src/Controllers/ManagerInfo")).map(x -> x.split("-")).collect(Collectors.toList());
		
		return info;
	}
	
	public static <T> T getManagerInfo(int x)throws IOException, ParseException {
		readManagerInfo();
		
		switch(x) {
		case 0:
			return (T) getID();
		case 1:
			return (T) getName();
		case 2:
			return (T) getGender();
		case 3:
			return (T) getDate();
		case 4:
			return (T) getPhoneNumber();
		case 5:
			return (T) getEmail();
		case 6:
			return (T) getSalary();
		case 7:
			return (T) getAddress();
		case 8:
			return (T) getPassword();
		case 9:
			return (T) getRole();
		default:
			return (T) "Please, enter valid input.";
		}
	}
	
	public static Integer getID() {
		return Integer.parseInt(info.get(0)[0].replace("User: [", "").trim());
	}
	
	public static String getName() {
		return info.get(0)[1].trim();
	}
	
	public static String getGender() {
		return info.get(0)[2].trim();
	}
	
	public static Date getDate() throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(info.get(0)[3].trim());
	}
	
	public static String getPhoneNumber() {
		return info.get(0)[4].trim();
	}
	
	public static String getEmail() {
		return info.get(0)[5].trim();
	}
	
	public static Double getSalary() {
		return Double.parseDouble(info.get(0)[6].trim());
	}
	
	public static String getAddress() {
		return info.get(0)[7].trim();
	}
	
	public static String getPassword() {
		return info.get(0)[8].trim();
	}
	
	public static String getRole() {
		return info.get(0)[9].replace("]", "").trim();
	}

}


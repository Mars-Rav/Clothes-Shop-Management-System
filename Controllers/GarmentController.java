package Controllers;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import Models.GarmentModel;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class GarmentController {

    static Scanner input = new Scanner(System.in);
    static File test = new File("C:\\Users\\Hasan sabah\\Documents\\NetBeansProjects\\minaproject\\src\\Controllers\\Inventory.txt");

    private static ArrayList<GarmentModel> inventory = new ArrayList<>();
    static public void addToInventory() throws IOException, ParseException {
    	
    	System.out.println("Enter ID:");
        int ID = Integer.parseInt(input.nextLine());

        System.out.println("Enter name:");
        String name = input.nextLine();

        System.out.println("Enter the barcode:");
        String barcode = input.nextLine();

        System.out.println("Enter brand:");
        String brand = input.nextLine();

        System.out.println("Enter size:");
        String size = input.nextLine();

        System.out.println("Enter color:");
        String color = input.nextLine();

        System.out.println("Enter model:");
        String model = input.nextLine();

        System.out.println("Enter price:");
        double price = Double.parseDouble(input.nextLine());

        System.out.println("Enter quantity:");
        int quantity = Integer.parseInt(input.nextLine());

        System.out.println("Enter the category:");
        String category = input.nextLine();

        System.out.println("Enter Description:");
        String description = input.nextLine();

        System.out.println("Enter Discount:");
        double discount = Double.parseDouble(input.nextLine());

        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = dateObj.format(formatter);
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
    	
        readFromFile();
        inventory.add(new GarmentModel(ID, name, barcode, brand, size, color, date1, model, price, quantity, category, discount, description));
        add();

    }


    public static void add() throws IOException, ParseException {

        try {
            FileOutputStream fos = new FileOutputStream(test);
            ObjectOutputStream out = new ObjectOutputStream(fos);

            out.writeObject(inventory);
            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    static void readFromFile() {

        try {

            FileInputStream fis = new FileInputStream(test);
            ObjectInputStream in = new ObjectInputStream(fis);

            inventory = (ArrayList<GarmentModel>) in.readObject();
            
            in.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static  void printGarments(){
        readFromFile();
        inventory.stream().forEach(p-> System.out.println(p));

    }
    
    public static ArrayList<GarmentModel> getGarments(){
        readFromFile();
        ArrayList<GarmentModel> list = (ArrayList<GarmentModel>) inventory.stream().collect(Collectors.toList());
        return inventory;

    }

    public static void removeGarment(String name) {
    	
    }
    
    public static void removeGarment(int id) {
    	
    }

}

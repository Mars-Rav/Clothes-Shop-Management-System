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
    static File test = new File("D:\\Users\\High Tech\\Downloads\\Clothes-Shop-Management-System-boutique-v.2.1_new-output\\Clothes-Shop-Management-System-boutique-v.2.1_new-output\\boutique\\src\\Controllers\\Inventory.txt");

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
        garmentTable(inventory);
//        inventory.stream().forEach(p-> System.out.println(p));
////////////////////////////



    }
    public static void garmentTable(ArrayList<GarmentModel> myGarment ){
        System.out.printf("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
        System.out.printf("+                                                                       Garments                                                                                     +%n");
//        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("+********************************************************************************************************************************************************************+");
        System.out.print("+");
        System.out.printf("%5s %10s %10s %10s %10s %15s %15s %10s %10s %10s %10s %10s %20s", " ID ","NAME", "Barcode", "brand", "size", "color", "dateAdded", "model", "price", "quantity", "category", "discount", "description");
        System.out.println("       +");
        System.out.printf("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
        for( GarmentModel garmentModel: myGarment){
            System.out.print("+");
            System.out.format("%5s %10s %10s %10s %10s %15s %15s %10s %10s %10s %10s %10s %20s",
                    garmentModel.getID(), garmentModel.getName(), garmentModel.getBarcode(), garmentModel.getBrand(),
                    garmentModel.getSize(),garmentModel.getColor(),garmentModel.getDateAdded(),garmentModel.getModel(),
                    garmentModel.getPrice(),garmentModel.getQuantity(),garmentModel.getCategory(),garmentModel.getDiscount(),
                    garmentModel.getDescription());
            System.out.println("       +");
        }
        System.out.printf("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");

    }
    
    public static ArrayList<GarmentModel> getGarments(){
        readFromFile();
        ArrayList<GarmentModel> list = (ArrayList<GarmentModel>) inventory.stream().collect(Collectors.toList());
        return inventory;

    }

    public static void removeGarment(String name) throws IOException, ParseException {
        readFromFile();
        inventory.removeIf(garmentModel ->name.equals(garmentModel.getName()));
        add();

    	
    }
    
    public static void removeGarment(int id) throws IOException, ParseException {
        readFromFile();
        inventory.removeIf(garmentModel ->id==(garmentModel.getID()));
        add();
    }

    public synchronized static void editGarment(int id) throws IOException, ParseException {
        ArrayList<GarmentModel> list = GarmentController.getGarments();
        ArrayList<GarmentModel> filtered= (ArrayList<GarmentModel>) list.stream().filter(garmentModel -> id==garmentModel.getID()).collect(Collectors.toList());
        if(filtered.isEmpty()){
            System.out.println( "No such garment.");
        }
        else {
            System.out.println(filtered.get(0));
            removeGarment(id);
            System.out.println("Enter the new info:");
            addToInventory();
        }
    }

    public synchronized static void editGarment(String name) throws IOException, ParseException {
        ArrayList<GarmentModel> list = GarmentController.getGarments();
        ArrayList<GarmentModel> filtered= (ArrayList<GarmentModel>) list.stream().filter(garmentModel -> name.equalsIgnoreCase(garmentModel.getName())).collect(Collectors.toList());
        if(filtered.isEmpty()){
            System.out.println( "No such garment.");
        }
        else {
            System.out.println(filtered.get(0));
            removeGarment(name);
            System.out.println("Enter the new info:");
            addToInventory();
        }
    }

    private synchronized static void createOwnGarment(int id, String name, String barcode, String brand, String size, String color, String model, double price, int quantity, String category, double discount, String description) throws ParseException, IOException {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = dateObj.format(formatter);
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);

        readFromFile();
        inventory.add(new GarmentModel(id, name, barcode, brand, size, color, date1, model, price, quantity, category, discount, description));
        add();
    }

    public synchronized static void editQuantity(GarmentModel garment, int quantity) throws ParseException, IOException {
        int newQty = garment.getQuantity() - quantity;
        removeGarment(garment.getID());
        createOwnGarment(garment.getID(), garment.getName(), garment.getBarcode(), garment.getBrand(), garment.getSize(), garment.getColor(), garment.getModel(), garment.getPrice(), newQty, garment.getCategory(), garment.getDiscount(), garment.getDescription());
    }

}
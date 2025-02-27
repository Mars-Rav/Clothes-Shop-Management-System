package Controllers;

import java.util.*;

import java.util.stream.Collectors;

import Models.GarmentModel;
import Models.InvoiceModel;

import java.util.Date;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Controllers.GarmentController.garmentTable;

public abstract class InvoiceController {

    static Scanner input = new Scanner(System.in);
    static File test = new File("D:\\Users\\High Tech\\Downloads\\Clothes-Shop-Management-System-boutique-v.2.1_new-output\\Clothes-Shop-Management-System-boutique-v.2.1_new-output\\boutique\\src\\Controllers\\Invoices.txt");

    private static ArrayList<InvoiceModel> invoices = new ArrayList<>();
    private static InvoiceModel invoice;

    public static void main(String args[]) throws IOException, ParseException {
    }

    public static void addToInvoices(String cashierName, int cashierID, int invoiceID, double totalPrice, HashMap<String, Double> totalPricePerType, ArrayList<GarmentModel> garmentsList) throws IOException, ParseException {

        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateString = dateObj.format(formatter);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
    	
        //readFromFile();
        invoice = new InvoiceModel(cashierName, cashierID, invoiceID, date, totalPrice, totalPricePerType, garmentsList);
        invoices.add(invoice);
        add();

    }

    public static void printInvoice(){
    	System.out.println(invoice);
    }

    public static void add() throws IOException, ParseException {

        try {
            FileOutputStream fos = new FileOutputStream(test);
            ObjectOutputStream out = new ObjectOutputStream(fos);

            out.writeObject(invoices);
            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        invoices.clear();
    }


    static void readFromFile() {

        try {

            FileInputStream fis = new FileInputStream(test);
            ObjectInputStream in = new ObjectInputStream(fis);

            invoices = (ArrayList<InvoiceModel>) in.readObject();
            
            in.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void searchInvoiceById(int id){
        readFromFile();
        ArrayList<InvoiceModel> filtered= (ArrayList<InvoiceModel>) invoices.stream().filter(invoiceModel -> id==(invoiceModel.getInvoiceID())).collect(Collectors.toList());
        if(filtered.isEmpty()){
            System.out.println( "No such Invoice.");
        }
        else {
            for (InvoiceModel invoiceModel : invoices){
                System.out.printf("+---------------------------------------------------------------------------------+%n");
                System.out.printf("+                                Invoice                                          +%n");
                System.out.println("+*********************************************************************************+");
                System.out.print("+");
                System.out.printf("%15s %20s %20s %20s ", "InvoiceID: "+invoiceModel.getInvoiceID(),"EmpName: "+invoiceModel.getEmpName(), "CashierID: "+invoiceModel.getCashierID(), " Date:"+new SimpleDateFormat("MM-dd-yyyy").format( invoiceModel.getDate()));
                System.out.println("  +");
                System.out.println("+*********************************************************************************+");
                System.out.print("+");
                System.out.printf("%5s %10s %20s %20s %20s ","ID", "name","price", "quantity", "sub total price");
                System.out.print(" +");
                System.out.println();
                System.out.printf("+---------------------------------------------------------------------------------+%n");

                for (GarmentModel garmentModel:invoiceModel.getGarmentsList()) {
                    System.out.print("+");
                    System.out.format("%5s %10s %19s %18s %20s ",
                            garmentModel.getID(), garmentModel.getName(),garmentModel.getPrice(),garmentModel.getQuantity(),garmentModel.getPrice()*garmentModel.getQuantity()
                            );
                    System.out.println("    +");


                }
                System.out.printf("+---------------------------------------------------------------------------------+%n");
                System.out.printf("+                            "+"TotalPrice : "+invoiceModel.getTotalPrice()+"                                   +%n");
                System.out.printf("+---------------------------------------------------------------------------------+%n");

            }

        }
    }
    public static  void printInvoices(){
        readFromFile();
//        invoices.stream().forEach(p-> System.out.println(p));
        /////////////////////////
        System.out.printf("+-----------------------------------------------------------------------+%n");
        System.out.printf("+                            Invoice                                    +%n");
        System.out.println("+***********************************************************************+");
        System.out.print("+");
        System.out.printf("%7s %10s %13s %15s %10s ", " InvoiceID ","EmpName", "CashierID", "TotalPrice", "getDate");
        System.out.println("       +");
        System.out.printf("+-----------------------------------------------------------------------+%n");
        for( InvoiceModel invoiceModel: invoices){
            System.out.print("+");
            System.out.format("%5s %15s %11s %15s %15s ",
                    invoiceModel.getInvoiceID(), invoiceModel.getEmpName(), invoiceModel.getCashierID(), invoiceModel.getTotalPrice()+"$2",
                    new SimpleDateFormat("MM-dd-yyyy").format( invoiceModel.getDate()));
            System.out.println("     +");
        }
        System.out.printf("+-----------------------------------------------------------------------+%n");


    }
    
    public static ArrayList<InvoiceModel> getInvoices(){
        readFromFile();
        ArrayList<InvoiceModel> list = (ArrayList<InvoiceModel>) invoices.stream().collect(Collectors.toList());
        return list;

    }
    
    public static HashMap<String, Double> calculateSameGarmentTotal(ArrayList<GarmentModel> garmentsList) {

        HashMap<String, Double> eachTypePrice = new HashMap<String, Double>();

        for(int i = 0; i < garmentsList.size(); i++) {
            eachTypePrice.put(garmentsList.get(i).getName(), garmentsList.get(i).getPrice() * garmentsList.get(i).getQuantity());
        }

        return eachTypePrice;

    }
    
    public static double calculateTotalPrice(ArrayList<GarmentModel> garmentsList) {
    	
		double totalPrice = 0;
		
		for(int i = 0; i < garmentsList.size(); i++){
		
			totalPrice = totalPrice + garmentsList.get(i).getPrice()*garmentsList.get(i).getQuantity();
		}
			
		return totalPrice;
	
    }

    public static void removeInvoice(int id) throws IOException, ParseException {
        readFromFile();
        invoices.removeIf(invoiceModel -> id==invoiceModel.getInvoiceID());
        add();
    	
    }
    


}
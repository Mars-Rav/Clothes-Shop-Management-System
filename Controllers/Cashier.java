package Controllers;

import Models.GarmentModel;
import Models.InvoiceModel;
import Models.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public abstract  class CashierController {
	  
    public static ArrayList<User> cashiers = new ArrayList<User>();

    public static void addNewCashier(User cashier){
	    
    	cashiers.add(cashier);
    }
	
    public static void removeCashier(String name){
    	
		for(int i = 0; i < cashiers.size(); i++){
				
			if(cashiers.get(i).getName().contains(name)){
				cashiers.remove(cashiers.get(i));
			}
		}  
    }
    
    public static void removeCashier(int id) {
    	for(int i = 0; i < cashiers.size(); i++){
			
			if(cashiers.get(i).getID() == id){
				cashiers.remove(cashiers.get(i));
			}
			
		}
    }
	
    public static File file = new File("sample.txt");

    public static void writetofile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        String textToBewritten = cashiers.toString();
        fos.write(textToBewritten.getBytes());
        fos.flush();
        fos.close();
    }

    public static void readtofile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        int i = fis.read();
        while (!(i == -1)) {
            char c = (char) i;
            System.out.print(c);
            i = fis.read();
        }
        fis.close();
    }
    
    public static void createNewInvoice(String cashierName, int cashierID, int invoiceID, Date date, double totalPrice, ArrayList<Double> totalPricePerType, ArrayList<GarmentModel> garmentsList) {
    	InvoiceController.addNewInvoice(new InvoiceModel(cashierName, cashierID, invoiceID, date, totalPrice, totalPricePerType, garmentsList));
    }
    
}

package Controller;

import Models.GarmentModel;
import Models.InvoiceModel;
import Models.User;
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
    
    public static void createNewInvoice(String cashierName, int cashierID, int invoiceID, Date date, ArrayList<GarmentModel> garmentsList) {
    	InvoiceController.addNewInvoice(new InvoiceModel(cashierName, cashierID, invoiceID, date, garmentsList));
    }
    
}



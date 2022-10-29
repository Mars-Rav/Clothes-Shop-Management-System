package Controller;

import Models.GarmentModel;
import Models.InvoiceModel;

import java.util.ArrayList;
import java.util.Date;

public abstract class InvoiceController {

    private static ArrayList<InvoiceModel> invoiceBodyList = new ArrayList<InvoiceModel>();
    
   
    
    public static void addNewInvoice(InvoiceModel Invoice)
    {
        invoiceBodyList.add(Invoice);
    }
    
    public static void removeInvoice(InvoiceModel Invoice)
    {
        invoiceBodyList.remove(Invoice);
    }
    
   public static double calculateTotalPrice(ArrayList<GarmentModel> garmentsList)
    {
	double totalPrice = 0;
	for(int i = 0; i < garmentsList.size(); i++){
	
		totalPrice = totalPrice + garmentsList.get(i).getPrice()*garmentsList.get(i).getQuantity();
	}
		
	return totalPrice;
    }
    
    public double calculateSameGarmentTotal(ArrayList<GarmentModel> garmentsList)
    {
    	double totalPriceForType = 0;
	    
	for(int i = 0; i < garmentsList.size(); i++)
	{
		totalPriceForType = garmentsList.get(i).getPrice() * garmentsList.get(i).getQuantity();
	}
		
	return totalPriceForType;
    }
    
}


package Models;

import Controller.InvoiceController;
import Models.GarmentModel;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceModel extends InvoiceHeader {
	
	public InvoiceModel(String cashierName, int cashierID, int invoiceID, Date date, ArrayList<GarmentModel> garmentsList) {
		super(cashierName, cashierID, invoiceID, date);
		
	}

}

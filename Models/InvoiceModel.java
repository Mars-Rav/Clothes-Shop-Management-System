package Models;

import Controller.InvoiceController;
import Models.GarmentModel;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceModel extends InvoiceHeader {
	
	private Double totalPrice;
	
	public InvoiceModel(String cashierName, int cashierID, int invoiceID, Date date, ArrayList<GarmentModel> garmentsList,double totalPrice) {
		super(cashierName, cashierID, invoiceID, date);
		setTotalPrice(totalPrice);
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}

}

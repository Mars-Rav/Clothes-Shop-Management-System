package Models;

import Models.GarmentModel;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceModel extends InvoiceHeader {
	
	private double totalPrice;
	private double totalPriceForType;
	
	public InvoiceModel(String cashierName, int cashierID, int invoiceID, Date date, double totalPrice, double totalPriceForType, ArrayList<GarmentModel> garmentsList) {
		super(cashierName, cashierID, invoiceID, date, totalPrice);
		setTotalPrice(totalPrice);
		setTotalPriceForType(totalPriceForType);
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPriceForType(double totalPriceForType) {
		this.totalPriceForType = totalPriceForType;
	}
	
	public Double getTotalPriceForType() {
		return totalPriceForType;
	}

}

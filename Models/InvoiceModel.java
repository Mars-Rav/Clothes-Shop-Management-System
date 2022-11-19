package Models;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceModel extends InvoiceHeader {

	private double totalPrice;
	private ArrayList<Double> totalPricePerType;

	public InvoiceModel(String cashierName, int cashierID, int invoiceID, Date date, double totalPrice, ArrayList<Double> totalPricePerType, ArrayList<GarmentModel> garmentsList) {
		super(cashierName, cashierID, invoiceID, date, totalPrice);
		setTotalPrice(totalPrice);
		setTotalPriceForType(totalPricePerType);
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPriceForType(ArrayList<Double> totalPriceForType) {
		this.totalPricePerType = totalPriceForType;
	}

	public ArrayList<Double> getTotalPriceForType() {
		return totalPricePerType;
	}

}

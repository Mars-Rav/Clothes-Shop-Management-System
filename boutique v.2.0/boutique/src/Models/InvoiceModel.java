package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class InvoiceModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final String ShopName = "Boutique";
	private double totalPrice;
	private HashMap<String, Double> totalPricePerType;
	private int cashierID;
	private String empName;

	public String getShopName() {
		return ShopName;
	}

	public HashMap<String, Double> getTotalPricePerType() {
		return totalPricePerType;
	}

	public int getCashierID() {
		return cashierID;
	}

	public String getEmpName() {
		return empName;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public Date getDate() {
		return date;
	}

	private int invoiceID;

	public ArrayList<GarmentModel> getGarmentsList() {
		return garmentsList;
	}

	private ArrayList<GarmentModel> garmentsList;

	@Override
	public String toString() {
		String a=(garmentsList==null)?"the inventory is empty": garmentsList.toString();
		return "InvoiceModel{" +
				"ShopName='" + ShopName + '\'' +
				"garmentsList"+a+
				", totalPrice=" + totalPrice +
				", totalPricePerType=" + totalPricePerType +
				", cashierID=" + cashierID +
				", empName='" + empName + '\'' +
				", invoiceID=" + invoiceID +

				", date=" + date +
				'}';
	}

	private Date date;
	
	public InvoiceModel(String cashierName, int cashierID, int invoiceID, Date date, double totalPrice, HashMap<String, Double> totalPricePerType, ArrayList<GarmentModel> garmentsList) {
		setID(cashierID);
		this.garmentsList=garmentsList;
		setCashierName(cashierName);
		setInvoiceID(invoiceID);
		setDate(date);
		setTotalPrice(totalPrice);
		setTotalPrice(totalPrice);
		setTotalPriceForType(totalPricePerType);
	}
	
	private void setDate(Date date) {
		this.date = date;
	}

	private void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	private void setCashierName(String cashierName) {
		empName = cashierName;
	}

	private void setID(int cashierID) {
		this.cashierID = cashierID;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPriceForType(HashMap<String, Double> totalPriceForType) {
		this.totalPricePerType = totalPriceForType;
	}
	
	public HashMap<String, Double> getTotalPriceForType() {
		return totalPricePerType;
	}
	
}

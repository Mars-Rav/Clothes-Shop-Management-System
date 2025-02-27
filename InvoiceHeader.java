package Models;
import java.util.Date;

public class InvoiceHeader {
	
	private int id;
	private String empName;
	private int invoiceID;
	private Date date;



	private Double totalPrice;
	
	private final String ShopName = "Boutique";
	
	public InvoiceHeader(String cashierName, int cashierID, int invoiceID, Date date, Double totalPrice){
		setID(cashierID);
		setCashierName(cashierName);
		setInvoiceID(invoiceID);
		setDate(date);
		setTotalPrice(totalPrice);
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public int getID() {
		return id;
	}
	
	public void setCashierName(String empName) {
		this.empName = empName;
	}
	public String getCashierName() {
		return empName;
	}
	
	public void setInvoiceID(int invoiceID){
		this.invoiceID = invoiceID;
	}
	
	public int getInvoiceID() {
		return invoiceID;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}

}

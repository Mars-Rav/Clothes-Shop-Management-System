import java.util.Date;

public class InvoiceHeader {
	
	private int id;
	private String empName;
	private Date date;
	
	private final String ShopName = "Boutique";
	
	InvoiceHeader(String cashierName, int cashierID, int invoiceID, Date date){
		
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public int getID() {
		return id;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpName() {
		return empName;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}

}

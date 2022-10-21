import java.util.Date;

public class InvoiceBody extends InvoiceHeader {
	
	InvoiceBody(String cashierName, int cashierID, int invoiceID, Date date){
		super(cashierName, cashierID, invoiceID, date);
	}

}
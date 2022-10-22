package Controller;

import java.util.Date;
import Models.InvoiceHeader;
import java.util.ArrayList;

public abstract class InvoiceHeaderController {
	
    public InvoiceHeaderController(String cashierName, int cashierID, int invoiceID) {

    	InvoiceHeader header = new InvoiceHeader(cashierName, cashierID, invoiceID, new Date());
    }

}

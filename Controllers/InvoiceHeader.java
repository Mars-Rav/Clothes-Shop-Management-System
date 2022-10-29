package Controllers;

import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import Models.GarmentModel;
import Models.InvoiceHeader;
import java.util.ArrayList;
import java.util.Date;

public abstract class InvoiceHeaderController {
	public static InvoiceHeader header;
    public InvoiceHeaderController(String cashierName, int cashierID, int invoiceID, ArrayList<GarmentModel> garmentsList) {

    	 header = new InvoiceHeader(cashierName, cashierID, invoiceID, new Date(), calculateTotalPrice(garmentsList));
    }
    
    public static double calculateTotalPrice(ArrayList<GarmentModel> garmentsList) {
    	
		double totalPrice = 0;
		
		for(int i = 0; i < garmentsList.size(); i++){
		
			totalPrice = totalPrice + garmentsList.get(i).getPrice()*garmentsList.get(i).getQuantity();
		}
			
		return totalPrice;
	
    }
	public static File  file = new File("sample.txt"); //Representing the File
	public static void writetofile() throws IOException{
		if(!file.exists()){
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		String textToBewritten = header.toString() ;
		fos.write(textToBewritten.getBytes());
		fos.flush();
		fos.close();
	}

	public static void readtofile() throws IOException{
		FileInputStream fis = new FileInputStream(file);
		int i = fis.read();
		while(!(i==-1)) {
			char c = (char)i;
			System.out.print(c);
			i = fis.read();
		}
		fis.close();
	}
}

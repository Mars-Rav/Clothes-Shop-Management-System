package Controllers;

import Models.GarmentModel;
import Models.InvoiceModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public abstract class InvoiceController {

    private static ArrayList<InvoiceModel> invoiceBodyList = new ArrayList<InvoiceModel>();



    public static void addNewInvoice(InvoiceModel Invoice)
    {
        invoiceBodyList.add(Invoice);
    }

    public static void removeInvoice(InvoiceModel Invoice)
    {
        invoiceBodyList.remove(Invoice);
    }

    public static ArrayList<Double> calculateSameGarmentTotal(ArrayList<GarmentModel> garmentsList) {

        ArrayList<Double> eachTypePrice = new ArrayList<>();

        for(int i = 0; i < garmentsList.size(); i++) {
            eachTypePrice.add(garmentsList.get(i).getPrice() * garmentsList.get(i).getQuantity());
        }

        return eachTypePrice;

    }
    public static File file = new File("invoice.txt"); //Representing the File
    public static void writetofile(File file) throws IOException {
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        String textToBewritten =invoiceBodyList.toString();
        fos.write(textToBewritten.getBytes());
        fos.flush();
        fos.close();
    }
    public static void readtofile(File file) throws IOException{
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

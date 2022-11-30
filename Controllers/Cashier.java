package Controllers;

import java.util.*;

import java.util.stream.Collectors;
import Models.GarmentModel;
import Models.User;
import java.io.*;
import java.text.ParseException;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class CashierController {

	static Scanner input = new Scanner(System.in);
	static File test = new File("C:\\Users\\Hasan sabah\\Documents\\NetBeansProjects\\minaproject\\src\\Controllers\\staff.txt");

	private static ArrayList<User> staff = new ArrayList<>();

        
       private static ServerSocket server;
	    private static int port = 8888;

	    public static void cashierServer() throws IOException, ClassNotFoundException{

	        server = new ServerSocket(port);

	        
	            System.out.println("Waiting for the client request");

	            Socket socket = server.accept();
while(true){
	            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

	            int message = (int) ois.readObject();
	            System.out.println("Message Received: " + message);
                    break;
}
//	            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//
//	            oos.writeObject("Hi Client " + message);

	            //ois.close();
	           // oos.close();
	           // socket.close();

	          //  if(message.equalsIgnoreCase("exit")) break;
	        
	        System.out.println("Shutting down Socket server!");

	        server.close();
    }
      
    public static void addToStaff() throws IOException, ParseException {
    	
    	System.out.println("Enter ID:");
        int ID = Integer.parseInt(input.nextLine());
                
        System.out.println("Enter name:");
        String name = input.nextLine();

        System.out.println("Enter the gender:");
        String gender = input.nextLine();

        System.out.println("Enter phone number:");
        String phoneNumber = input.nextLine();

        System.out.println("Enter email:");
        String email = input.nextLine();
        
        System.out.println("Enter salary:");
        double salary = Double.parseDouble(input.nextLine());

        System.out.println("Enter address:");
        String address = input.nextLine();

        System.out.println("Enter password:");
        String password = input.nextLine();
        
        System.out.println("Enter the role:");
        String role = input.nextLine();

        System.out.println("Enter Date of birth:");
        String dobString = input.nextLine();

//        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dobString);
    	
        readFromFile();
        staff.add(new User(ID, name, gender, dobString, phoneNumber, email, salary, address, password, role));
        add();

    }


    public static void add() throws IOException, ParseException {

        try {
            FileOutputStream fos = new FileOutputStream(test);
            ObjectOutputStream out = new ObjectOutputStream(fos);

            out.writeObject(staff);
            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    static void readFromFile() {

        try {
            FileInputStream fis = new FileInputStream(test);
            ObjectInputStream in = new ObjectInputStream(fis);


            staff = (ArrayList<User>) in.readObject();
            
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static  void printStaff(){
        readFromFile();
        staff.stream().forEach(p-> System.out.println(p));

    }
    
    public static ArrayList<User> getStaff(){
        readFromFile();
        ArrayList<User> list = (ArrayList<User>) staff.stream().collect(Collectors.toList());
        return list;

    }
    
    public static void createInvoice(User cashier) throws IOException, ParseException{
    	
        if(invoice_garments.isEmpty()){
        	
            System.out.println("the list of garments is empty!");
            
        }else {
        	InvoiceController.addToInvoices(cashier.getName(), cashier.getID(), 1, InvoiceController.calculateTotalPrice(invoice_garments), InvoiceController.calculateSameGarmentTotal(invoice_garments), invoice_garments);
        }
        
    }
    public static void ShowAllInvoice(){
    	
         if(InvoiceController.getInvoices().isEmpty()){
            System.out.println("the list of invoice is empty!");
        }
         else{
            System.out.println(InvoiceController.getInvoices().toString());
         }
         
    }
   public static ArrayList<GarmentModel> invoice_garments = new ArrayList<GarmentModel>();
   public static ArrayList<GarmentModel> garments = GarmentController.getGarments();

    public  static void showOneInvoice(){
            invoice_garments.forEach(
                    garmentModel -> {
                         System.out.println(garmentModel.toString()+"\n");
                    }
            );
    }
    
    public static void clearOneInvoice(){
           invoice_garments.clear();
    }         
    
    public static void addGarmentToInvoice(User cashier) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	System.out.println("enter the name of garment");
            String name = reader.readLine();
            
            if(name.equals("Exit"))
            	break;
            
            System.out.println("enter the quantity");
            int quantity = Integer.parseInt(reader.readLine());
            
            GarmentModel g = null;
            
            for(int i=0;i<garments.size();i++){
                if(garments.get(i).getName().equals(name)){
                    g=garments.get(i);
                     g.setQuantity(quantity);
                invoice_garments.add(g);
                    break;
                }
            }
        }
        
        if(invoice_garments.isEmpty()){
            System.out.println("the list of garments is empty!");
        }else {
        	
        	InvoiceController.addToInvoices(cashier.getName(), cashier.getID(), 1, InvoiceController.calculateTotalPrice(invoice_garments), InvoiceController.calculateSameGarmentTotal(invoice_garments) ,invoice_garments);
        	createInvoice(cashier);
        }
    }
    
    public static void writeInvoiceToFile(User cashier, int invoiceID, double totalPrice, ArrayList<Double> totalPricePerType, ArrayList<GarmentModel> garmentsList) throws IOException, ParseException {
    	
    	InvoiceController.addToInvoices(cashier.getName(), cashier.getID(), 1, InvoiceController.calculateTotalPrice(invoice_garments), InvoiceController.calculateSameGarmentTotal(invoice_garments), invoice_garments);
    }
    
//    public static void removeitemfrominvoice() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("enter the name of garment");
//        String name = reader.readLine();
//        invoice_garments.removeIf(garmentModel -> garmentModel.getName().equals(name));
//    }

    public static void removeCashier(String name) {
    	
    }
    
    public static void removeCashier(int id) {
    	
    }

}

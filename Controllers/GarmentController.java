package Controllers;
import Models.GarmentModel;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class GarmentController {

	private static ArrayList<GarmentModel> inventory = new ArrayList<GarmentModel>();

	public static void addToInventory(GarmentModel newGarment)throws IOException, ParseException {

		inventory.add(newGarment);

		File garmentInfo = new File ("C:/Users/High Tech/Desktop/Inventory.txt");
		
		if(!garmentInfo.exists()) {
			garmentInfo.createNewFile();
		}
		GarmentModel garment = new GarmentModel(124, "Mars", "677C31V", "Louis Vittoun", "S", "Blue", new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2011"), "YUI1", 200.0, 30, "Punk", 0.1, "Extra Nice");

		FileOutputStream fos = new FileOutputStream(garmentInfo);
		fos.write(garment.toString().getBytes());
	
		fos.flush();
		fos.close();

	}
	
	public static void  getInfo() throws IOException{
		Stream<String> info = Files.lines(Paths.get("C:\\Users\\High Tech\\Desktop/Inventory.txt"));
	}

	public static void removeGarment(String name){

		for(int i = 0; i < inventory.size(); i++){

			if(inventory.get(i).getName().contains(name)){
				inventory.remove(inventory.get(i));
			}
		}
    }

    public static void removeGarment(int id) {
    	for(int i = 0; i < inventory.size(); i++){

			if(inventory.get(i).getID() == id){
				inventory.remove(inventory.get(i));
			}

		}
    }

}

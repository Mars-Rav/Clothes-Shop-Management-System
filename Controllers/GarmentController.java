package Controller;

import java.util.ArrayList;
import Models.GarmentModel;

public abstract class GarmentController {
	
	private static ArrayList<GarmentModel> inventory = new ArrayList<GarmentModel>();
	
	
	public static void addToInventory(GarmentModel newGarment) {
		
		inventory.add(newGarment);
				
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

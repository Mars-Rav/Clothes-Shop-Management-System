package Controller;

import java.util.ArrayList;
import Models.GarmentModel;

public abstract class GarmentController {
	
	private static ArrayList<GarmentModel> inventory = new ArrayList<GarmentModel>();
	
	
	public static void addToInventory(GarmentModel newGarment) {
		
		inventory.add(newGarment);
				
	}
	
	public static void removeFromInventory(int option, String name, int id) {
		
		switch(option){
			case 1:
				for(int i = 0; i < inventory.size(); i++){
					
					if(inventory.get(i).getName().contains(name)){
						inventory.remove(inventory.get(i));
					}
				}
				
				break;
				
			case 2:
				for(int i = 0; i < inventory.size(); i++){
					
					if(inventory.get(i).getID() == id){
						inventory.remove(inventory.get(i));
					}
					
				}
				
				break;	
		}
	}
	
}

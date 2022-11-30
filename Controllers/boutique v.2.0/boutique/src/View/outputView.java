/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.CashierController;
import Controllers.Manager;
import Models.User;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hasan
 */
public class outputView {
      static Scanner input = new Scanner(System.in);
	static User cashier;
    public void output(PrintWriter p , BufferedReader b) throws IOException, ParseException, UnknownHostException, ClassNotFoundException, InterruptedException{
      
    boolean state = true;
		while(state) { 
		switch(logIn()) {
		case 2:
			while(true) {
				System.out.println();
				System.out.println("------------------------------------------------");
				System.out.println();
				CashierView.optionSelection(cashier);
			}
		case 1:
			
			state = false;
			System.out.println("------------------- Welcome -------------------");
			while(true) {
				System.out.println();
				System.out.println("------------------------------------------------");
				System.out.println();
				ManagerView.optionSelection();
			}
		case 0:
			System.out.println("Please make sure you entered the right info.");
			break;
		default:
			System.out.println("Invalid input.");
		}
		}
		
	}
	
	public static int logIn()throws IOException, ParseException {
		System.out.println("Enter your username: [Manager: Mars] [Cashier: Srusht]");
		String username = input.nextLine();
		System.out.println("Enter your password: [Manager: 123abc] [Cashier: password123]");
		String password = input.nextLine();
		
		if(username.equals((String) Manager.getManagerInfo(1)) && password.equals((String) Manager.getPassword()))
			return 1;
		
		ArrayList<User> staff = CashierController.getStaff();

		for(int i = 0; i < staff.size(); i++) {
			if(staff.get(i).getName().equals(username) && staff.get(i).getPassword().equals(password))
				if(staff.get(i).getRole().equalsIgnoreCase("cashier")) {
				cashier = staff.get(i);
				return 2;
				}else {
					System.out.println("You don't have access.");
				}
		}
		return 0;
	}
	
    
    }

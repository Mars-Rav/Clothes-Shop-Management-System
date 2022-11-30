/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpres;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Helper {
   BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   
    public Date convertStringToDate(String dob) throws IOException {
        Date date1 = null;
        while (true) {

            try {
                date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dob);

                break;
            } catch (ParseException e) {
                System.out.println("the date must be like (day/month/year)");
                String rightdate = input.readLine();
                dob = rightdate;
                
            }
        }
        return date1;
    }

    public String convertDateToString(Date dob) {

        String stringofdate;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        stringofdate = simpleDateFormat.format(dob);
        return stringofdate;

    }

}


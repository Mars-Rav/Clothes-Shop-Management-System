import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Staff {
    private Integer id;
    private String name;
    private String gender;
    private String position;
    private Date dob;
    private Integer phonenumber;
    private String email;
    private Double salary;
    private String address;
    private String password;
    Scanner input = new Scanner(System.in);

    public Staff(Integer id, String name, String gender, String position, String dob, Integer phonenumber, String email,
            Double salary, String address, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.dob = convertStringToDate(dob);
        this.phonenumber = phonenumber;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.password = password;
    }
    
}

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
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = convertStringToDate(dob);
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}

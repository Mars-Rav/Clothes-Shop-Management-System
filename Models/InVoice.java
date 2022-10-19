
import java.util.*;

public class InVoice {
	
	private int id;
	String empName;
	String date;
	
	//ArrayList<garment>garmentsList
	 ArrayList<Garment> alist = new ArrayList<Garment>();
	
	public InVoice(int ID, String empName, String date, ArrayList<Garment> alist) {
		setID(ID);
		setEmpName(empName);
		setDate(date);
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public int getID() {
		return id;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpName() {
		return empName;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	
}




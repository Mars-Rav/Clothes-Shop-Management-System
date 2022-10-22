import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GarmentModel {
	
	private int id;
	private String name;
	private String barcode;
	private String brand;
	private String size;
	private String color;
	private Date dateAdded;
	private String model;
	private double price;
	private int quantity;
	private String category;
	private double discount;
	private String description;
	
	public GarmentModel(int id, String name, String barcode, String brand, String size, String color, String dateAdded, String model, double price, int quantity, String category, double discount, String description) {
		setAll(id, name, barcode, brand, size, color, dateAdded, model, price, quantity, category, discount, description);
	}
	
	public void setAll(int id, String name, String barcode, String brand, String size, String color, String dateAdded, String model, double price, int quantity, String category, double discount, String description){
		setID(id);
		setName(name);
		setBarcode(barcode);
		setBrand(brand);
		setSize(size);
		setColor(color);
		setDateAdded(dateAdded);
		setModel(model);
		setPrice(price);
		setQuantity(quantity);
		setCategory(category);
		setDiscount(discount);
		setDescription(description);
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public String getBarcode() {
		return barcode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAddedString) {
		Date dateAdded;
		try {
			dateAdded = new SimpleDateFormat("dd-MM-yyyy").parse(dateAddedString);
			this.dateAdded = dateAdded;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String toString() {
		return "Garment: [" + id + " - " + name + " - " + barcode + " - " + price + " - " + quantity + " - " + category + " - " + discount + " - " + description + "]";
	}
	
}

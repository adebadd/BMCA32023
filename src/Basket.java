import java.util.ArrayList;
import java.io.Serializable;

public class Basket implements Serializable {


	private String items;
	private String quantity;
	private String vat;
	private String price;

	public Basket() {


		this.items = "";
		this.quantity = "";
		this.vat = "";
		this.price = "";
	}

	public Basket(String items, String quantity, String vat, String price) {
		this.items = items;
		this.quantity = quantity;
		this.vat = vat;
		this.price = price;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String toString() {
		return "Item: " + this.items + "\n" + "Quantity: " + this.quantity + "\n" + "Vat: " + this.vat + "\n"
				+ "Price: " + this.price + "\n";
	}

}

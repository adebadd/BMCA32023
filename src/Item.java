public class Item {
    private String itemName;
    private String itemOption;
    private String expirationDate;

    public Item() {
        this.itemName = "";
        this.itemOption = "";
        this.expirationDate = "";
    }

    public Item(String itemName, String itemOption, String expirationDate) {
        this.itemName = itemName;
        this.itemOption = itemOption;
        this.expirationDate = expirationDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemOption() {
        return itemOption;
    }

    public void setItemOption(String itemOption) {
        this.itemOption = itemOption;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
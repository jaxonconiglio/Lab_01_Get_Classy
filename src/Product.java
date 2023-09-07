import java.util.Calendar;

public class Product {

    Calendar cal = Calendar.getInstance();

    private String productName;

    private String description;

    private String ID;

    private double cost;

    public Product(String productName, String description, String ID, double cost) {
        this.productName = productName;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", cost=" + cost +
                '}';
    }
    public String toCSV(){ return productName + ", " + description + ", " + ID + ", " + cost;}

    public String getProductName() { return productName;}



}


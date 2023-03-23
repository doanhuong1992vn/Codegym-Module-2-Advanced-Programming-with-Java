package homework.invoice.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
    private String nameOfCustomer;
    private String nameOfProduct;
    private double price;
    private Date purchaseDate;

    public Invoice(String nameOfCustomer, String nameOfProduct, double price, String purchaseDate) throws ParseException {
        this.nameOfCustomer = nameOfCustomer;
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.purchaseDate = new SimpleDateFormat("dd/MM/yyyy").parse(purchaseDate);
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPurchaseDate() {
        return new SimpleDateFormat("dd MMMM yyyy").format(purchaseDate);
    }

    public long getMillisTimeOfPurchaseDate() {
        return purchaseDate.getTime();
    }

    @Override
    public String toString() {
        return nameOfCustomer + "\t\t\t"
                + nameOfProduct + "\t\t"
                + price + "\t\t"
                + getPurchaseDate() + "\n";
    }
}

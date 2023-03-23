package homework.shopee_project.entity;

public class Product {
    private final long id;
    private String name;
    private double price;
    private long categoryId;
    private static long count = 0;

    public Product() {
        this.id = ++count;
    }

    public Product(String name, double price, long categoryId) {
        this.id = ++count;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return name + ": ID = " + id + ", Price = " + price + " K VND";
    }
}

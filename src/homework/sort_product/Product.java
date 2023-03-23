package homework.sort_product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class Product {
    private String name;
    private int view;
    private String postingTime;
    private int timesPurchase;
    private double price;

    public Product(String name, int view, String postingTime, int timesPurchase, double price) {
        this.name = name;
        this.view = view;
        this.postingTime = postingTime;
        this.timesPurchase = timesPurchase;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getView() {
        return view;
    }

    public Date getPostingTime() throws ParseException {
        return new SimpleDateFormat("yyyy/MM/dd").parse(postingTime);
    }

    public long getMillisOfPostingTime() throws ParseException {
        return getPostingTime().getTime();
    }

    public int getTimesPurchase() {
        return timesPurchase;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        String dateToString;
        try {
            dateToString = new SimpleDateFormat("dd/MM/yyyy").format(getPostingTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return name + ": " + view + " view, " +
                timesPurchase + " times purchase, price = " + price + "K, post in " + dateToString;
    }
}

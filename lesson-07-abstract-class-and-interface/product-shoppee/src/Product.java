import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private String name;
    private int view;
//    private Date postingTime;
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

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getView() {
        return view;
    }

//    public void setView(int view) {
//        this.view = view;
//    }

    public Date getPostingTime() throws ParseException {
        return new SimpleDateFormat("yyyy/MM/dd").parse(postingTime);
    }

//    public void setPostingTime(String postingTime) {
//        this.postingTime = postingTime;
//    }
    public long getMillisOfPostingTime() throws ParseException {
        return getPostingTime().getTime();
    }

    public int getTimesPurchase() {
        return timesPurchase;
    }

//    public void setTimesPurchase(int timesPurchase) {
//        this.timesPurchase = timesPurchase;
//    }

    public double getPrice() {
        return price;
    }

//    public void setPrice(double price) {
//        this.price = price;
//    }

    @Override
    public String toString() {
        String dateToString = null;
        try {
            dateToString = new SimpleDateFormat("dd/MM/yyyy").format(getPostingTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return name + ": " + view + " view, " +
                timesPurchase + " times purchase, price = " + price + "K, post in " + dateToString;
    }
}

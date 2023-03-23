package homework.sort_product;

import java.text.ParseException;
import java.util.Comparator;

public class ProductPostingTimeComparator implements Comparator<Product> {
    @Override
    public int compare(Product firstProduct, Product secondProduct) {
        try {
            return Long.compare(secondProduct.getMillisOfPostingTime(), firstProduct.getMillisOfPostingTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

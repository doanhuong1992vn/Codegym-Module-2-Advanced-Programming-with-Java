package homework.sort_product;

import java.util.Comparator;

public class TimesPurchaseComparator implements Comparator<Product> {
    @Override
    public int compare(Product firstProduct, Product secondProduct) {
        return Integer.compare(secondProduct.getTimesPurchase(), firstProduct.getTimesPurchase());
    }
}

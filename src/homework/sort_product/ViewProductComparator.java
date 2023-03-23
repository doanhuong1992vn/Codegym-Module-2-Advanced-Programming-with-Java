package homework.sort_product;

import java.util.Comparator;

public class ViewProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product firstProduct, Product secondProduct) {
        final int LESS_THAN = -1;
        final int MORE_THAN = 1;
        if (firstProduct.getView() > secondProduct.getView()) {
            return LESS_THAN;
        } else if (firstProduct.getView() == secondProduct.getView()) {
            return Integer.compare(secondProduct.getTimesPurchase(), firstProduct.getTimesPurchase());
        } else {
            return MORE_THAN;
        }
    }
}

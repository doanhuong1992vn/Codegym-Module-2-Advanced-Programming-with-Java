import java.util.Comparator;
public class PriceComparator implements Comparator<Product>{
    @Override
    public int compare(Product firstProduct, Product secondProduct) {
        return Double.compare(firstProduct.getPrice(), secondProduct.getPrice());
    }
}

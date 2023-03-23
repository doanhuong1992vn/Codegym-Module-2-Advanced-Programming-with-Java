package homework.shopee_project.view;

import entity.Product;
import service.CartService;

import java.util.Map;
import java.util.TreeMap;

public class CartView {
    private final static CartService cartService = new CartService();

    public void displayCurrentCart() {
        TreeMap<Product, Integer> currentCart = cartService.getCurrentCart();
        if (currentCart.isEmpty()) {
            System.out.println("You have no items in your shopping cart.");
        } else {
            double sumPrice = 0;
            for (Map.Entry<Product, Integer> entry : currentCart.entrySet()) {
                String nameProduct = entry.getKey().getName();
                double priceOfProduct = entry.getKey().getPrice();
                int numberOfProduct = entry.getValue();
                double price = priceOfProduct * numberOfProduct;
                sumPrice += price;
                System.out.println("Sản phẩm: " + nameProduct +
                        ", Số lượng: " + numberOfProduct +
                        ", Thành tiền: " + price + " K VND");
            }
            System.out.println("Tổng tiền cần thanh toán: " + sumPrice + " K VND");
        }
    }

    public void addProductToCart(long idUser, Product product, Integer number) {
        cartService.addProductToCart(idUser, product, number);
    }
}

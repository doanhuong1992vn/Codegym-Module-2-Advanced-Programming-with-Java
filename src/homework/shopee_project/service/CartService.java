package homework.shopee_project.service;

import entity.Product;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class CartService {
    private final static HashMap<Long, TreeMap<Product, Integer>> sourceCarts = new HashMap<>();
    private static TreeMap<Product, Integer> currentCart = new TreeMap<>(Comparator.comparingLong(Product::getId));

    public TreeMap<Product, Integer> getCurrentCart() {
        return currentCart;
    }

    public void setCurrentCartByIdUser(long idUser) {
        if (sourceCarts.containsKey(idUser)) {
            currentCart = sourceCarts.get(idUser);
        } else {
            TreeMap<Product, Integer> newCart = new TreeMap<>(Comparator.comparingLong(Product::getId));
            sourceCarts.put(idUser, newCart);
            currentCart = newCart;
        }
    }

    public void addProductToCart(long idUser, Product product, Integer number) {
        if (currentCart.isEmpty()) {
            currentCart.put(product, number);
        } else {
            if (currentCart.containsKey(product)) {
                Integer oldNumber = currentCart.get(product);
                Integer newNumber = oldNumber + number;
                currentCart.replace(product, newNumber);
            } else {
                currentCart.put(product, number);
            }
        }
        sourceCarts.replace(idUser, currentCart);
    }
}

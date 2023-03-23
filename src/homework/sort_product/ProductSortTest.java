package homework.sort_product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProductSortTest {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[4] = new Product("Pant", 450, "2018/08/14", 70, 500);
        products[0] = new Product("T-Shirt", 500, "2020/02/02", 50, 200);
        products[1] = new Product("Polo", 250, "2019/02/18", 35, 300);
        products[3] = new Product("Jogger", 600, "2020/09/27", 65, 450);
        products[2] = new Product("Jacket", 450, "2021/04/30", 30, 800);
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome Man Shop!");
        renderProductList(products);
        int choice;
        while(true) {
            renderChoice();
            choice = input.nextInt();
            final int POPULAR = 1;
            final int LATEST = 2;
            final int SELLING = 3;
            final int PRICE_FROM_LOW_TO_HIGH = 4;
            final int PRICE_FROM_HIGH_TO_LOW = 5;
            final int EXIT = 0;
            switch (choice) {
                case POPULAR -> {
                    sortByPopular(products);
                    renderProductList(products);
                }
                case LATEST -> {
                    sortByLatest(products);
                    renderProductList(products);
                }
                case SELLING -> {
                    sortByTimesPurchase(products);
                    renderProductList(products);
                }
                case PRICE_FROM_LOW_TO_HIGH -> {
                    sortPriceComparator(products);
                    renderProductList(products);
                }
                case PRICE_FROM_HIGH_TO_LOW -> {
                    reversePriceComparator(products);
                    renderProductList(products);
                }
                case EXIT -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
    private static void renderProductList(Product[] products){
        System.out.println("Products List: ");
        for(Product product: products){
            System.out.println(product);
        }
    }
    private static void renderChoice(){
        System.out.println("Sort by:");
        System.out.println("1. Popular");
        System.out.println("2. Latest");
        System.out.println("3. Selling");
        System.out.println("4. Price from low to high");
        System.out.println("5. Price from high to low");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void sortByPopular(Product[] products){
        Comparator<Product> viewProductComparator = new ViewProductComparator();
        Arrays.sort(products, viewProductComparator);
    }
    private static void sortByLatest(Product[] products){
        Comparator<Product> postingTimeComparator = new ProductPostingTimeComparator();
        Arrays.sort(products, postingTimeComparator);
    }
    private static void sortByTimesPurchase(Product[] products) {
        Comparator<Product> timesPurchaseComparator = new TimesPurchaseComparator();
        Arrays.sort(products, timesPurchaseComparator);
    }
    private static void sortPriceComparator(Product[] products){
        Comparator<Product> priceComparator = new PriceComparator();
        Arrays.sort(products, priceComparator);
    }
    private static void reversePriceComparator(Product[] products){
        Comparator<Product> priceComparator = new PriceComparator();
        Arrays.sort(products, priceComparator.reversed());
    }
}
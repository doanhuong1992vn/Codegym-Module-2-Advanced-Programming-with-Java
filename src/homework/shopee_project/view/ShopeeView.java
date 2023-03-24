package homework.shopee_project.view;

import homework.shopee_project.entity.Product;
import homework.shopee_project.entity.User;

public class ShopeeView {
    private final static CartView cartView = new CartView();
    private final static ProductView productView = new ProductView();
    private final static UserView userView = new UserView();
    private static long currentCategoryId;

    public void displayHomePage() {
        System.out.println("""
                Welcome to Shopee!
                1. Sign Up
                2. Sign In
                3. Display product catalog screen""");
        int choice = Integer.parseInt(View.prompt("Enter your choice:"));
        switch (choice) {
            case 1 -> {
                System.out.println("Sign Up");
                userView.displaySignUp();
                displayAfterSignIn();
            }
            case 2 -> {
                System.out.println("Sign In");
                userView.displaySignIn();
                displayAfterSignIn();
            }
            case 3 -> displayCategorySelectionScreen();
            default -> {
                System.out.println("Invalid choice!");
                displayHomePage();
            }
        }
    }

    public void displayAfterSignIn() {
        System.out.println("""
                1. Display product catalog screen
                2. Check your cart
                3. Sign out""");
        int choice = Integer.parseInt(View.prompt("Enter your choice:"));
        switch (choice) {
            case 1 -> displayCategorySelectionScreen();
            case 2 -> displayCurrentCart();
            case 3 -> signOutAndDisplayHomePage();
            default -> {
                System.out.println("Invalid input!");
                displayAfterSignIn();
            }
        }
    }

    private void signOutAndDisplayHomePage() {
        userView.setCurrentUserByNull();
        displayHomePage();
    }

    public void displayCurrentCart() {
        cartView.displayCurrentCart();
        System.out.println("""
                Đã hoàn thiện tính năng thêm vào giỏ hàng.
                Xin mời sign out và quay lại xem thử!
                1. Sign out""");
        int choice = Integer.parseInt(View.prompt("Enter your choice:"));
        switch (choice) {
            case 1 -> signOutAndDisplayHomePage();
            default -> {
                System.out.println("Invalid input!");
                displayCurrentCart();
            }
        }
    }

    public void displayAddToCartFeature() {
        System.out.println("""
                1. Add to cart by product ID
                2. Check your cart
                3. Back to product catalog screen
                4. Back to home page
                5. Sign out""");
        int choice = Integer.parseInt(View.prompt("Enter your choice: "));
        switch (choice) {
            case 1 -> {
                if (userView.getCurrentUser() != null) {
                    displayProcessOfAddingToCart();
                } else {
                    System.out.println("Please login to add products to cart!");
                    displayRequestSignIn();
                }
            }
            case 2 -> {
                if (userView.getCurrentUser() != null) {
                    displayCurrentCart();
                } else {
                    System.out.println("Please login to view cart");
                    displayRequestSignIn();
                }
            }
            case 3 -> displayCategorySelectionScreen();
            case 4 -> displayHomePage();
            case 5 -> signOutAndDisplayHomePage();
            default -> {
                System.out.println("Invalid input!");
                displayAddToCartFeature();
            }
        }
    }

    private void displayCategorySelectionScreen() {
        productView.displayCategoriesList();
        currentCategoryId = productView.getCurrentCategoryId();
        displayAddToCartFeature();
    }

    public void displayRequestSignIn() {
        System.out.println("""
                1. Sign up
                2. Sign in
                3. Go back
                4. Back to home page""");
        int choice = Integer.parseInt(View.prompt("Enter your choice: "));
        switch (choice) {
            case 1 -> {
                System.out.println("Sign Up");
                userView.displaySignUp();
                displayProductSelectionScreen();
            }
            case 2 -> {
                System.out.println("Sign In");
                userView.displaySignIn();
                displayProductSelectionScreen();
            }
            case 3 -> displayProductSelectionScreen();
            case 4 -> displayHomePage();
        }
    }

    private void displayProductSelectionScreen() {
        productView.displayCurrentProductsList(currentCategoryId);
        displayAddToCartFeature();
    }

    public void displayProcessOfAddingToCart() {
        long idProduct = Long.parseLong(View.prompt("Enter the product id: "));
        if (productView.isValidProductId(idProduct)) {
            User currentUser = userView.getCurrentUser();
            long idUser = currentUser.getId();
            Product currentProduct = productView.getCurrentProduct();
            int number = Integer.parseInt(View.prompt("Enter number: "));
            cartView.addProductToCart(idUser, currentProduct, number);
            System.out.println("Add " + currentProduct.getName() + " to cart successfully");
            productView.displayCurrentProductsList(currentCategoryId);
            displayAddToCartFeature();
        } else {
            System.out.println("Invalid ID!");
            displayProcessOfAddingToCart();
        }
    }
}

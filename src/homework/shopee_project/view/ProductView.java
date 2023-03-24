package homework.shopee_project.view;

import homework.shopee_project.entity.Category;
import homework.shopee_project.entity.Product;
import homework.shopee_project.service.CategoryService;
import homework.shopee_project.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductView {
    private final static CategoryService categoryService = new CategoryService();
    private final static ProductService productService = new ProductService();

    private static long currentCategoryId;

    public long getCurrentCategoryId() {
        return currentCategoryId;
    }

    public boolean isValidCategoryId(long idCategory) {
        return categoryService.checkIdAndSetCurrentCategoryIfAvailable(idCategory);
    }

    public boolean isValidProductId(long idProduct) {
        return productService.checkIdAndSetCurrentProductIfAvailable(idProduct);
    }

    public Product getCurrentProduct() {
        return productService.getCurrentProduct();
    }

    public void displayCategoriesList() {
        List<Category> categoriesList = categoryService.getCategoriesList();
        categoriesList.forEach(System.out::println);
        currentCategoryId = Long.parseLong(View.prompt("Enter Category ID to display details: "));
        if (isValidCategoryId(currentCategoryId)) {
            System.out.println(categoryService.getNameOfCurrentCategory());
            displayCurrentProductsList(currentCategoryId);
        } else {
            System.out.println("Invalid input!");
            displayCategoriesList();
        }
    }

    public void displayCurrentProductsList(long idCategory) {
        ArrayList<Product> currentProductList = productService.getCurrentProductList(idCategory);
        currentProductList.forEach(System.out::println);
    }
}

package homework.shopee_project.service;

import homework.shopee_project.entity.Category;

import java.util.ArrayList;

public class CategoryService {
    private static final ArrayList<Category> categoriesList;
    private static Category currentCategory;

    static {
        categoriesList = new ArrayList<>();
        categoriesList.add(new Category("Man Fashion"));
        categoriesList.add(new Category("Women Fashion"));
        categoriesList.add(new Category("Mobile Phone"));
        categoriesList.add(new Category("Mom & Baby"));
        categoriesList.add(new Category("Laptop"));
        categoriesList.add(new Category("Watch"));
        categoriesList.add(new Category("Man Shoes"));
        categoriesList.add(new Category("Women Shoes"));
    }

    public CategoryService() {
    }

    public ArrayList<Category> getCategoriesList() {
        return categoriesList;
    }

    public boolean checkIdAndSetCurrentCategoryIfAvailable(long idCategory) {
        for (Category category : categoriesList) {
            if (category.getId() == idCategory) {
                currentCategory = category;
                return true;
            }
        }
        return false;
    }

    public String getNameOfCurrentCategory() {
        return currentCategory.getName();
    }

    public void addCategory(Category newCategory) {
        String name = newCategory.getName();
        boolean flag = true;
        for (Category category : categoriesList) {
            if (name.equals(category.getName())) {
                System.out.println("Add failed. " + newCategory.getName() + " already in the catalog");
                flag = false;
                break;
            }
        }
        if (flag) {
            categoriesList.add(newCategory);
            System.out.println(newCategory.getName() + " have been successfully added to the catalog");
        }
    }

    public void removeCategory(long id) {
        if (checkIdAndSetCurrentCategoryIfAvailable(id)) {
            categoriesList.remove(currentCategory);
            System.out.println(currentCategory.getName() + " have been removed from the catalog");
        } else {
            System.out.println("Remove failed. ID " + id + " not in the catalog");
        }
    }
}

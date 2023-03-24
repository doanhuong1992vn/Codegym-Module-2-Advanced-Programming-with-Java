package homework.shopee_project.view;

import homework.shopee_project.entity.User;
import homework.shopee_project.service.CartService;
import homework.shopee_project.service.UserService;

public class UserView {
    private final static UserService userService = new UserService();
    private final static CartService cartService = new CartService();

    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    public void setCurrentUserByNull() {
        userService.setCurrentUserByNull();
    }

    public void displaySignUp() {
        String username = View.prompt("Enter your username: ");
        String password = View.prompt("Enter your password: ");
        if (userService.checkUserName(username)) {
            userService.createAccountAndSave(username, password);
            User currentUser = userService.getCurrentUser();
            cartService.setCurrentCartByIdUser(currentUser.getId());
            System.out.println("Successful registration with username " + username + ". Welcome " + username + "!");
        } else {
            System.out.println(username + " has been registered.");
            System.out.println("Please enter another username!");
            displaySignUp();
        }
    }

    public void displaySignIn() {
        String username = View.prompt("Enter username: ");
        String password = View.prompt("Enter password: ");
        if (userService.checkSignIn(username, password)) {
            User currentUser = userService.getCurrentUser();
            cartService.setCurrentCartByIdUser(currentUser.getId());
            System.out.println("Logged in successfully. Welcome " + username + "!");
        } else {
            System.out.println("Login information is incorrect. Please sign in again!");
            displaySignIn();
        }
    }
}

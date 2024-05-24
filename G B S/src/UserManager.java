import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private User currentUser;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void register(String username, String password, String name) {
        users.add(new Student(username, password, name));
        System.out.println("Registration successful. You can now login.");
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful.");
                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public void logout() {
        currentUser = null;
        System.out.println("Logout successful.");
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Student getCurrentStudent() {
        if (currentUser instanceof Student) {
            return (Student) currentUser;
        }
        return null;
    }
}

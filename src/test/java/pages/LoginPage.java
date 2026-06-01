package pages;

import elements.Button;
import elements.TextBox;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    public static final TextBox userField = new TextBox(By.id("user-name"));
    public static final TextBox passwordField = new TextBox(By.id("password"));
    public static final Button loginBtn = new Button(By.id("login-button"));
    public static final TextBox lockedUserMsg = new TextBox(By.xpath("//div[@class = 'error-message-container error']/h3"));
    public static final TextBox userLoginsList = new TextBox(By.xpath("//div[@class = 'login_credentials']"));

    public static String detectLogin(int row) {
        String valToSplit = "_user";
        String valToSplit2 = "Accepted usernames are:";
        List<String> logsList = new ArrayList<>(List.of(userLoginsList.getValue().split(valToSplit)));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < logsList.size(); i++) {
            if (row < logsList.size() && row > 0) {
                result.add(logsList.get(i) + "_user");
            } else {
                throw new IllegalArgumentException("Invalid row value " + row);
            }
        }
        if (row == 1) {
            List<String> firstLog = List.of(result.get(0).split(valToSplit2));
            return firstLog.get(row);
        } else {
            return result.get(row - 1);
        }
    }


    public static void userLogin(String username, String password) {
        userField.setValue(username);
        passwordField.setValue(password);
        loginBtn.click();
    }
}
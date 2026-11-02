package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Login {
    WebDriver driver;
    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Add your WebElement locators and methods here
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    public void clickLoginButton() {
        loginButton.click();
    }
    public boolean isDashboardDisplayed() {
        // Implement logic to check if the dashboard is displayed after login
        // For example, you can check for the presence of a specific element on the dashboard
        return driver.findElements(By.xpath("(//a[contains(text(), 'Dashboard')])[1]")).size() > 0;
    }

    public String getErrorMessage() {
        // Implement logic to retrieve the error message displayed on the login page
        WebElement errorMessageElement = driver.findElement(By.xpath(""));
        return errorMessageElement.getText();
    }

//    public String getErrorMessage();
//
//    public String getUsernameValidationMessage();
//
//    public String getPasswordValidationMessage();
//
//    public boolean isLoginButtonDisplayed();
//
//    public boolean isUsernameDisplayed();
//
//    public boolean isPasswordDisplayed();
//
//    public String getPasswordFieldType();
//
//    public void clickLogout();
//
//    public void clickForgotPassword();



}
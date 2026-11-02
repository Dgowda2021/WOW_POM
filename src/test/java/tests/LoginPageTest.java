package tests;

import base.BaseLogin;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

import static utilities.ConfigReader.getPassword;
import static utilities.ConfigReader.getUserName;

public class LoginPageTest extends BaseLogin {
    // You can add test methods here that will use the setup from BaseLogin
    @Test(priority = 1)
    public void successLoginTest() throws IOException {
        Login login = new Login(driver);
        login.enterUsername(getUserName());
        login.enterPassword(getPassword());
        login.clickLoginButton();
        // Add assertions to verify failed login
        Assert.assertTrue(
                login.isDashboardDisplayed(),
                "Dashboard is not displayed after successful login");
        System.out.println("Success login test executed successfully");
    }
    @Test (priority = 2)
    public void FailedLoginTest() throws IOException {
        // Add assertions or further test steps here
        Login login = new Login(driver);
        login.enterUsername("testuser");
        login.enterPassword("wow@123");
        login.clickLoginButton();
        System.out.println("Failed login test executed successfully");
        // Add assertions to verify failed login
    }
        @Test(priority = 3)
        public void invalidUsernameTest() throws IOException {
            Login login = new Login(driver);
            login.enterUsername("invaliduser");
            login.enterPassword(getPassword());
            login.clickLoginButton();
            System.out.println("Invalid user name login test executed successfully");
//            Assert.assertEquals(
//                    login.getErrorMessage(),
//                    "Invalid username or password");
        }
        // TC03 - Invalid Password
        @Test(priority = 4)
        public void invalidPasswordTest() throws IOException {
            Login login = new Login(driver);
            login.enterUsername(getUserName());
            login.enterPassword("WrongPassword");
            login.clickLoginButton();
            System.out.println("Invalid pwd login test executed successfully");
//            Assert.assertEquals(
//                    login.getErrorMessage(),
//                    "Invalid username or password");
        }
        // TC04 - Invalid Username and Password
        @Test(priority = 5)
        public void invalidCredentialsTest() {
            Login login = new Login(driver);
            login.enterUsername("wronguser");
            login.enterPassword("wrongpassword");
            login.clickLoginButton();
            System.out.println("Invalid credentials login test executed successfully");

//            Assert.assertEquals(
//                    login.getErrorMessage(),
//                    "Invalid username or password");
        }
        // TC05 - Blank Username
        @Test(priority = 6)
        public void blankUsernameTest() throws IOException {
            Login login = new Login(driver);
            login.enterPassword(getPassword());
            login.clickLoginButton();
            System.out.println("BlankUserName login test executed successfully");

//            Assert.assertEquals(
//                    login.getUsernameValidationMessage(),
//                    "Username is required");
        }
        // TC06 - Blank Password
        @Test(priority = 7)
        public void blankPasswordTest() throws IOException {
            Login login = new Login(driver);
            login.enterUsername(getUserName());
            login.clickLoginButton();
            System.out.println("Blank pwd login test executed successfully");

//            Assert.assertEquals(
//                    login.getPasswordValidationMessage(),
//                    "Password is required");
        }
        // TC07 - Blank Username and Password
        @Test(priority = 8)
        public void blankCredentialsTest() {
            Login login = new Login(driver);
            login.clickLoginButton();
            System.out.println("Blank Credentials login test executed successfully");

//            Assert.assertEquals(
//                    login.getUsernameValidationMessage(),
//                    "Username is required");
//
//            Assert.assertEquals(
//                    login.getPasswordValidationMessage(),
//                    "Password is required");
        }
        // TC15 - SQL Injection Check
        @Test(priority = 9)
        public void sqlInjectionTest() {
            Login login = new Login(driver);
            login.enterUsername("' OR '1'='1");
            login.enterPassword("' OR '1'='1");
            login.clickLoginButton();
            System.out.println("SQL Injection login test executed successfully");
//            Assert.assertEquals(
//                    login.getErrorMessage(),
//                    "Invalid username or password");
        }
    }


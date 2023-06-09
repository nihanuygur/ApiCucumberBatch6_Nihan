package com.devex.pages;


import com.devex.utilities.ConfigurationReader;
import com.devex.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtnLoginPage;

    @FindBy(partialLinkText = "Forgot")
    public WebElement forgotPassword;

    @FindBy(xpath = "//*[text()='Invalid Credentials!']")
    public WebElement invalidText;


    public void loginTeacher(){
        String email= ConfigurationReader.get("email");
        String password = ConfigurationReader.get("password");
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtnLoginPage.click();
    }

    public void login(String username,String password){
        understandBtn.click();
        loginBtnBasePage.click();
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtnLoginPage.click();
    }
    public void setup() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));
        login(ConfigurationReader.get("email"),ConfigurationReader.get("password"));
        Thread.sleep(2000);
    }

    public String getNewCompanyName(String company){
        return   Driver.get().findElement(By.xpath("//td[text()='"+company+"']")).getText();
    }

}

package com.devex.pages;

import com.devex.utilities.ConfigurationReader;
import com.devex.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class PostPage extends BasePage{

    @FindBy(xpath = "//*[@id='post-item-edit-post-icon']/../../../p")
    public WebElement textField;

    @FindBy(xpath = "//*[text()='All Posts']")
    public WebElement postMenu;

    @FindBy(css = "#posts-heading")
    public WebElement postHeader;


    public void navigatePostPage() {

        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        new LoginPage().login(ConfigurationReader.get("email"), ConfigurationReader.get("password"));

        postMenu.click();

        Assert.assertEquals("Posts", postHeader.getText());
    }

    public String  getTextField(){
        return   textField.getText();

    }


}

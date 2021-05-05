package page;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {
    protected WebDriver driver;

    @FindBy(id = "at-cv-lightbox-close")
    WebElement closeBox;

    @FindBy(xpath = "//*[@id='navbar-brand-centered']/ul[1]/li[1]/a")
    WebElement inputForms;

    @FindBy(xpath = "//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a")
    WebElement simpleForDemo;


    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closePopUp() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        if (closeBox.isDisplayed()) {
            closeBox.click();
        }
    }

    public FirstFormPage navigateToSimpleForDemo() {
        inputForms.click();
        simpleForDemo.click();
        return new FirstFormPage(driver);
    }

}

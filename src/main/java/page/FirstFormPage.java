package page;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstFormPage {
    protected WebDriver driver;

    @Getter
    @Setter

    @FindBy(id = "user-message")
    WebElement userMessage;

    @FindBy(id = "display")
    WebElement displayMessage;

    @FindBy(xpath = "//*[@id='get-input']/button")
    WebElement showMessage;

    public FirstFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillMessage(String text) {
        userMessage.sendKeys(text);
    }

    public void showMessage() {
        showMessage.click();
    }

    public String getMessage() {
        return userMessage.getAttribute("value");
    }

    public boolean isMessageVisible() {
        return userMessage.isDisplayed();
    }

    public boolean checkMessageValue(String text) {
        String myMessage = getMessage();
        return myMessage.contains(text);
    }


}



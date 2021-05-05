package page;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstFormPage {
    protected WebDriver driver;

    @FindBy(id = "user-message")
    WebElement userMessage;

    @FindBy(id = "display")
    WebElement displayMessage;

    @FindBy(xpath = "//*[@id='get-input']/button")
    WebElement showMessage;

    @FindBy(id = "sum1")
    WebElement valueA;

    @FindBy(id = "sum2")
    WebElement valueB;

    @FindBy(xpath = "//*[@id='gettotal']/button")
    WebElement getTotal;

    @FindBy(id = "displayvalue")
    WebElement displayValue;

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

    public void FillValueA(int number) {
        String value = String.valueOf(number);
        valueA.sendKeys(value);
    }

    public void FillValueB(int number) {
        String value = String.valueOf(number);
        valueB.sendKeys(value);
    }

    public void pushButtonTotal() {
        getTotal.click();
    }

    public String getTotalValue()  {
        return displayValue.getText();
    }

    public Boolean isTotalValueCorrect(int expectedResult) {
        String result = getTotalValue();
        String expResult = String.valueOf(expectedResult);
        return result.contains(expResult);
    }

}



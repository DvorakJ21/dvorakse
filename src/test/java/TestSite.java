
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.FirstFormPage;
import page.MainPage;

import javax.swing.text.StyledEditorKit;

public class TestSite {

    private WebDriver driver;

    @BeforeEach
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.get("https://www.seleniumeasy.com/test/");
    }


    @Test
    public void FillTestForms() throws InterruptedException {
    String message = "test Jirka";
    int a = 1;
    int b = 2;

    MainPage mainPage = new MainPage(driver);
    mainPage.closePopUp();
    FirstFormPage firstFormPage = mainPage.navigateToSimpleForDemo();
    firstFormPage.fillMessage(message);
    firstFormPage.showMessage();
    Assertions.assertTrue(firstFormPage.isMessageVisible(), "Message is not visible on the page");
    System.out.println("Message is visible on the page");
    Boolean isMessageCorrect = firstFormPage.checkMessageValue(message);
    Assertions.assertTrue(isMessageCorrect, "Your message doesn't contain value: " + message);
    System.out.println("Your message contain value: " + message);

    firstFormPage.FillValueA(a);
    firstFormPage.FillValueB(b);
    firstFormPage.pushButtonTotal();
    Boolean result = firstFormPage.isTotalValueCorrect(a+b);
    Assertions.assertTrue(result, "The result is incorrect");
    System.out.println("The result is correct");
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();

    }
}

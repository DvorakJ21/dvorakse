
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.FirstFormPage;
import page.MainPage;

public class TestSite extends BeforeTest {



@Test
    public void FillTestForms() throws InterruptedException {
    String message = "test Jirka";
    int a = 1;
    int b = 2;

    MainPage mainPage = openUrl("https://www.seleniumeasy.com/test/");
    mainPage.closePopUp();
    FirstFormPage firstFormPage = mainPage.navigateToSimpleForDemo();
    firstFormPage.fillMessage(message);
    firstFormPage.showMessage();
    Assertions.assertTrue(firstFormPage.isMessageVisible(), "Message is not visible on the page");
    System.out.println("Message is visible on the page");
    Boolean isMessageCorrect = firstFormPage.checkMessageValue(message);
    Assertions.assertTrue(isMessageCorrect, "Your message doesn't contain value: " + message);
    System.out.println("Your message contain value: " + message);










    }
}

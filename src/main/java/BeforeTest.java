import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import page.MainPage;

public class BeforeTest {

    public MainPage openUrl(String url) {
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        return new MainPage(driver);
    }
}
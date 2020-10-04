import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class BasicTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = Driver.get("chrome");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        driver.get("http://google.com");
        BrowserUtils.wait(2);
        driver.navigate().to("http://amazon.com");
        BrowserUtils.wait(3);
        driver.navigate().back();
        BrowserUtils.wait(2);
        driver.navigate().forward();
        BrowserUtils.wait(2);
        driver.navigate().refresh();


    }


    @Test
    public void randomTest() {

        BrowserUtils.wait(2);
        String title = driver.getTitle();

        String expectedTitle = "Google";


        Assert.assertEquals(title, expectedTitle);

//        if (title.equals(expectedTitle)) {
//            System.out.println("Test passed");
//        } else
//            System.out.println("Test Failed");

    }

    @Test
    public void secondTest() {
        String url = driver.getCurrentUrl();
        String expectedUrl = "https://www.google.com/";
        Assert.assertEquals(expectedUrl, url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        Driver.close();



    }


}


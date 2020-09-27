import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicTest {
    ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://google.com");

    }


    private void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void randomTest() {

        wait(2);
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
        driver.close();
    }
}


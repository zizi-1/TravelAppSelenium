package Test.selenium;

import com.bae.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class addPoi {
    private WebDriver driver;

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        System.setProperty(Constants.PROPERTY, Constants.PATH);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get("http://localhost:" + port);
        PoiPage poiPage = PageFactory.initElements(driver, PoiPage.class);
        poiPage.selectPoiPage();
        poiPage.addPoi("dubai", "https://www.dubai.com");
    }

    @After
    public void tearDown() {
        this.driver.close();
    }

}

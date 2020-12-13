import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.xpath.operations.Bool;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpResponse;
import sun.plugin.dom.core.Element;

import java.sql.Driver;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FirstTest {

  private final static String ENTRY_URL = "http://the-internet.herokuapp.com/";
  WebDriver driver;

  @BeforeEach
  void setup() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to(ENTRY_URL);
  }
  @Ignore
  @Test
  @Order(1)
  public void openGoogle() {
    Assertions.assertEquals(ENTRY_URL, driver.getCurrentUrl(), "URL is correct");
  }

  @Ignore
  @Test
  @Order(2)
  public void doBasicAuthorization(){
    driver.findElement(By.cssSelector("#content > ul > li:nth-child(3) > a")).click();
    driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    Assertions.assertTrue(driver.findElement(By.cssSelector(".example > p:nth-child(2)")).getText().equals("Congratulations! You must have the proper credentials."));
  }

  @Test
  //@Order(3)
  public void findBrokenImages() {
    driver.findElement(By.cssSelector("#content > ul:nth-child(4) > li:nth-child(4) > a:nth-child(1) > a")).click();
    driver.get("http://the-internet.herokuapp.com/broken_images");
    List<WebElement> links = driver.findElements(By.tagName("img"));
    for (WebElement link : links) {
      Boolean result = isImage(driver, link);
      System.out.println(result);

    }}
  public boolean isImage(WebDriver driver, WebElement webElement) { {
      return (boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].tagName.toLowerCase() === 'img' && " +
              "arguments[0].complete && " +
              "typeof arguments[0].naturalWidth != 'undefined' && " +
              "arguments[0].naturalWidth > 0", webElement);
    }
    }





    //@Test
    //public void

  @AfterEach
  void finish() {
    driver.close();
  }

}

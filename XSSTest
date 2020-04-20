import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;


public class XSSTest {
    private static int noOfXSSTest = 6;
    private static int maxNoOfTags = 10;    // 1 to 10 tags
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\jykye\\Drivers\\Gecko_v0.26.0\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        System.out.println("start XSS Test");
        driver.get("https:localhost:8086");

        // click the link with name "press release"
        WebElement detailButton = driver.findElement(By.id("details-button"));
        detailButton.click();
        System.out.println("detail button click");
        WebElement goButton = driver.findElement(By.id("proceed-link"));
        goButton.click();
        System.out.println("gobutton click");

        //Check link
        WebElement contact = driver.findElement(By.xpath("//a[@href='contactUs.html']"));
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",contact);
        System.out.println("Contact click successfully");

        //WebElement iphoneBattery = driver.findElement(By.tagName("button"));
        Thread.sleep(3000);
        List<WebElement> links= driver.findElements(By.tagName("button"));
        for(int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i));

        }
        links.get(5).click();
        System.out.println("mac button clicked");

        Thread.sleep(1000);
        WebElement statusChat = driver.findElement(By.id("status"));
        System.out.println(statusChat.getText());
        while (statusChat.getText().equals("Finding/Waiting for an Agent")){
            System.out.println("waiting");
        }

        Thread.sleep(1000);
        WebElement testForm = driver.findElement(By.id("submission"));
        WebElement nextButton = driver.findElement(By.id("submit"));

        for(int i=0;i<noOfXSSTest;i++){
            Random rand = new Random();
            testForm.sendKeys(XSSGenerator.generateXSSGenerator(rand.nextInt(maxNoOfTags)+1));
            Thread.sleep(1000);
            nextButton.click();
            Thread.sleep(1000);
        }
    }
}

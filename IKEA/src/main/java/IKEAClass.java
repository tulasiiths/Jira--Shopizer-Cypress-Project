import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IKEAClass {
    public static void main(String[] args) {

     WebDriver driver =new ChromeDriver();
        driver.get("https://www.ikea.com/se/sv/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//button[text() = 'Acceptera cookies']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[text() = 'Bli medlem']")).click();

    }
}
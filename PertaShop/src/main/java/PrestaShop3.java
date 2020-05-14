import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PrestaShop3 {
    static WebDriver driver = new ChromeDriver();
    //explore back office
    @Test
    public void exploreBackOffice(){
        driver.get("http://demo.prestashop.com/#/en/front");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@class='btn btn-explore btn-visible-small btn-explore-bo']")).click();
        driver.switchTo().frame("framelive");
        driver.findElement(By.name("submitLogin")).click();
       // driver.findElement(By.xpath("//i[text()='close']")).click();
        driver.findElement(By.xpath("//a[@class='link']")).click();
       // driver.findElement(By.xpath("//i[text()='close']")).click();
        driver.findElement(By.id("subtab-AdminParentCustomer")).click();
        driver.findElement(By.xpath("//*[@id=\"subtab-AdminCustomers\"]/a")).click();
        driver.findElement(By.xpath("//i[@data-card-name='customers_card']")).click();
        driver.findElement(By.id("page-header-desc-configuration-add")).click();
        driver.findElement(By.id("customer_gender_id_0")).click();
        driver.findElement(By.name("customer[first_name]")).sendKeys("Tulasi");
        driver.findElement(By.name("customer[last_name]")).sendKeys("Chintala");
        driver.findElement(By.name("customer[email]")).sendKeys("tulasieee@gmail.com");
        driver.findElement(By.name("customer[password]")).sendKeys("iths123");
        driver.findElement(By.name("customer[birthday][year]")).sendKeys("1982");
        driver.findElement(By.name("customer[birthday][month]")).sendKeys("12");
        driver.findElement(By.name("customer[birthday][day]")).sendKeys("21");
        driver.findElement(By.xpath("//label[@for='customer_is_partner_offers_subscribed_1'][text()='Yes']")).click();
        driver.findElement(By.xpath("//div[@class='md-checkbox md-checkbox-inline']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary float-right']")).click();

    }
    @Test
    public void productCustomized(){
        driver.get("http://demo.prestashop.com/#/en/front");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().frame("framelive");
        driver.findElement(By.linkText("ART")).click();
        //driver.findElement(By.xpath("//p[text()='€15.00 - €41.00']")).click();
        //driver.findElement(By.xpath("//a[@class='ui-slider-handle ui-state-default ui-corner-all'][@style='left: 10%;']")).click();

        driver.findElement(By.xpath("//a[@class='ui-slider-handle ui-state-default ui-corner-all ui-state-hover']")).click();



    }
}

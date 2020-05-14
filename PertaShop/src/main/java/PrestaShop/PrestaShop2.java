package PrestaShop;

import com.sun.java.util.jar.pack.DriverResource;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PrestaShop2 {

    static WebDriver driver = new ChromeDriver();
//Change responsive from desktop icon to tab icon
    @Test
    public void userStory2()throws InterruptedException {
        driver.get("http://demo.prestashop.com/#/en/front");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='change-device tablet-h']//i[@class='material-icons']")).click();
        driver.findElement(By.xpath("//iframe[@id='framelive']")).click();

       driver.close();
    }
    // purchasing men clothes
    @Test
    //public void purchaseClothes() throws InterruptedException{
    public void purchaseClothes(){
        driver.get("http://demo.prestashop.com/#/en/front");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().frame("framelive");
        driver.findElement(By.linkText("CLOTHES")).click();
        driver.findElement(By.linkText("Men")).click();
        driver.findElement(By.xpath("//a[text()='Hummingbird printed t-shirt']")).click();
        driver.findElement(By.xpath("//button[@type='submit'][@class='btn btn-primary add-to-cart']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).sendKeys("Puroceed to checkout");
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//a[text()='Proceed to checkout']")).click();

        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.name("firstname")).sendKeys("Chintala");
        driver.findElement(By.name("lastname")).sendKeys("Tulasi Rao");
        driver.findElement(By.name("email")).sendKeys("info@v-tele.se");
        driver.findElement(By.name("password")).sendKeys("Aarush@1106");
        driver.findElement(By.name("birthday")).sendKeys("12/21/1982");
        driver.findElement(By.name("optin")).click();
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("psgdpr")).click();
        driver.findElement(By.name("continue")).click();
        driver.findElement(By.name("address1")).sendKeys("Huddinge");
        driver.findElement(By.name("postcode")).sendKeys("14144");
        driver.findElement(By.name("city")).sendKeys("Stockholm");
        driver.findElement(By.name("confirm-addresses")).click();
        driver.findElement(By.name("confirmDeliveryOption")).click();
        driver.findElement(By.name("payment-option")).click();
        driver.findElement(By.name("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.id("payment-confirmation")).click();


        //int size = driver.findElements(By.tagName("iframe")).size();
        //System.out.println(size);
       // driver.findElement(By.xpath("//a[text()='Proceed to checkout'][@class='btn btn-primary']")).click();
        //driver.findElement(By.linkText("PROCEED TO CHECKOUT")).click();


        //WebDriverWait wait = new WebDriverWait(driver,30);
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a']")));
       /* boolean status = element.isDisplayed();
        if (status)
        {
            System.out.println("Element is Displayed");
        }
        else
        {
            System.out.println("Element is not Displayed");
        }

        //driver.findElement(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a']")).click();
        //driver.findElement(By.linkText("MEN")).click();
        //driver.findElement(By.xpath("//a[text()='Men']")).click();

        //driver.findElement(By.xpath("//*[@id=\"category-4\"]/a")).click();*/

    }
    @Test
    public void contactUs(){
        driver.get("http://demo.prestashop.com/#/en/front");
        driver.manage().window().maximize();
        driver.switchTo().frame("framelive");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(7000);
        driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Webmaster')]")).click();
        driver.findElement(By.name("from")).sendKeys("tulasieee@gmail.com");
       // driver.findElement(By.xpath("//span[text()='Choose file']")).sendKeys("C:\\Users\\ITHS\\Desktop\\Software tester");
        driver.findElement(By.name("message")).sendKeys("Our products are too expensive");
        driver.findElement(By.name("submitMessage")).click();

        //driver.findElement(By.linkText("SEND")).click();

       // WebDriverWait wait = new WebDriverWait(driver,30);
       // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a']")));

    }
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
}


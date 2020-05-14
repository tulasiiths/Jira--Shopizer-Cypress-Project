package PrestaShop;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Pertashop {

        static WebDriver driver = new ChromeDriver();

        @BeforeClass
        public static void setUp() {
            System.out.println(" BeforeClass ... setup ");
            driver.get("http://demo.prestashop.com/#/en/front");

        }
        @Before
        public void goHome(){
            //System.out.println(" before....");
            driver.get("http://demo.prestashop.com/#/en/front");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        }
        //As a Customer I would like to select the products and add to Cart so that later I can able to Continue Shopping
    @Test()
    public void continueShopping()throws InterruptedException {

        driver.switchTo().frame("framelive");
        driver.findElement(By.linkText("CLOTHES")).click();
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.xpath("//a[text()='Hummingbird printed sweater']")).click();
        driver.findElement(By.xpath("//button[@type='submit'][@class='btn btn-primary add-to-cart']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-secondary'][text()='Continue shopping']")).click();
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/button")).click();
        driver.findElement(By.linkText("ACCESSORIES")).click();
       // driver.findElement(By.linkText("Stationery")).click();
        driver.findElement(By.xpath("//a[text()='Home Accessories']")).click();
        driver.findElement(By.xpath("//a[text()='Mug The adventure begins']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart'][@type='submit']")).click();
        driver.findElement(By.xpath("//a[text()='Proceed to checkout']")).click();
      //  driver.findElement(By.xpath("//a[@class='btn btn-primary']")).sendKeys("Puroceed to checkout");
         WebElement mugItem = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
         mugItem.click();
         driver.findElement(By.xpath("//a[@class='remove-from-cart']")).click();

        /*System.out.println("Return Type:"+mugItem.isDisplayed());
        //Assert.assertFalse(mugItem.isDisplayed());
        Assert.assertEquals("Mug Item has not removed from cart",mugItem.isDisplayed(),true);
        System.out.println("Mug item has been removed from Cart");*/
        //String expected ="successfully remove the product";
    }
    //As a Tech customer I would like to use different responsives so that I can able to Change responsive from desktop icon to tab icon
    @Test
    public void responsive()throws InterruptedException {

        WebElement tablet = driver.findElement(By.xpath("//a[@class='change-device tablet-h']//i[@class='material-icons']"));
        tablet.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement mobile = driver.findElement(By.xpath("//a[@class='change-device mobile']//i[@class='material-icons']"));
        mobile.click();
        driver.findElement(By.xpath("//iframe[@id='framelive']")).click();
        Assert.assertNotEquals("if fails Devices are equal responsive",tablet,mobile);
        System.out.println("Assert has passed because both devices are not equal responsive");
        //Assert.assertTrue(changeDevice.isDisplayed());
        //System.out.println("Return Type:"+tablet+ &&);
        //Assert.assertEquals(changeDevice.isDisplayed(),true);

        //System.out.println("Device responsive has been changed");

    }
    @Test
    public void verifyTitle()
    {
        driver.get("http://demo.prestashop.com/#/en/front");
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "PrestaShop Live Demo";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("Assert passed");
    }
    //As a Fashioner I would like to search(find) Men clothes so that I can able to purchasing men clothes very quickly
    @Test
    //public void purchaseClothes() throws InterruptedException{
    public void purchaseClothes(){

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
        driver.findElement(By.name("email")).sendKeys("tulasivision123@gmail.com");
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

        //driver.get(driver.getCurrentUrl());
        WebElement payment = driver.findElement(By.id("payment-confirmation"));
        payment.click();
       /* try{
            payment.click();
        }
        catch (StaleElementReferenceException e){
            payment = driver.findElement(By.id("payment-confirmation"));
            payment.click();
        }

        System.out.println("Return Type" + payment.isDisplayed());
        Assert.assertEquals("Payment has failed",payment.isDisplayed(),true);
        System.out.println("YOUR ORDER IS CONFIRMED");*/
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
    // As  a buyer I would like to send feedback or complaint to company organisation so that
    // I can able to get proper response from company
    @Test
    public void contactUs(){

        driver.switchTo().frame("framelive");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(7000);
        driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Webmaster')]")).click();
        driver.findElement(By.name("from")).sendKeys("tulasieee@gmail.com");
        // driver.findElement(By.xpath("//span[text()='Choose file']")).sendKeys("C:\\Users\\ITHS\\Desktop\\Software tester");
        driver.findElement(By.name("message")).sendKeys("Our products are too expensive");
        WebElement submit = driver.findElement(By.name("submitMessage"));
        submit.click();
        Assert.assertTrue("Submit message fail",true);
        //Assert.assertEquals("message Submitted succesful ",submit);
        System.out.println("message submitted successfully");

        //driver.findElement(By.linkText("SEND")).click();

        // WebDriverWait wait = new WebDriverWait(driver,30);
        // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a']")));

    }

    // As a Intrested Person I would like to create the account so that I can able to get the contact or see  the dashboard directly
    @Test
    public void exploreBackOffice(){

        driver.findElement(By.xpath("//a[@class='btn btn-explore btn-visible-small btn-explore-bo']")).click();
        driver.switchTo().frame("framelive");
        driver.findElement(By.name("submitLogin")).click();
         driver.findElement(By.xpath("//i[text()='close']")).click();// sometimes close screen is not getting
        driver.findElement(By.xpath("//a[@class='link']")).click();
         driver.findElement(By.xpath("//i[text()='close']")).click();// sometimes close screen is not getting
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
        WebElement save = driver.findElement(By.xpath("//button[@class='btn btn-primary float-right']"));
        save.click();
       /* System.out.println("Return type:" + save.isDisplayed());
        Assert.assertTrue("Customer data hasn't saved",true);
        System.out.println("customer created successfully");*/

    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }
    }


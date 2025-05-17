package DEMOQA_AutomationProject.Team.TO_DO_App;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.instrument.Instrumentation;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
 
public class To_DO_APP {
	WebDriverWait wait ;
    AndroidDriver driver;
 
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2"); 
        caps.setCapability("app", "C:\\Program Files\\todo.apk");
        caps.setCapability("autoGrantPermissions", true);
		caps.setCapability("noReset", false);
        
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }
    @Test(priority=1)
    public void Registration() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.findElement(AppiumBy.id("com.nweave.todo:id/application_logo")).click();
    	Thread.sleep(2000);
    	driver.findElement(AppiumBy.id("com.nweave.todo:id/task_list_setting_button")).click();
        Thread.sleep(1000);
       driver.findElement(AppiumBy.id("com.nweave.todo:id/txt_reg")).click();
       driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.nweave.todo:id/reg_username_edittext\"]")).sendKeys("yazanomari1@gmail.com");     
       driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.nweave.todo:id/reg_password_edittxt\"]")).sendKeys("Y12345azan@");
       driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.nweave.todo:id/reg_confirm_password_edittxt\"]")).sendKeys("Y12345azan@");
       driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"REGISTER\"]")).click();
       Thread.sleep(1500);
       driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.nweave.todo:id/okButton\"]")).click();
       driver.pressKey(new KeyEvent(AndroidKey.BACK));
       }
    
    @Test (priority=2)
    public void Login() throws InterruptedException
    {
    	wait=new WebDriverWait(driver,Duration.ofSeconds(8));
    	driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Synchronizing your ToDos\"]")).click();
    	Thread.sleep(1000);
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.nweave.todo:id/okButton\"]")).click();
    	Thread.sleep(2000);
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.nweave.todo:id/username_edittext\"]")).sendKeys("yazanomari1@gmail.com");
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.nweave.todo:id/password_edittxt\"]")).sendKeys("Y12345azan@");
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"LOGIN\"]")).click();

    	
    }
    @Test(priority=3)
    public void Add() throws InterruptedException {
    	
    	Thread.sleep(11000);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.nweave.todo:id/task_list_add_task_fab_button\"]")).click();
        Thread.sleep(2000);
       driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.nweave.todo:id/add_task_priority_low\"]")).click();
       driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.nweave.todo:id/add_task_name_edit_text\"]")).sendKeys("QA Tester");
       driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nweave.todo:id/reminder_state_textview\"]")).click(); 
       Thread.sleep(1000);
       driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Image Description\"]")).click();
       Thread.sleep(1000);
       driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.nweave.todo:id/okButton\"]")).click();
       driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.nweave.todo:id/repeated_state_textview\"]")).click();      
       driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Image Description\"]")).click();     
       driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.nweave.todo:id/okButton\"]")).click();  
       driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Image Description\"]")).click();
       driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.nweave.todo:id/tag_edit_text\"]")).sendKeys("@YazanOmari");
       driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.nweave.todo:id/okButton\"]")).click();
       Thread.sleep(2000);
       driver.findElement(AppiumBy.id("com.nweave.todo:id/starred_checkBox_status")).click();
       Thread.sleep(3000);
       driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.nweave.todo:id/add_task_done_button\"]")).click();
    }
    @Test(priority = 4)
    public void without_titel() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
 
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='com.nweave.todo:id/task_list_add_task_fab_button']")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='com.nweave.todo:id/add_task_priority_low']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/add_task_name_edit_text']")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='com.nweave.todo:id/add_task_done_button']")).click();
 
        boolean isErrorVisible = driver.findElements(By.xpath("//android.widget.TextView[@text='Please enter title']")).size() > 0;
        softAssert.assertTrue(isErrorVisible, "Error message should appear when title is empty");
 
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        softAssert.assertAll();
    }
 
    @Test(priority = 5)
    public void Invalid_titel() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
 
        Thread.sleep(11000);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='com.nweave.todo:id/task_list_add_task_fab_button']")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='com.nweave.todo:id/add_task_priority_low']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/add_task_name_edit_text']")).sendKeys("!@#1384");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.nweave.todo:id/add_task_done_button']")).click();
 
        boolean isErrorVisible = driver.findElements(By.xpath("//android.widget.TextView[@text='Invalid title']")).size() > 0;
        softAssert.assertTrue(isErrorVisible, "Invalid title error should appear");
 
        
        softAssert.assertAll();
    }
 
    @Test(priority = 6)
    public void Invaledusername_passw_Login() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
 
       
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Synchronizing your ToDos']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='com.nweave.todo:id/okButton']")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/username_edittext']")).sendKeys("yazanomari1gmail");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/password_edittxt']")).sendKeys("111324354res");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='LOGIN']")).click();
 
        boolean isError = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Invalid credentials']")).size() > 0;
        softAssert.assertTrue(isError, "Error should appear for invalid username/password");
 
        
        softAssert.assertAll();
    }
 
    @Test(priority = 7)
    public void Null_Login() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
 
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Synchronizing your ToDos']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='com.nweave.todo:id/okButton']")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/username_edittext']")).sendKeys("");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/password_edittxt']")).sendKeys("");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='LOGIN']")).click();
 
        boolean isError = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Invalid credentials']")).size() > 0;
        softAssert.assertTrue(isError, "Error should appear for null credentials");
 
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        softAssert.assertAll();
    }
 
    @Test(priority = 8)
    public void incorrect_username_Login() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
 
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Synchronizing your ToDos']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.nweave.todo:id/okButton']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/username_edittext']")).sendKeys("yazanomari9gmail.com");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/password_edittxt']")).sendKeys("111324354res");
        driver.findElement(By.xpath("//android.widget.Button[@text='LOGIN']")).click();
 
        boolean isError = driver.findElements(AppiumBy.xpath("//android.widget.Button[@resource-id='com.nweave.todo:id/okButton']")).size() > 0;
        softAssert.assertTrue(isError, "Error alert should appear for incorrect email format");
 
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        softAssert.assertAll();
    }
 
    @Test(priority = 9)
    public void Null_username_Login() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
 
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Synchronizing your ToDos']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.nweave.todo:id/okButton']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/username_edittext']")).sendKeys("");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.nweave.todo:id/password_edittxt']")).sendKeys("111324354res");
        driver.findElement(By.xpath("//android.widget.Button[@text='LOGIN']")).click();
 
        boolean isError = driver.findElements(AppiumBy.xpath("//android.widget.Button[@resource-id='com.nweave.todo:id/okButton']")).size() > 0;
        softAssert.assertTrue(isError, "Error should appear when username is empty");
 
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        softAssert.assertAll();
    }
    @AfterTest
   public void tearDown() {
       if (driver != null) {
           driver.quit();
        }
    }
}

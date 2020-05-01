package My_stepDefination;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
public class stepDefination {
	 WebDriver driver;
	 @Given("^User is on Gmail Signin screen$")
	    public void user_is_on_gmail_signin_screen() throws Throwable {
		 System.setProperty("webdriver.gecko.driver", "D:\\Geko driver\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.get("https://www.gmail.com");
		 Thread.sleep(4000);
	    }

	 @When("^User is entering user name \"([^\"]*)\"$")
	    public void user_is_entering_user_name_something(String strArg1) throws Throwable {
	    WebElement email_id = driver.findElement(By.cssSelector("input[type='email']"));	
	    email_id.sendKeys(strArg1);
	    WebElement emailnxt_button = driver.findElement(By.id("identifierNext"));
	    emailnxt_button.click();
	    Thread.sleep(4000);
	   
	    }
	    
	 @And("^User is entering password \"([^\"]*)\"$")
	    public void user_is_entering_password_something(String strArg1) throws Throwable {
	    	WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
	    	password.sendKeys(strArg1);
	    	WebElement passnxt_button = driver.findElement(By.id("passwordNext"));
	        passnxt_button.click();
	        Thread.sleep(12000);
	    }

	    @Then("^User should see the Gmail inbox screen$")
	    public void user_should_see_the_gmail_inbox_screen() throws Throwable {
	    	/*WebElement profile =  driver.findElement(By.xpath("//*[@class='S0f1M kr'][contains(text(),'Sourav')]"));
	    	if(profile.getText().equalsIgnoreCase("Sourav"));
	    	{
	    		System.out.println("Succefully Signed in into Gmail");
	    	}*/
	    	
	    	WebElement mails = driver.findElement(By.xpath("//*[contains(text(),'Inbox')]"));
	    	String mailType = mails.getText();
	    	WebElement count = driver.findElement(By.xpath("//*[contains(text(),'Inbox')]/ancestor::div[@class='aio UKr6le']/div[@class='bsU']"));
	    	String mailCount = count.getText();
	    	System.out.println(mailType);
	    	System.out.println(mailCount);
	        
	    }

	    @And("^User should see all my mails listed under Gmail$")
	    public void user_should_see_all_my_mails_listed_under_gmail() throws Throwable {
	    	
	    	System.out.println("Sussessfully signed in to Gmail");
	    	System.out.println("I successfully signed in");
	    	System.out.println("Git experiment");
	    	System.out.println("It's working as execpted");
	    	System.out.println("All is well");
	    }

}

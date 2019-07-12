package Team4.Cucu;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;

public class StepDef {
	WebDriver driver;
	@Given("^launch TestMe$")
	public void launch_TestMe() throws Throwable {
		 driver=Utility.startBrowser("Chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}

	@Given("^login with user credentials$")
	public void login_with_user_credentials(DataTable dt) throws Throwable {
		 driver.findElement(By.linkText("SignUp")).click();
		 List<Map<String,String>> list = dt.asMaps(String.class, String.class);
			for(int i=0;i<list.size();i++)
			{
				driver.findElement(By.name("userName")).sendKeys(list.get(i).get("userName"));
				driver.findElement(By.name("firstName")).sendKeys(list.get(i).get("firstName"));
				driver.findElement(By.name("lastName")).sendKeys(list.get(i).get("lastName"));
				driver.findElement(By.name("password")).sendKeys(list.get(i).get("password"));
				driver.findElement(By.name("confirmPassword")).sendKeys(list.get(i).get("confirmPassword"));
				driver.findElement(By.xpath("//input[@type='radio' and @value='Female']")).click();
				driver.findElement(By.name("emailAddress")).sendKeys(list.get(i).get("emailAddress"));
				driver.findElement(By.name("mobileNumber")).sendKeys(list.get(i).get("mobileNumber"));
				driver.findElement(By.name("dob")).sendKeys(list.get(i).get("dob"));
				driver.findElement(By.name("address")).sendKeys(list.get(i).get("address"));
				Select s = new Select(driver.findElement(By.name("securityQuestion")));
				s.selectByIndex(0);
				driver.findElement(By.name("answer")).sendKeys(list.get(i).get("answer"));
			}
			driver.findElement(By.name("Submit")).click();
	}

	@When("^registration is done$")
	public void registration_is_done() throws Throwable {
		 System.out.println("User successfully registered");
	}

	@Then("^user must be in the login page$")
	public void user_must_be_in_the_login_page() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.close();
	}


}

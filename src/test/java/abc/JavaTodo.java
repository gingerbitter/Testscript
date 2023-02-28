package abc;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class JavaTodo {
	    String username = "vanishree.bhavanur";
	    String accesskey = "CLNAk7uxVnVkaKZrixAhGITIYzAq5FjshDfUd2fdQVdu5aPiSw";
	    static RemoteWebDriver driver = null;
	    String gridURL = "@hub.lambdatest.com/wd/hub";
	    boolean status = false;
	    public static void main(String[] args) {
	        new JavaTodo().testWin10();
	        new JavaTodo().testWin11();
	    }
	    @Test
	    public void testWin10() {
	        // To Setup driver
	        setUp();     
	              //Change it to production page
	            driver.get("https://www.saucedemo.com/");
	    		driver.findElement(By.id("user-name")).sendKeys("standard_user");   
	    		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    		driver.findElement(By.id("login-button")).click();	    	    		
	        }
	    
	    @Test
	    public void testWin11() {
	        // To Setup driver
	        setUp1();     
	              //Change it to production page
	            driver.get("https://www.saucedemo.com/");
	    		driver.findElement(By.id("user-name")).sendKeys("standard_user");   
	    		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    		driver.findElement(By.id("login-button")).click();	    	    		
	        }    

	    private void setUp() {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", "chrome");
	        capabilities.setCapability("version", "70.0");
	        capabilities.setCapability("platform", "Windows 10"); // If this cap isn't specified, it will just get any available one.
	        capabilities.setCapability("build", "LambdaTestSampleApp");
	        capabilities.setCapability("name", "LambdaTestJavaSample");
	        try {
	            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	        } catch (MalformedURLException e) {
	            System.out.println("Invalid grid URL");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    
	    private void setUp1() {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", "chrome");
	        capabilities.setCapability("version", "70.0");
	        capabilities.setCapability("platform", "Windows 11"); // If this cap isn't specified, it will just get any available one.
	        capabilities.setCapability("build", "LambdaTestSampleApp");
	        capabilities.setCapability("name", "LambdaTestJavaSample");
	        try {
	            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	        } catch (MalformedURLException e) {
	            System.out.println("Invalid grid URL");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }	    	    
	    private void tearDown() {
	        if (driver != null) {
	            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
	            driver.quit(); //really important statement for preventing your test execution from a timeout.
	        }
	    }
	}


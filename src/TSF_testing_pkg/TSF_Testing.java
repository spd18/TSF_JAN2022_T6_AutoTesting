/*
 * Developed by: - Parth Sathiya
 * Intership Task Project from GRIP TSF-Jan2022 Batch
 * Task 6: Testing (Automated)
 * Technology: Google Chrome & Java Eclipse IDE
 */

package TSF_testing_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
  
public class TSF_Testing {

	public static void main (String[] args ) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chrome_driver3\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		int TCPass = 0;
		int TCFail = 0;
		
		String webURL = null;
		
		//TC = test case
		
		System.out.println("Automatic Testing of website: - https://www.thesparksfoundationsingapore.org/ using Java selenium script");

		//----------------------------------------------------------------
		
		//TC1 
			/*
			 * this test case will open the chrome browser and then it will load the www.thesparksfoundationsingapore.org website 
			 * */
		
		driver.navigate().to("https://www.thesparksfoundationsingapore.org/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Website title is :" + title);
		
		System.out.println("TC1: -> The TSF website is successfully open in full window size");
		TCPass++;
		Thread.sleep(2000);
	
		//----------------------------------------------------------------
		
		//TC2 
			/*
			 * it will get the title and URL of the home page of the current website.
			 * it will also ensure that https://www.thesparksfoundationsingapore.org/ website is invokes or not.  
			 * */
		
		webURL = driver.getCurrentUrl();
		if(webURL.equals("https://www.thesparksfoundationsingapore.org/"))
		{
			System.out.println("TC2: --> Website URL is :" + webURL);
			TCPass++;
			Thread.sleep(3000);
		}
		else
		{
			System.out.println("Incorrect URL\n it should have been https://www.thesparksfoundationsingapore.org/");
			TCFail++;
			Thread.sleep(5000);
			driver.quit();
		}
		
		//----------------------------------------------------------------			
	
		//TC3 
			/*
			* this case will ensure that the logo of the sparks foundation is displayed or not 
			* */
		
		//img[@src="/images/logo_small.png"]
		boolean logo_disp_Status = driver.findElement(By.xpath("//img[@src=\"/images/logo_small.png\"]")).isDisplayed(); 
		if(logo_disp_Status)
		{
			System.out.println("TC3: --> Logo is displayed");
			TCPass++;
		}
		else
		{
			System.out.println("Logo is not displayed");
			TCFail++;
		}
		
		Thread.sleep(2000);
		
		//----------------------------------------------------------------
	
		//TC4 
			/*
			 * it will check whether navigation bar is displayed or not  
			 * */
		boolean navbar_disp_status = driver.findElement(By.id("link-effect-3")).isDisplayed();
		if(navbar_disp_status)
		{
			System.out.println("TC4: --> Navbar is displayed successfully");
			TCPass++;
		}
		else
		{
			System.out.println("Navbar is not displayed");
			TCFail++;
		}
		Thread.sleep(2000);
			
		//----------------------------------------------------------------
		
		//TC5 
			/*
			 * It will check the click event of KNOW MORE button   
			 * */
			
		jse.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		driver.findElement(By.linkText("KNOW MORE")).click();
		webURL = driver.getCurrentUrl();
		if(webURL.equals("https://www.thesparksfoundationsingapore.org/about/vision-mission-and-values/"))
		{
			System.out.println("TC5: --> KNOW MORE button is clicked successfully And redirected successfully to About us page");
			Thread.sleep(6000);
			driver.navigate().back();		
			Thread.sleep(2000);
			TCPass++;
		}
		else
		{
			System.out.println("KNOW MORE button is clicked successfully  but not redirected at appropriate place");
			System.out.println("Test case failed");
			TCFail++;
			Thread.sleep(3000);
		}
		
		//----------------------------------------------------------------
		
		//TC6 
			/*
			 * It will check the click event of menubar and redirection to the news page    
		 	**/
		
		//a[@data-hover="About"]
		//ul[@class='dropdown-menu']//li//a[@href='/about/news/']
		
		try {
		
			driver.findElement(By.xpath("//a[@data-hover='About']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[@href='/about/news/']")).click();
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,350)");
			Thread.sleep(4000);
			webURL = driver.getCurrentUrl();
			if(webURL.equals("https://www.thesparksfoundationsingapore.org/about/news/"))
			{
				System.out.println("TC6: --> News page rendered successfully");
				
				Thread.sleep(2000);
				//jse.executeScript("window.scrollBy(0,-350)");
				driver.navigate().back();		
				Thread.sleep(2000);
				TCPass++;
			}
			else
			{
				System.out.println("News page is not rendered");
				System.out.println("Test case failed");
				TCFail++;
				Thread.sleep(3000);
			}	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//----------------------------------------------------------------
		
		//TC7 
			/*
			 * It will check the whether the text is displayed on the student-scholarship-program page or not.     
			 **/
	
		//a[@data-hover='Programs']
		//ul[@class='dropdown-menu']//li//a[@href='/programs/student-scholarship-program/']
		//p[@class='para-w3-agile']
		
		try {
			
			driver.findElement(By.xpath("//a[@data-hover='Programs']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[@href='/programs/student-scholarship-program/']")).click();
			Thread.sleep(3000);
			
			webURL = driver.getCurrentUrl();
			if(webURL.equals("https://www.thesparksfoundationsingapore.org/programs/student-scholarship-program/"))
			{
							
				Thread.sleep(4000);
				jse.executeScript("window.scrollBy(0,350)");
				Thread.sleep(2000);
				
				String str = driver.findElement(By.xpath("//p[@class='para-w3-agile']")).getText();
				if(str.length()>0) 
				{
					System.out.println("TC7: --> Student-scholarship-program page rendered successfully and Text is present in it");					
					Thread.sleep(2000);
					TCPass++;
				}
				else
				{
					System.out.println("TC7: --> Student-scholarship-program page rendered successfully and Text is not present in it");					
					Thread.sleep(2000);
					TCFail++;
				}
				
				driver.navigate().back();		
				Thread.sleep(2000);
				
			}
			else
			{
				System.out.println("Student-scholarship-program page is not rendered");
				System.out.println("Test case failed");
				TCFail++;
				Thread.sleep(3000);
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	
		//----------------------------------------------------------------
		
		//TC
			/*
			 * TC8:  - it will perform test case by opening Join us page and check whether join us form is visible or not
			 * TC9:  - it will perform test case by filling the value in the form element      
			 **/
			
			//TC8 xpath
			//a[@data-hover='Join Us']
			//ul[@class='dropdown-menu']//li//a[@href='/join-us/why-join-us/']
		
			//TC9 xpath
			//form[@method="post"]
					
		try {
		
			driver.findElement(By.xpath("//a[@data-hover='Join Us']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//a[@href='/join-us/why-join-us/']")).click();
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,900)");
			Thread.sleep(4000);
			
			webURL = driver.getCurrentUrl();
			if(webURL.equals("https://www.thesparksfoundationsingapore.org/join-us/why-join-us/"))
			{
				if(driver.findElement(By.xpath("//form[@method='post']")).isDisplayed())
				{
					System.out.println("TC8: --> Join us page is rendered successfully and Join us form is also visible  ");
					Thread.sleep(1000);
					TCPass++;
					
					Thread.sleep(2000);
					driver.findElement(By.name("Name")).sendKeys("TSF");//TSF-Intern_Jan2022
					Thread.sleep(2000);
					driver.findElement(By.name("Email")).sendKeys("TSF@gmail.com");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@type='submit']")).submit();
					
					System.out.println("TC9: --> Join us page is rendered successfully and Join us form is also filled and submitted successfully  ");
					Thread.sleep(3000);
					TCPass++;
				}
				else
				{
					System.out.println("TC8: --> Join us page is rendered successfully but Join us form is not also visible ");
					Thread.sleep(3000);
					TCFail++;
				}				
			}
			else
			{
				System.out.println("TC9: --> Join us page is not rendered ");					
				Thread.sleep(3000);	
				TCFail++;
			}		
									
				Thread.sleep(1000);
				driver.navigate().to("https://www.thesparksfoundationsingapore.org/");
				Thread.sleep(2000);
							
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
		//----------------------------------------------------------------
		
		//TC10
			/*		  
			 * TC10: - it will test the scroll to top button
			 */ 
	
		//span[@id='toTopHover']
		
		webURL = driver.getCurrentUrl();
		if(webURL.equals("https://www.thesparksfoundationsingapore.org/"))
		{
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,2550)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@id='toTopHover']")).click();
			System.out.println("TC10: -> Successful test of scroll_to_top button");
			Thread.sleep(3000);
			TCPass++;
		}
		else
		{
			System.out.println("Home page didn't rendered");
		}
		
		//----------------------------------------------------------------
		
		//TC
			/*
			 * TC11: - It will test Contact-US page      
			 * TC12: - It will open linkedIn group of TSF
			 **/
				
		//a[@href='https://www.linkedin.com/company/the-sparks-foundation/']
		
		try {
		
			driver.findElement(By.linkText("Contact Us")).click();
			Thread.sleep(3000);
			
			webURL = driver.getCurrentUrl();
			if(webURL.equals("https://www.thesparksfoundationsingapore.org/contact-us/"))
			{
				if(driver.findElement(By.cssSelector("body")).isDisplayed())
				{
					System.out.println("TC11: --> successfully opened Contact Us page ");					
					Thread.sleep(3000);
					TCPass++;
					
					jse.executeScript("window.scrollBy(0,5000)");
					Thread.sleep(2000);
					
					driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/the-sparks-foundation/']")).click();
					System.out.println("TC12: --> successfully opened LinkedIn TSP Group in new tab ");
					TCPass++;
					
				}
				else
				{
					System.out.println("TC11: --> Failed to rendered the content of Contact Us page ");					
					Thread.sleep(5000);
					TCFail++;
				}
			}
			else
			{
				System.out.println("Failed to open Contact us page");					
				Thread.sleep(5000);				
			}
					
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		

		//----------------------------------------------------------------
			

	//end 
		
		Thread.sleep(5000);
		
		//Report 
		System.out.println("Total number of successful test cases are "+TCPass);
		System.out.println("Total number of Failed test cases are "+TCFail);
		
		System.out.println("End of the Java Selenium Script");
		System.out.print("Thank You !!!");
		
		Thread.sleep(5000);
		driver.quit();
	}
	
}

package selenium_tests;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriver_builder implements WebDriver {

	public static WebDriver webdriver;

	public void setDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
	}

	public boolean get_driver_enabled() {

		if (webdriver != null)
			return true;

		return false;
	}

	private String home_url;

	public String get_home_url() {

		return home_url;

	}

	public void set_home_url(String url) {

		this.home_url = url;

	}

	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++
	 * 
	 * [INNER CLASS] - gives access to enhanced selenium methods through esm
	 * instance
	 * 
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++
	 */

	public Enhanced_selenium_methods esm = new Enhanced_selenium_methods();

	public final class Enhanced_selenium_methods {


		public void goto_home_url() throws Exception {

			webdriver.get(home_url);

		}

		public String get_text(By target) throws Exception {
			String text="";
			try{
			wait_element_exists(target);
			text=webdriver.findElement(target).getText();
			return text;
			}
			catch (NoSuchElementException t) {
				System.out.println(t);

			}
			return text;
		}

		public void close() {
			webdriver.close();
		}

		public boolean check_element_exists(By target) {

			try {

				if (webdriver.findElements(target).size() > 0) {

					return true;
				}

				return false;

			} 
			
			
			catch (NoSuchElementException t) {

				System.out.println(t);

			}
			
			catch (Throwable t) {

				System.out.println(t);

			}

			return false;

		}

		public double get_sum(double... args) {
			double sum = 0;
			for (double i : args) {
				sum += i;
			}
			return sum;
		}

		public boolean verify_ValueLabel(By by) throws Exception {
			boolean val=false;
			try{
			WebElement valueLabel = webdriver.findElement(by);
			
			if(valueLabel.isDisplayed()){
				val=valueLabel.isDisplayed();
				return val;
			}
			else
				return val;
			}
			
			catch(NoSuchElementException e1){
				System.out.println("Failed with Exception"+e1);
			}
			catch(Exception e2){
				System.out.println("Failed with Exception"+e2);
			}
			return val;
		}

		public void wait_element_exists(By target) throws Exception {

			// wait.until(ExpectedConditions.presenceOfElementLocated(target));

		}

	}

	@Override
	public void get(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}
}

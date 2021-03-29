package selenium_tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;

@CucumberOptions( 
		
		features = "src/test/resources/features/",
		glue={"selenium_tests"},
		tags={" @tag1"}
	
		)
public class Runner {

	public static ThreadLocal<Webdriver_builder> driver = new ThreadLocal<Webdriver_builder>();
	

	
	@BeforeClass(alwaysRun = true)
	@Parameters({})
	public void setup(
			
			) throws Exception{


		driver.get().set_home_url("https://www.exercise1.com/values");

		}

	}
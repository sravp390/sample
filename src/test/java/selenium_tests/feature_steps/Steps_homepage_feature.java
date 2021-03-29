package selenium_tests.feature_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium_tests.page_object_model.*;

import org.testng.Assert;
import org.testng.Reporter;

import static selenium_tests.Runner.driver;

import java.util.ArrayList;

public class Steps_homepage_feature {

	double dol1;
	double dol2;
	double dol3;
	double dol4;
	double dol5;

	String doll_val1;
	String doll_val2;
	String doll_val3;
	String doll_val4;
	String doll_val5;

	/***
	 * Author: Sravani 
	 * Method Description: Launching of the application url
	 * CreatedBy:
	 * CreatedOn:
	 * 
	 */

	@Given("^customer is on homepage$")
	public void customer_is_on_homepage() throws Throwable {

		driver.get().esm.goto_home_url();
		//driver.get().esm.delete_cookies();
	}

	/***
	 * Author: Sravani 
	 * Method Description: Page Verification After the
	 * application Launch
	 */

	@When("verify that core control is displayed")
	public void verify_that_core_control_is_displayed() throws Exception {

		
		Assert.assertTrue(driver.get().esm.verify_ValueLabel(POM_homepage.WebElementValue1));
		
	}
	
	/***
	 * Method Description: Verification of values in Currencies
	 * Created On:
	 * Created By:Sravani
	 */


	@When("Verify values are displayed in Currencies")
	public void Verify_values_are_displayed_are_Currencies() {
		try {
			ArrayList<String> list = new ArrayList<>();
			list.add(doll_val1);
			list.add(doll_val2);
			list.add(doll_val3);
			list.add(doll_val4);
			list.add(doll_val5);
			for (String str : list) {
				if (str.contains("$"))
					Reporter.log("Currency Verified Successfull" + str);
				else
					Reporter.log("Currency Verified Not Successfull" + str);
			}
		} catch (Exception e) {
			Reporter.log("Failed with Exception" + e.getMessage());
		}

	}

	/***
	 * Method Description: Verification of Values Greater than zero
	 * Created On:
	 * Created By:Sravani
	 */
	
	@When("I verify Values Greater than Zero")
	public void I_verify_Values_Greater_than_Zero() {
		ArrayList<Double> list = new ArrayList<>();
		list.add(dol1);
		list.add(dol2);
		list.add(dol3);
		list.add(dol4);
		list.add(dol5);
		try {
			for (double a : list) {
				if (a > 0) {
					Reporter.log("The value is Greater than zero");
				} else
					Reporter.log("The value is less than zero or negative");
			}
		} catch (ArithmeticException  e1 ) {
			System.out.println("failed due to exception"+e1.getMessage());
		}
	catch (Exception e) {
		System.out.println("failed due to exception"+e.getMessage());
	} 
	}
	
	/***
	 * Method Description: Caluculate the Sum of Amounts
	 * Created On:
	 * Created By:Sravani
	 */

	@Then("When I Calculate the sum of all the values and verify with the Excepted Total")
	public void When_I_Calculate_the_sum_of_all_thevalues() {

		try {
			String doll_val1 = driver.get().esm.get_text(POM_homepage.WebElementValue1);
			String doll_val2 = driver.get().esm.get_text(POM_homepage.WebElementValue2);
			String doll_val3 = driver.get().esm.get_text(POM_homepage.WebElementValue3);
			String doll_val4 = driver.get().esm.get_text(POM_homepage.WebElementValue4);
			String doll_val5 = driver.get().esm.get_text(POM_homepage.WebElementValue5);

			String value1 = driver.get().esm.get_text(POM_homepage.WebElementValue1).replace("$", "");
			String value2 = driver.get().esm.get_text(POM_homepage.WebElementValue2).replace("$", "");
			String value3 = driver.get().esm.get_text(POM_homepage.WebElementValue3).replace("$", "");
			String value4 = driver.get().esm.get_text(POM_homepage.WebElementValue4).replace("$", "");
			String value5 = driver.get().esm.get_text(POM_homepage.WebElementValue5).replace("$", "");

			String TotBalance = driver.get().esm.get_text(POM_homepage.WebElementTotalSum).replace("$", "");

			double dol1 = Double.parseDouble(value1);
			double dol2 = Double.parseDouble(value2);
			double dol3 = Double.parseDouble(value3);
			double dol4 = Double.parseDouble(value4);
			double dol5 = Double.parseDouble(value5);
			double sum = driver.get().esm.get_sum(dol1, dol2, dol3, dol4, dol5);
			double TotBalanceUi = Double.parseDouble(TotBalance);

			if (Double.compare(sum, TotBalanceUi) == 0) {

				System.out.println("Sum=TotBalanceUi");
			} else if (Double.compare(sum, TotBalanceUi) < 0) {

				System.out.println("sum<TotBalanceUi");
			} else {

				System.out.println("sum>TotBalanceUi");
			}
			
		}
			catch (NumberFormatException e1) {
				  System.out.println("Failed due to number Format Exception");
				}

		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/***
	 * Method Description: Checking Key Elements on the WebPage
	 * Created On:
	 * Created By:Sravani
	 */

	@Then("all key homepage elements are shown")
	public void all_key_homepage_elements_are_shown() throws Exception {

		Assert.assertTrue(driver.get().esm.check_element_exists(POM_homepage.WebElementLabel1));
		Assert.assertTrue(driver.get().esm.check_element_exists(POM_homepage.WebElementLabel2));
		Assert.assertTrue(driver.get().esm.check_element_exists(POM_homepage.WebElementLabel3));
		Assert.assertTrue(driver.get().esm.check_element_exists(POM_homepage.WebElementLabel4));
		Assert.assertTrue(driver.get().esm.check_element_exists(POM_homepage.WebElementLabel5));
		Assert.assertTrue(driver.get().esm.check_element_exists(POM_homepage.WebElementTotalBalanceLabel));
		
	}
	
	
	/***
	 * Method Description: Closing the Driver
	 * Created On:
	 * Created By:Sravani
	 */
	
	@Then("Close the Driver")
		public void Close_the_driver(){
		
		driver.get().esm.close();
		}
	
	
	
	

}

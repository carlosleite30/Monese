package mavenproject;

import org.junit.*;
import static org.junit.Assert.*;

public class PositiveTest extends GenericMethods {
	public StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		openBrowser();
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		navigate("https://monese.com/");
		waitForObject(OR.getProperty("link_Help"));
		click(OR.getProperty("link_Help"));
		waitForObject(OR.getProperty("link_Faqs"));
		click(OR.getProperty("link_Faqs"));
		waitForObject(OR.getProperty("txt_search"));
		click(OR.getProperty("txt_search"));
		sendKeys(OR.getProperty("txt_search"), "Login");
		enter(OR.getProperty("txt_search"));
		waitForObject(OR.getProperty("list_results"));
		validateResultList(OR.getProperty("txt_results"), OR.getProperty("list_results"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

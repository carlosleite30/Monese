package mavenproject;

import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NegativeTest extends GenericMethods{
public StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		openBrowser();
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		navigate("https://monese.com/");
		waitForObject(OR.getProperty("button_SignUp"));
		click(OR.getProperty("button_SignUp"));
		waitForObject(OR.getProperty("txt_email"));
		click(OR.getProperty("txt_email"));
		sendKeys(OR.getProperty("txt_email"), "abc@abc");
		click(OR.getProperty("checkBox_email"));
		click(OR.getProperty("button_email"));
		validateElementVisible(OR.getProperty("error_msg"));
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

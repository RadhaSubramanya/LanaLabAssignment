package com.lanalabs.steps;

import org.apache.log4j.Logger;
import org.junit.Assert;
import net.thucydides.core.annotations.Step;

public class LoginSteps extends LanaLabsSteps {
	public static Logger log = Logger.getLogger(LoginSteps.class);

	
	@Step
	public void login(String userName, String password){
		loginPage.userNameTextField().sendKeys(userName);
		log.info("Entered UserName : "+ userName);
		loginPage.passwordTextField().sendKeys(password);
		log.info("Entered Password : "+ password);
		loginPage.signInButton().click();
		log.info("Clicked on Sign In Button ");
		Assert.assertTrue(verifyLoginSuccessful());
		log.info("Verified Login Successful");
	}
	
	@Step
	public boolean verifyLoginSuccessful() {
		return modelViewPage.chooseALogPopupTitle().isDisplayed();
	}
	
	@Step
	public void LogoutVerification() {
		Assert.assertTrue(loginPage.centerLogo().isDisplayed());
		log.info("Verified Logout Page Logo displayed");
		Assert.assertTrue(loginPage.SignInAsDifferentUserLink().isDisplayed());
		log.info("Verified Display of Signin as Different User Link");

	}
	
	
}

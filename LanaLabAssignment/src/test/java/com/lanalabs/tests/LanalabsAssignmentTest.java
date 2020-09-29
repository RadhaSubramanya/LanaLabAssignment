package com.lanalabs.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.lanalabs.steps.LoginSteps;

import junit.framework.Assert;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LanalabsAssignmentTest extends LanaLabsTests {
	
	@Managed
	public WebDriver webdriver;
	
	@Test
	public void verifyCountryCount() {
		loginSteps.login(config.userName, config.password);
		modalViewSteps.selectExistingLogFromChooseALogPopup("Incident_Management");
		modalViewSteps.selectFilterMenuOptions("Filter attributes");
		modalViewSteps.selectAFilterInPopup("Country");
		modalViewSteps.selectOptioninCountryGraphAndValidateTheCount("Austria");
		modalViewSteps.logout();
		loginSteps.LogoutVerification();
	}
}